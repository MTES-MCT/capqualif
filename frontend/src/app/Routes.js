import React from 'react';
import { Switch, Route } from 'react-router-dom';

import {
  DASHBOARD_PATH,
  NEW_TITLE_APPLICATION_CHOICE_PATH,
  NEW_TITLE_APPLICATION_DETAILS_PATH,
  NEW_TITLE_APPLICATION_RECAP_PATH,
  ERROR_PATH,
  ADD_PIECE_PATH,
} from './routesList';

import Dashboard from '../components/pages/dashboard/Dashboard';
import NewTitleChoice from '../components/pages/new-title-application/new-title-choice/NewTitleChoice';
import TitleDetails from '../components/pages/new-title-application/title-details/TitleDetails';
import ApplicationRecap from '../components/pages/new-title-application/application-recap/ApplicationRecap';
import Error from '../components/pages/error/Error';
import AddPiece from '../components/pages/add-piece/AddPiece';

const Routes = () => {
  return (
    <section className="page-container">
      <Switch>
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
  );
};

export default Routes;
