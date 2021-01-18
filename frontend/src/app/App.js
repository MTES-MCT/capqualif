import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  withRouter,
} from 'react-router-dom';
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

import Sign from '../components/pages/sign/Sign';
import Dashboard from '../components/pages/dashboard/Dashboard';
import NewTitleChoice from '../components/pages/new-title-application/new-title-choice/NewTitleChoice';
import TitleDetails from '../components/pages/new-title-application/title-details/TitleDetails';
import ApplicationRecap from '../components/pages/new-title-application/application-recap/ApplicationRecap';
import Error from '../components/pages/error/Error';
import AddPiece from '../components/pages/add-piece/AddPiece';
import Header from '../components/_rf/header/Header';

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

export default withRouter(App);
