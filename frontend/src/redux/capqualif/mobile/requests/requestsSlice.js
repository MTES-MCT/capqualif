import { createSlice } from '@reduxjs/toolkit';
import axios from 'axios';

const initialState = {
  requestor: {
    numeroDeMarin: '',
    firstName: '',
    lastName: '',
  },
  requestedTitre: '',
  startDate: '',
  requestStatus: '',
  instructionStatus: '',
  documents: [],
};

const requestsSlice = createSlice({
  name: 'requests',
  initialState,
  reducers: {
    addRequestorAndStartDate(state, action) {
      state.requestor.numeroDeMarin = action.payload.numeroDeMarin;
      state.requestor.firstName = action.payload.firstName;
      state.requestor.lastName = action.payload.lastName;
      /**
       * TODO: add today's date
       * */
      state.startDate = '';
    },
    addRequestedTitle(state, action) {
      state.requestorFirstName = action.payload;
    },
    addStartDate(state, action) {},
    addStatus(state, action) {
      state.status = action.payload;
    },
    addDocuments(state, action) {
      /**
       ** Here, action.payload is :
       ** {
       **conditionId: ''
       **conditionName: ''
       **conditionDocuments: []
       **}
       */
      const { conditionId } = action.payload;
      const { documents } = state;
      if (isConditionAlreadyInTheArray(documents, conditionId)) {
        const newDocuments = action.payload.conditionDocuments;
        updateDocuments(documents, conditionId, newDocuments);
      } else {
        documents.push(action.payload);
      }
    },
  },
});

const isConditionAlreadyInTheArray = (array, value) => {
  return findConditionIndex(array, value) !== -1 ? true : false;
};

const updateDocuments = (documents, conditionId, newDocuments) => {
  documents[
    findConditionIndex(documents, conditionId)
  ].conditionDocuments = newDocuments;
};

const findConditionIndex = (array, value) => {
  return array.findIndex((doc) => doc.conditionId === value);
};

export const { addRequestorAndStartDate, addDocuments } = requestsSlice.actions;

export default requestsSlice.reducer;