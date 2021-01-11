import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

import { CAPQUALIF_URL, MARINS_ENDPOINT } from '../../../api/apiList';

export const getMarinBasicData = createAsyncThunk(
  'marins/getMarinBasicDataByNumeroDeMarin',

  async (numeroDeMarin) => {
    const response = await axios.get(
      `${CAPQUALIF_URL}/${MARINS_ENDPOINT}/${numeroDeMarin}`
    );
    return response.data;
  }
);

export const marinsSlice = createSlice({
  name: 'marin',
  initialState: {
    marinBasicData: {
      numeroDeMarin: '',
      marinCivilData: {
        numeroDeMarin: '',
        firstName: '',
        lastName: '',
        dateOfBirth: '',
        placeOfBirth: '',
        address: '',
        email: '',
      },
      marinIdentityMarkersData: {
        photo: '',
        signature: '',
      },
      marinEducationData: {
        titles: [],
      },
    },
  },
  reducers: {},
  extraReducers: {
    [getMarinBasicData.fulfilled]: (state, action) => {
      state.marinBasicData = action.payload;
    },
  },
});

export default marinsSlice.reducer;
