import React from 'react';
import { Switch, Route } from 'react-router-dom';

import {
  DASHBOARD_ROUTE,
  NEW_TITRE_APPLICATION_ROUTE,
  NEW_TITRE_APPLICATION_CHOICE_ROUTE,
  NEW_TITRE_APPLICATION_RECAP_ROUTE,
  ERROR_ROUTE,
  ADD_PIECE_ROUTE,
  CONFIRMATION_ROUTE,
  CAPADMIN_ROUTE,
  EDITOR_ROUTE,
} from './routesList';

import Dashboard from '../components/pages/capqualif/dashboard/Dashboard';
import NewTitreChoice from '../components/pages/capqualif/new-titre-application/new-titre-choice/NewTitreChoice';
import ApplicationRecap from '../components/pages/capqualif/new-titre-application/application-recap/ApplicationRecap';
import Error from '../components/pages/capqualif/error/Error';
import AddPiece from '../components/pages/capqualif/new-titre-application/add-piece/AddPiece';
import FakeSuccess from '../components/pages/capqualif/new-titre-application/application-recap/FakeSuccess';
import Confirmation from '../components/pages/capqualif/new-titre-application/confirmation/Confirmation';
import Editor from '../components/pages/capadmin/editor/Editor';

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
          path={`${NEW_TITRE_APPLICATION_ROUTE}/:itemId/:itemSlug${NEW_TITRE_APPLICATION_RECAP_ROUTE}`}
          component={ApplicationRecap}
        />
        <Route path={ADD_PIECE_ROUTE} component={AddPiece} />
        <Route exact path={ERROR_ROUTE} component={Error} />
        <Route exact path="/recap-success" component={FakeSuccess} />
        <Route exact path={CONFIRMATION_ROUTE} component={Confirmation} />
        <Route exact path={CAPADMIN_ROUTE / EDITOR_ROUTE} component={Editor} />
      </Switch>
    </section>
  );
};

export default Routes;
