import { configureStore } from '@reduxjs/toolkit';
import sailorReducer from '../../features/sailorData/sailorsSlice';
import titlesReducer from '../../features/titlesCatalog/titlesSlice';

const store = configureStore({
  reducer: {
    sailors: sailorReducer,
    titles: titlesReducer
  }
});

export default store;