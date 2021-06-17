import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  id: '',
  name: '',
};

const currentConditionSlice = createSlice({
  name: 'currentCondition',
  initialState,
  reducers: {
    setInfos(state, action) {
      state.id = action.payload.id;
      state.name = action.payload.name;
    },
  },
});

export const { setInfos } = currentConditionSlice.actions;
export default currentConditionSlice.reducer;
