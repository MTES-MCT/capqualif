// react-persist is configured according to :
// https://redux-toolkit.js.org/usage/usage-guide#use-with-redux-persist

import { combineReducers } from 'redux';
import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import {
  persistStore,
  persistReducer,
  FLUSH,
  REHYDRATE,
  PAUSE,
  PERSIST,
  PURGE,
  REGISTER,
} from 'redux-persist';
import storage from 'redux-persist/lib/storage'; // defaults to localStorage for web
import marinsReducer from './capqualif/features/marinData/marinsSlice';
import titresReducer from './capqualif/features/titresCatalog/titresSlice';
import conditionsReducer from './capqualif/features/conditions/conditionsSlice';

const reducers = combineReducers({
  marinsReducer,
  titresReducer,
  conditionsReducer,
});

const persistConfig = {
  key: 'root',
  storage,
};

const persistedReducer = persistReducer(persistConfig, reducers);

const store = configureStore({
  reducer: persistedReducer,
  middleware: getDefaultMiddleware({
    serializableCheck: {
      ignoredActions: [FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER],
    },
  }),
});

let persistor = persistStore(store);

export { store, persistor };
