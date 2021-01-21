import React from 'react';
import { Switch, Route } from 'react-router-dom';

import {
  DASHBOARD_ROUTE,
  NEW_TITLE_APPLICATION_CHOICE_ROUTE,
  NEW_TITLE_APPLICATION_DETAILS_ROUTE,
  NEW_TITLE_APPLICATION_RECAP_ROUTE,
  ERROR_ROUTE,
  ADD_PIECE_ROUTE,
} from './routesList';

import Dashboard from '../components/pages/dashboard/Dashboard';
import NewTitleChoice from '../components/pages/new-title-application/new-title-choice/NewTitleChoice';
import TitleDetails from '../components/pages/new-title-application/title-details/TitleDetails';
import ApplicationRecap from '../components/pages/new-title-application/application-recap/ApplicationRecap';
import Error from '../components/pages/error/Error';
import AddPiece from '../components/pages/add-piece/AddPiece';

const Routes = () => {
  return (
    <section>
      <Switch>
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
  );
};

export default Routes;
