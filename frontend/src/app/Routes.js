import React from 'react';
import { Switch, Route } from 'react-router-dom';

import {
  DASHBOARD_ROUTE,
  NEW_TITRE_APPLICATION_ROUTE,
  NEW_TITRE_APPLICATION_CHOICE_ROUTE,
  NEW_TITRE_APPLICATION_RECAP_ROUTE,
  ERROR_ROUTE,
  ADD_PIECE_ROUTE,
} from './routesList';

import Dashboard from '../components/pages/dashboard/Dashboard';
import NewTitreChoice from '../components/pages/new-titre-application/new-titre-choice/NewTitreChoice';
import ApplicationRecap from '../components/pages/new-titre-application/application-recap/ApplicationRecap';
import Error from '../components/pages/error/Error';
import AddPiece from '../components/pages/add-piece/AddPiece';

const Routes = () => {
  return (
    <section>
      <Switch>
        <Route exact path={DASHBOARD_ROUTE} component={Dashboard} />
        <Route
          path={`${NEW_TITRE_APPLICATION_ROUTE}${NEW_TITRE_APPLICATION_CHOICE_ROUTE}`}
          component={NewTitreChoice}
        />
        <Route
          path={`${NEW_TITRE_APPLICATION_ROUTE}/:itemSlug${NEW_TITRE_APPLICATION_RECAP_ROUTE}`}
          component={ApplicationRecap}
        />
        <Route path={ADD_PIECE_ROUTE} component={AddPiece} />
        <Route exact path={ERROR_ROUTE} component={Error} />
      </Switch>
    </section>
  );
};

export default Routes;
