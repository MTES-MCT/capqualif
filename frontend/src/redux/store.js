import { configureStore } from '@reduxjs/toolkit';
import marinsReducer from './capqualif/desktop/features/marinData/marinsSlice';
import titresReducer from './capqualif/desktop/features/titresCatalog/titresSlice';
import conditionsReducer from './capadmin/features/conditions/conditionsSlice';
import headerReducer from './capqualif/mobile/header/headerSlice';
import requestReducer from './capqualif/mobile/request/requestSlice';
import temporaryDocumentsReducer from './capqualif/mobile/temporary-documents/temporaryDocumentsSlice';

export default configureStore({
  reducer: {
    marinsReducer,
    titresReducer,
    conditionsReducer,
    headerReducer,
    requestReducer,
    temporaryDocumentsReducer,
  },
});
