import { createSlice } from '@reduxjs/toolkit';

export const headerSlice = createSlice({
  name: 'header',
  initialState: {
    isVisible: false,
  },
  reducers: {
    showHeader: (state) => {
      state.isVisible = true;
    },
    hideHeader: (state) => {
      state.isVisible = false;
    },
  },
});

export const { showHeader, hideHeader } = headerSlice.actions;

export default headerSlice.reducer;
