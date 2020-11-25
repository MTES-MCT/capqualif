import { configureStore } from '@reduxjs/toolkit';
import sailorReducer from '../core-logic/features/sailor/sailorsSlice';
import titlesReducer from '../core-logic/features/catalog/titles/titlesSlice';

const store = configureStore({
  reducer: {
    sailors: sailorReducer,
    titles: titlesReducer
  }
});

export default store;