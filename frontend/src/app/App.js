import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import store from '../redux/store';

import { HOME_ROUTE } from './routesDictionnary';

import './App.scss';

import Routes from './Routes';
import Login from '../components/pages/capqualif/mobile/login/Login';
import Header from '../components/system-design-etat/header/Header';
import ScrollToTop from '../components/helpers/ScrollToTop';

const App = () => {
  return (
    <Provider store={store}>
      <Header />
      <Router>
        <ScrollToTop />
        <Switch>
          <Route exact path={HOME_ROUTE} component={Login} />
          <Routes />
        </Switch>
      </Router>
    </Provider>
  );
};

export default App;
