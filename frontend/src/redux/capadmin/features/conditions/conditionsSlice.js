import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

import {
  CAPQUALIF_URL,
  CAPADMIN_ENDPOINT,
  CAPADMIN_TITRES_ENDPOINT,
} from '../../../../api/apiList';

export const createConditions = createAsyncThunk(
  'conditions/createConditions',
  async (conditions, thunkAPI) => {
    console.log(conditions);
    const response = await axios.post(
      `${CAPQUALIF_URL}/${CAPADMIN_ENDPOINT}/${CAPADMIN_TITRES_ENDPOINT}`,
      conditions
    );
    return response.data;
  }
);

export const conditionsSlice = createSlice({
  name: 'conditions',
  initialState: {
    conditions: {
      name: '',
      conditions: [],
    },
  },
  reducers: {},
  extraReducers: {
    [createConditions.fulfilled]: (state, action) => {
      state.conditions = action.payload;
    },
  },
});

export default conditionsSlice.reducer;
