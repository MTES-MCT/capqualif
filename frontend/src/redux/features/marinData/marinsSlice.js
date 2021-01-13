import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

import { CAPQUALIF_URL, MARINS_ENDPOINT } from '../../../api/apiList';

export const getMarinBasicDataByNumeroDeMarin = createAsyncThunk(
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
      nom: '',
      numIdentification: '',
      nomUsage: '',
      prenom: '',
      villeNaissance: '',
      numeroFixe: '',
      numeroPortable: '',
      adresseMessagerie: '',
      dateNaissance: '',
      dateIdentification: '',
      codeNationalite: {
        libelle: '',
        libelleAnglais: '',
      },
      codeCivilite: {
        code: '',
        libelle: '',
      },
      codeServiceRattachement: {
        code: '',
        libelle: '',
      },
    },
  },
  reducers: {},
  extraReducers: {
    [getMarinBasicDataByNumeroDeMarin.fulfilled]: (state, action) => {
      state.marinBasicData = action.payload;
    },
  },
});

export default marinsSlice.reducer;
