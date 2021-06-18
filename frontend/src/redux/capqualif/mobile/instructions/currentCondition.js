import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  id: '',
  name: '',
  pictures: [],
};

const currentConditionSlice = createSlice({
  name: 'currentCondition',
  initialState,
  reducers: {
    setInfos(state, action) {
      state.id = action.payload.id;
      state.name = action.payload.name;
    },
    addPicture(state, action) {
      state.pictures.push(action.payload);
    },
    deleteLastPicture(state) {
      state.pictures.pop();
    },
    cleanCondition(state) {
      state.id = '';
      state.name = '';
      state.pictures = [];
    },
  },
});

export const {
  setInfos,
  addPicture,
  deleteLastPicture,
  cleanCondition,
} = currentConditionSlice.actions;
export default currentConditionSlice.reducer;
