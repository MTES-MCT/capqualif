import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

import { CAPQUALIF_URL, CONDITIONS_ENDPOINT } from '../../../../api/apiList';

export const getConditions = createAsyncThunk(
  'conditions/getConditions',
  async (requestData) => {
    const response = await axios.get(
      `${CAPQUALIF_URL}/${CONDITIONS_ENDPOINT}/${requestData.titreId}/${requestData.numeroDeMarin}`
    );
    return response.data;
  }
);

export const conditionsSlice = createSlice({
  name: 'conditions',
  initialState: {
    conditions: {},
  },
  reducers: {},
  extraReducers: {
    [getConditions.fulfilled]: (state, action) => {
      state.conditions = action.payload;
    },
  },
});

export default conditionsSlice.reducer;
