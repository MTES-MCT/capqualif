import { createSlice } from '@reduxjs/toolkit';
import axios from 'axios';
import { findIndex } from '../../../../app/utils';

const initialState = {
  requestor: {
    numeroDeMarin: '',
    firstName: '',
    lastName: '',
  },
  possibleRequests: [],
};

const requestsSlice = createSlice({
  name: 'requests',
  initialState,
  reducers: {
    createRequest(state, action) {
      state.requestor.numeroDeMarin = action.payload.requestor.numeroDeMarin;
      state.requestor.firstName = action.payload.requestor.firstName;
      state.requestor.lastName = action.payload.requestor.lastName;
      state.possibleRequests.push({
        requestedTitreId: action.payload.titreId,
        startDate: '',
        requestStatus: '',
        instructionStatus: '',
        documents: [],
        canBeSent: false,
      });
    },
    cleanRequests(state) {
      state.possibleRequests = [];
    },
    /**
     * TODO : refactor state.
     * */
    addStartDate(state, action) {
      const today = new Date().toDateString();
      state.possibleRequests[
        findIndex(state.possibleRequests, 'requestedTitreId', action.payload)
      ].startDate = today;
    },
    addStatus(state, action) {
      // state.status = action.payload;
    },
    addDocuments(state, action) {
      const { titreId, condition } = action.payload;
      const documents =
        state.possibleRequests[
          findIndex(state.possibleRequests, 'requestedTitreId', titreId)
        ].documents;
      if (
        isConditionAlreadyInTheArray(documents, 'conditionId', condition.id)
      ) {
        const newDocuments = action.payload.conditionDocuments;
        updateDocuments(documents, condition.id, newDocuments);
      } else {
        documents.push(condition);
      }
    },
    setCanBeSent(state, action) {
      state.possibleRequests[
        findIndex(
          state.possibleRequests,
          'requestedTitreId',
          action.payload.titreId
        )
      ].canBeSent = action.payload.canRequestBeSent;
    },
  },
});

const isConditionAlreadyInTheArray = (array, property, value) => {
  return findIndex(array, property, value) !== -1 ? true : false;
};

const updateDocuments = (documents, conditionId, newDocuments) => {
  documents[
    findIndex(documents, conditionId)
  ].conditionDocuments = newDocuments;
};

export const {
  createRequest,
  cleanRequests,
  addRequestor,
  addStartDate,
  addDocuments,
  setCanBeSent,
} = requestsSlice.actions;

export default requestsSlice.reducer;
