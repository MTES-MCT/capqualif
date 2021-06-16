import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  id: '',
};

const conditionSlice = createSlice({
  name: 'condition',
  initialState,
  reducers: {
    setCurrentConditionId(state, action) {
      state.id = action.payload;
    },
  },
});

export default conditionSlice.reducer;
