import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

import { CAPQUALIF_URL, SAILORS_ENDPOINT } from '../../../api/apiList';

export const getSailorBasicData = createAsyncThunk(
  'sailors/getSailorBasicDataBySailorNumber',

  async (sailorNumber) => {
    const response = await axios.get(
      `${CAPQUALIF_URL}/${SAILORS_ENDPOINT}/${sailorNumber}`
    );
    return response.data;
  }
);

export const sailorSlice = createSlice({
  name: 'sailor',
  initialState: {
    sailorBasicData: {
      sailorNumber: '',
      sailorCivilData: {
        sailorNumber: '',
        firstName: '',
        lastName: '',
        dateOfBirth: '',
        placeOfBirth: '',
        address: '',
        email: '',
      },
      sailorIdentityMarkersData: {
        photo: '',
        signature: '',
      },
      sailorEducationData: {
        titles: [],
      },
    },
  },
  reducers: {},
  extraReducers: {
    [getSailorBasicData.fulfilled]: (state, action) => {
      state.sailorBasicData = action.payload;
    },
  },
});

export default sailorSlice.reducer;
