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
    addDocument(state, action) {
      // Here, action.payload is :
      //    {
      //      conditionId: ''
      //      conditionName: ''
      //      conditionDocuments: []
      //    }

      const conditionIndex = state.documents.findIndex(
        (doc) => doc.conditionId === action.payload.conditionId
      );
      if (isInTheArray(conditionIndex)) {
        state.documents[conditionIndex].conditionDocuments =
          action.payload.conditionDocuments;
      } else {
        state.documents.push(action.payload);
      }
    },
  },
});

const isInTheArray = (index) => {
  return index !== -1 ? true : false;
};

export const { addDocument } = requestsSlice.actions;

export default requestsSlice.reducer;
