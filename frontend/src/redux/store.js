import { configureStore } from '@reduxjs/toolkit';
import marinsReducer from './capqualif/desktop/features/marinData/marinsSlice';
import titresReducer from './capqualif/desktop/features/titresCatalog/titresSlice';
import conditionsReducer from './capadmin/features/conditions/conditionsSlice';
import headerReducer from './capqualif/mobile/header/headerSlice';
import requestsReducer from './capqualif/mobile/requests/requestsSlice';
import temporaryDocumentsReducer from './capqualif/mobile/temporary-documents/temporaryDocumentsSlice';
import instructionsReducer from './capqualif/mobile/instructions/instructionsSlice';

export default configureStore({
  reducer: {
    marinsReducer,
    titresReducer,
    conditionsReducer,
    headerReducer,
    requestsReducer,
    temporaryDocumentsReducer,
    instructionsReducer,
  },
});
