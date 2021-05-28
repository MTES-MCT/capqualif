import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import { PersistGate } from 'redux-persist/integration/react';
import { persistor } from '../redux/store';
import { store } from '../redux/store';

import { HOME_ROUTE } from './routesDictionnary';

import './App.scss'; // CapQualif

import Routes from './Routes';
import Sign from '../components/pages/capqualif/desktop/sign/Sign';
import Header from '../components/system-design-etat/header/Header';
import ScrollToTop from '../components/helpers/ScrollToTop';

const App = () => {
  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <Header />
        <Router>
          <ScrollToTop />
          <Switch>
            <Route exact path={HOME_ROUTE} component={Sign} />
            <Routes />
          </Switch>
        </Router>
      </PersistGate>
    </Provider>
  );
};

export default App;
