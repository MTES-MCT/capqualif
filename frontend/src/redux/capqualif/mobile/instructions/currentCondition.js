import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  id: '',
  name: '',
  documents: [],
};

const currentConditionSlice = createSlice({
  name: 'currentCondition',
  initialState,
  reducers: {
    setInfos(state, action) {
      state.id = action.payload.id;
      state.name = action.payload.name;
    },
    addDocument(state, action) {
      state.documents.push(action.payload);
    },
    deleteLastDocument(state) {
      state.documents.pop();
    },
  },
});

export const {
  setInfos,
  addDocument,
  deleteLastDocument,
} = currentConditionSlice.actions;
export default currentConditionSlice.reducer;
