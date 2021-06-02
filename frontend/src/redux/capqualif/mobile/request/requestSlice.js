import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const initialState = [];

// const initialState = {
//   requestorFirstName: '',
//   requestorLastName: '',
//   requestedTitre: '',
//   requestStartDate: '',
//   requestStatus: '',
// };

const requestSlice = createSlice({
  name: 'request',
  initialState,
  reducers: {
    addRequest(state, action) {
      state.push(action.payload);
    },
  },
});

export const { addRequest } = requestSlice.actions;

export default requestSlice.reducer;
