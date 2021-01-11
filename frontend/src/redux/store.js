import { configureStore } from '@reduxjs/toolkit';
import marinsReducer from './features/marinData/marinsSlice';
import titlesReducer from './features/titlesCatalog/titlesSlice';

const store = configureStore({
  reducer: {
    marins: marinsReducer,
    titles: titlesReducer,
  },
});

export default store;
