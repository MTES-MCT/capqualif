import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  id: '',
  name: '',
  document: '',
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
      state.document = action.payload;
    },
  },
});

export const { setInfos } = currentConditionSlice.actions;
export const { addDocument } = currentConditionSlice.actions;
export default currentConditionSlice.reducer;
