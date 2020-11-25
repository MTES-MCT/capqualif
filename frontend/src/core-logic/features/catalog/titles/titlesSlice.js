import { createSlice } from '@reduxjs/toolkit';
import { getAllTitles, getTitle } from './titlesThunks';

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