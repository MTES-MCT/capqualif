import { configureStore } from '@reduxjs/toolkit';
import marinsReducer from './capqualif/desktop/features/marinData/marinsSlice';
import titresReducer from './capqualif/desktop/features/titresCatalog/titresSlice';
import headerReducer from './capqualif/mobile/header/headerSlice';
import requestsReducer from './capqualif/mobile/requests/requestsSlice';
import instructionsReducer from './capqualif/mobile/instructions/instructionsSlice';
import currentRequestReducer from './capqualif/mobile/requests/currentRequest';

import conditionsReducer from './capadmin/features/conditions/conditionsSlice';

export default configureStore({
  reducer: {
    marins: marinsReducer,
    titres: titresReducer,
    conditions: conditionsReducer,
    header: headerReducer,
    requests: requestsReducer,
    instructions: instructionsReducer,
    currentRequest: currentRequestReducer,
  },
});
