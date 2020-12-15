import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
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

import Header from '../components/elements/header/Header';
import Sign from '../components/layout/sign/Sign';
import Dashboard from '../components/layout/dashboard/Dashboard';
import NewTitleChoice from '../components/layout/new-title-application/new-title-choice/NewTitleChoice';
import TitleDetails from '../components/layout/new-title-application/title-details/TitleDetails';
import ApplicationRecap from '../components/layout/new-title-application/application-recap/ApplicationRecap';
import Error from '../components/layout/error/Error';
import AddPiece from '../components/layout/add-piece/AddPiece';

class App extends Component {
  render() {
    return (
      // TO DO : create a routes component as soon as more routes add up
      <Provider store={store}>
        <Router>
          <Header />
          <section>
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
              <Route exact path="/error" component={Error} />
            </Switch>
          </section>
        </Router>
      </Provider>
    );
  }
}

export default App;
