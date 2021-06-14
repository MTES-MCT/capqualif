import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  document: '',
};

const temporaryDocumentsSlice = createSlice({
  name: 'temporaryDocuments',
  initialState,
  reducers: {
    addDocument(state, action) {
      state.document = action.payload;
    },
  },
});

export const { addDocument } = temporaryDocumentsSlice.actions;

export default temporaryDocumentsSlice.reducer;
