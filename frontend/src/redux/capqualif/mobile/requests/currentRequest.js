import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  currentTitre: {
    id: '',
  },
  currentCondition: {
    id: '',
    name: '',
    pictures: [],
  },
};

const currentRequestSlice = createSlice({
  name: 'currentRequest',
  initialState,
  reducers: {
    setCurrentTitreId(state, action) {
      state.currentTitre.id = action.payload;
    },
    setCurrentConditionInfos(state, action) {
      state.currentCondition.id = action.payload.id;
      state.currentCondition.name = action.payload.name;
    },
    addPicture(state, action) {
      state.currentCondition.pictures.push(action.payload);
    },
    deleteLastPicture(state) {
      state.currentCondition.pictures.pop();
    },
    cleanCurrentCondition(state) {
      state.currentCondition.id = '';
      state.currentCondition.name = '';
      state.currentCondition.pictures = [];
    },
  },
});

export const {
  setCurrentTitreId,
  setCurrentConditionInfos,
  addPicture,
  deleteLastPicture,
  cleanCurrentCondition,
} = currentRequestSlice.actions;
export default currentRequestSlice.reducer;
