import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

import { CAPQUALIF_URL } from '../../../../api/apiList';
import { CONDITION } from '../../../../dictionnary/demandeDeTitre';

const initialState = {
  possibleTitres: [
    {
      informations: {
        id: '1',
        slug: 'certificat-de-matelot-pont',
        capacite: 'Monovalence · Pont',
        name: 'Certificat de Matelot Pont',
        validityDurationInYears: '5',
      },
      instruction: {
        dossierStatus: true,
        marinIdentity: {
          basicInfos: {
            firstName: 'Thomas',
            lastName: 'Laval',
            numeroDeMarin: '1234945',
          },
          identityMarkers: {
            photoStatus: CONDITION.STATUS.VALID,
            signatureStatus: CONDITION.STATUS.VALID,
          },
        },
        results: {
          finalResult: false,
          restrictions: [],
          allConditionsGroups: [
            {
              group: 'Âge',
              conditions: [
                {
                  id: '11',
                  name: 'Âge',
                  status: CONDITION.STATUS.VALID,
                },
              ],
            },
            {
              group: 'Aptitude médicale',
              conditions: [
                {
                  id: '12',
                  name: 'Aptitude médicale',
                  status: CONDITION.STATUS.NOT_VALID,
                },
              ],
            },
            {
              group: 'Qualifications principales',
              conditions: [
                {
                  id: '131',
                  name: 'Module P1-Appui',
                  status: CONDITION.STATUS.VALID,
                },
                {
                  id: '132',
                  name: 'Module P2-Appui',
                  status: CONDITION.STATUS.VALID,
                },
                {
                  id: '133',
                  name: 'Module P3-Appui',
                  status: CONDITION.STATUS.NOT_VALID,
                },
                {
                  id: '134',
                  name: 'Module NP-Appui',
                  status: CONDITION.STATUS.VALID,
                },
              ],
            },
            {
              group: 'Qualifications spécifiques',
              conditions: [
                {
                  id: '14',
                  name: 'Certificat de Formation de Base à la Sécurité',
                  status: CONDITION.STATUS.NOT_VALID,
                },
              ],
            },
          ],
        },
      },
    },
    {
      informations: {
        capacite: 'Sécurité',
        name: 'Certificat de Formation de Base à la Sécurité',
        id: '2',
        slug: 'certificat-de-formation-de-base-a-la-securite',
        validityDurationInYears: '5',
      },
      instruction: {
        dossierStatus: false,
        marinIdentity: {
          basicInfos: {
            firstName: 'Thomas',
            lastName: 'Laval',
            numeroDeMarin: '1234945',
          },
          identityMarkers: {
            photoStatus: CONDITION.STATUS.VALID,
            signatureStatus: CONDITION.STATUS.VALID,
          },
        },
        results: {
          finalResult: false,
          restrictions: [],
          allConditionsGroups: [
            {
              group: 'Aptitude médicale',
              conditions: [
                {
                  id: '21',
                  name: 'Aptitude médicale',
                  status: CONDITION.STATUS.VALID,
                },
              ],
            },
            {
              group: 'Qualifications spécifiques',
              conditions: [
                {
                  id: '221',
                  name: 'Techniques individuelles de survie (UV- TIS-F) ',
                  status: CONDITION.STATUS.NOT_VALID,
                },
                {
                  id: '222',
                  name:
                    'Formation de base à la lutte contre l’incendie (UV-FBLI/F)',
                  status: CONDITION.STATUS.VALID,
                },
                {
                  id: '223',
                  name: 'Premiers secours élémentaires (PSC1)',
                  status: CONDITION.STATUS.VALID,
                },
                {
                  id: '224',
                  name: 'Prévention des risques à bord (UV-PRAB/F)',
                  status: CONDITION.STATUS.VALID,
                },
              ],
            },
          ],
        },
      },
    },
  ],
};

const getInstructionResult = createAsyncThunk(
  'instructions/getInstructionResult',
  async (idMarin, thunkAPI) => {
    const response = await axios.get(`${CAPQUALIF_URL}/`);
    return response.data;
  }
);

const instructionsSlice = createSlice({
  name: 'instructions',
  initialState,
  reducers: {
    changeConditionStatus(state, action) {
      state.possibleTitres
        .find((titre) =>
          titre.instruction.results.allConditionsGroups.find((group) =>
            group.conditions.find(
              (condition) => condition.id === action.payload
            )
          )
        )
        .instruction.results.allConditionsGroups.find((group) =>
          group.conditions.find((condition) => condition.id === action.payload)
        )
        .conditions.find(
          (condition) => condition.id === action.payload
        ).status = CONDITION.STATUS.DOCUMENT_ADDED;
    },
  },
  extraReducers: {
    [getInstructionResult.fulfilled]: (state, action) => {
      state.possibleTitres = action.payload;
    },
  },
});

export { getInstructionResult };
export const { changeConditionStatus } = instructionsSlice.actions;

export default instructionsSlice.reducer;
