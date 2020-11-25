import React, { Component } from 'react';
import { HashRouter as Router, Switch, Route } from "react-router-dom";
import { Provider } from 'react-redux';
import store from '../core-logic/store';

import './App.scss';

import Sign from '../components/pages/sign/Sign';
import Dashboard from '../components/pages/dashboard/Dashboard';
import NewTitleChoice from '../components/pages/new-title-application/new-title-choice/NewTitleChoice';
import TitleDetails from '../components/pages/new-title-application/title-details/TitleDetails';
import ApplicationRecap from '../components/pages/new-title-application/application-recap/ApplicationRecap';
import Error from '../components/pages/error/Error';

class App extends Component {
  render() {
    return (

    // TO DO : create a routes component as soon as more routes add up 
      <Provider store={store}>
        <Router>
          <section>
            <Switch>      
              <Route exact path='/' component={Sign} /> 
              <Route exact path='/dashboard' component={Dashboard} /> 
              <Route path='/new-title-application/choice' component={NewTitleChoice} /> 
              <Route path='/new-title-application/details' component={TitleDetails} /> 
              <Route path='/new-title-application/recap' component={ApplicationRecap} /> 
              <Route exact path='/error' component={Error} /> 
            </Switch>
          </section>
        </Router>
      </Provider>
    );
  }
}

export default App;