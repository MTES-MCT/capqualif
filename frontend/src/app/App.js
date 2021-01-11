import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  withRouter,
} from 'react-router-dom';
import { Provider } from 'react-redux';
import store from '../redux/store';

import {
  HOME_PATH,
  DASHBOARD_PATH,
  NEW_TITLE_APPLICATION_CHOICE_PATH,
  NEW_TITLE_APPLICATION_DETAILS_PATH,
  NEW_TITLE_APPLICATION_RECAP_PATH,
  ERROR_PATH,
  ADD_PIECE_PATH,
} from './pathes';

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
  // const getLoginInformation = () => {
  //   const user = store.getState().sailors.sailorBasicData.sailorCivilData;
  //   return user
  //     ? {
  //         username: user.firstName + ' ' + user.lastName,
  //         userSailorNumber: user.sailorNumber,
  //       }
  //     : null;
  // };

  return (
    // TO DO : create a routes component as soon as more routes add up
    <Provider store={store}>
      {/* {this.props.location.pathname !== '/connection' ? (
        <Header
          serviceName={'CapQualif'}
          adminName={'Direction des affaires maritimes'}
          username={getLoginInformation() ? getLoginInformation().username : ''}
          sailorNumber={
            getLoginInformation() ? getLoginInformation().userSailorNumber : ''
          }
        />
      ) : null} */}
      <Header />
      <Router>
        <section className="page-container">
          <Switch>
            <Route exact path={HOME_PATH} component={Sign} />
            <Route exact path={DASHBOARD_PATH} component={Dashboard} />
            <Route
              path={NEW_TITLE_APPLICATION_CHOICE_PATH}
              component={NewTitleChoice}
            />
            <Route
              path={NEW_TITLE_APPLICATION_DETAILS_PATH}
              component={TitleDetails}
            />
            <Route
              path={NEW_TITLE_APPLICATION_RECAP_PATH}
              component={ApplicationRecap}
            />
            <Route path={ADD_PIECE_PATH} component={AddPiece} />
            <Route exact path={ERROR_PATH} component={Error} />
          </Switch>
        </section>
      </Router>
    </Provider>
  );
};

export default withRouter(App);
