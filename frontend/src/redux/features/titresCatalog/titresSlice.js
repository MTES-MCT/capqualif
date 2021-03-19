import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

import {
  CAPQUALIF_URL,
  TITRES_ENDPOINT,
  ALL_TITRES_ENDPOINT,
} from '../../../api/apiList';

export const getAllTitres = createAsyncThunk(
  'titres/getAllTitres',
  async (thunkAPI) => {
    const response = await axios.get(
      `${CAPQUALIF_URL}/${TITRES_ENDPOINT}/${ALL_TITRES_ENDPOINT}`
    );
    return response.data;
  }
);

export const getTitre = createAsyncThunk(
  'titres/getTitre',
  async (titreSlug) => {
    const response = await axios.get(
      `${CAPQUALIF_URL}/${TITRES_ENDPOINT}/${titreSlug}`
    );
    return response.data;
  }
);

export const titresSlice = createSlice({
  name: 'titres',
  initialState: {
    allTitres: [],
    currentTitre: {},
  },
  reducers: {},
  extraReducers: {
    [getTitre.fulfilled]: (state, action) => {
      state.currentTitre = action.payload;
    },
    [getAllTitres.fulfilled]: (state, action) => {
      state.allTitres = action.payload;
    },
    [getTitre.fulfilled]: (state, action) => {
      state.currentTitre = action.payload;
    },
  },
});

export default titresSlice.reducer;
