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
      state.documents.push(action.payload);
    },
  },
});

export const { addDocument } = requestsSlice.actions;

export default requestsSlice.reducer;
