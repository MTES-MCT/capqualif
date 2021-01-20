import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import { PersistGate } from 'redux-persist/integration/react';
import { persistor } from '../redux/store';
import { store } from '../redux/store';

import Header from '../components/_rf/header/Header';

import { HOME_PATH } from './routesList';

import './App.scss';

import Routes from './Routes';
import Sign from '../components/pages/sign/Sign';

const App = () => {
  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <Header />
        <Router>
          <Switch>
            <Route exact path={HOME_PATH} component={Sign} />
            <Route component={Routes} />
          </Switch>
        </Router>
      </PersistGate>
    </Provider>
  );
};

export default App;
