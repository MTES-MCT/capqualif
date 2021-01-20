import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import { PersistGate } from 'redux-persist/integration/react';
import { persistor } from '../redux/store';
import { store } from '../redux/store';

import {
  HOME_ROUTE,
  DASHBOARD_ROUTE,
  NEW_TITLE_APPLICATION_CHOICE_ROUTE,
  NEW_TITLE_APPLICATION_DETAILS_ROUTE,
  NEW_TITLE_APPLICATION_RECAP_ROUTE,
  ERROR_ROUTE,
  ADD_PIECE_ROUTE,
} from './routesList';

import './App.scss';

import Routes from './Routes';
import Sign from '../components/pages/sign/Sign';

const App = () => {
  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <Header />
        <Router>
          <section className="page-container">
            <Switch>
              <Route exact path={HOME_ROUTE} component={Sign} />
              <Route exact path={DASHBOARD_ROUTE} component={Dashboard} />
              <Route
                path={NEW_TITLE_APPLICATION_CHOICE_ROUTE}
                component={NewTitleChoice}
              />
              <Route
                path={NEW_TITLE_APPLICATION_DETAILS_ROUTE}
                component={TitleDetails}
              />
              <Route
                path={NEW_TITLE_APPLICATION_RECAP_ROUTE}
                component={ApplicationRecap}
              />
              <Route path={ADD_PIECE_ROUTE} component={AddPiece} />
              <Route exact path={ERROR_ROUTE} component={Error} />
            </Switch>
          </section>
        </Router>
      </PersistGate>
    </Provider>
  );
};

export default App;
