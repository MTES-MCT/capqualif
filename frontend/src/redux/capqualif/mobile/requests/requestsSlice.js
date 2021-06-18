import { createSlice } from '@reduxjs/toolkit';
import axios from 'axios';

const initialState = {
  requestor: {
    firstName: '',
    lastName: '',
  },
  requestedTitre: '',
  startDate: '',
  status: '',
  documents: [],
};

const requestsSlice = createSlice({
  name: 'requests',
  initialState,
  reducers: {
    addRequestor(state, action) {
      state.requestor = action.payload;
    },
    addRequestedTitle(state, action) {
      state.requestorFirstName = action.payload;
    },
    addStartDate(state, action) {
      state.startDate = action.payload;
    },
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
        state.documents[
          findConditionIndex(documents, conditionId)
        ].conditionDocuments = action.payload.conditionDocuments;
      } else {
        state.documents.push(action.payload);
      }
    },
  },
});

const isConditionAlreadyInTheArray = (array, value) => {
  return findConditionIndex(array, value) !== -1 ? true : false;
};

const findConditionIndex = (array, value) => {
  return array.findIndex((doc) => doc.conditionId === value);
};

export const { addDocuments } = requestsSlice.actions;

export default requestsSlice.reducer;
