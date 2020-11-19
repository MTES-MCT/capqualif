import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

import { CAPQUALIF_URL, ALL_TITLES_ENDPOINT, TITLES_ENDPOINT } from '../../api/apiList';

export const getAllTitles = createAsyncThunk(
    'titles/getAllTitles',
    async (thunkAPI) => {
        const response = await axios.get(`${CAPQUALIF_URL}/${ALL_TITLES_ENDPOINT}`);
        console.log(response.data);
        return response.data;
    }
)

export const getTitle = createAsyncThunk(
    'titles/getTitle',
    async (titleId, thunkAPI) => {
        const response = await axios.get(`${CAPQUALIF_URL}/${TITLES_ENDPOINT}/${titleId}`);
        return response.data;
    }
)

export const titlesSlice = createSlice({
    name: 'titles',
    initialState: {
        allTitles: [],
        currentTitle: {}
    },
    reducers: {
    },
    extraReducers: {
        [getAllTitles.fulfilled]: (state, action) => {
            state.allTitles = action.payload;
        },
        [getTitle.fulfilled]: (state, action) => {
            state.currentTitle = action.payload;
        },
    }
})

export default titlesSlice.reducer;