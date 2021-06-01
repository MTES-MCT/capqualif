import React from 'react';
import { Switch, Route } from 'react-router-dom';

import {
  DASHBOARD_ROUTE,
  NEW_TITRE_REQUEST_ROUTE,
  NEW_TITRE_REQUEST_CHOICE_ROUTE,
  NEW_TITRE_REQUEST_RECAP_ROUTE,
  ERROR_ROUTE,
  ADD_DOCUMENT_ROUTE,
  CONFIRMATION_ROUTE,
  CAPADMIN_ROUTE,
  EDITOR_ROUTE,
  DESKTOP,
  MOBILE,
} from './routesDictionnary';

import MobileDashboard from '../components/pages/capqualif/mobile/dashboard/Dashboard';
import MobileRequestChooseTitre from '../components/pages/capqualif/mobile/request/choose-titre/ChooseTitre';
import MobileRequestRecap from '../components/pages/capqualif/mobile/request/recap/Recap';
import MobileConfirmation from '../components/pages/capqualif/mobile/request/confirmation/Confirmation';
import MobileAddDocument from '../components/pages/capqualif/mobile/add-document/Add';

import DesktopDashboard from '../components/pages/capqualif/desktop/dashboard/Dashboard';
import DesktopNewTitreChoice from '../components/pages/capqualif/desktop/new-titre-application/new-titre-choice/NewTitreChoice';
import DesktopApplicationRecap from '../components/pages/capqualif/desktop/new-titre-application/application-recap/ApplicationRecap';
import DesktopError from '../components/pages/capqualif/desktop/error/Error';
import DesktopAddPiece from '../components/pages/capqualif/desktop/new-titre-application/add-piece/AddPiece';
import DesktopFakeSuccess from '../components/pages/capqualif/desktop/new-titre-application/application-recap/FakeSuccess';
import DesktopConfirmation from '../components/pages/capqualif/desktop/new-titre-application/confirmation/Confirmation';
import Editor from '../components/pages/capadmin/editor/Editor';

const Routes = () => {
  return (
    <section>
      <Switch>
        {/* ==================================================================== */}
        {/* ========= CapQualif (marin application) : mobile routes =========== */}
        {/* ==================================================================== */}
        <Route
          exact
          path={`/${MOBILE}/${DASHBOARD_ROUTE}`}
          component={MobileDashboard}
        />
        <Route
          exact
          path={`/${MOBILE}/${NEW_TITRE_REQUEST_CHOICE_ROUTE}`}
          component={MobileRequestChooseTitre}
        />
        <Route
          path={`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/:itemId/:itemSlug/${NEW_TITRE_REQUEST_RECAP_ROUTE}`}
          component={MobileRequestRecap}
        />
        <Route
          path={`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${CONFIRMATION_ROUTE}`}
          component={MobileConfirmation}
        />
        <Route
          path={`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}/:documentName`}
          component={MobileAddDocument}
        />

        {/* ==================================================================== */}
        {/* ==================================================================== */}

        {/* ==================================================================== */}
        {/* ========= CapQualif (marin application) : desktop routes =========== */}
        {/* ==================================================================== */}
        <Route
          exact
          path={`/${DESKTOP}/${DASHBOARD_ROUTE}`}
          component={DesktopDashboard}
        />
        <Route
          path={`/${DESKTOP}/${NEW_TITRE_REQUEST_ROUTE}/${NEW_TITRE_REQUEST_CHOICE_ROUTE}`}
          component={DesktopNewTitreChoice}
        />
        <Route
          path={`/${DESKTOP}/${NEW_TITRE_REQUEST_ROUTE}/:itemId/:itemSlug/${NEW_TITRE_REQUEST_RECAP_ROUTE}`}
          component={DesktopApplicationRecap}
        />
        <Route
          path={`/${DESKTOP}/${ADD_DOCUMENT_ROUTE}`}
          component={DesktopAddPiece}
        />
        <Route
          exact
          path={`/${DESKTOP}/${ERROR_ROUTE}`}
          component={DesktopError}
        />
        <Route exact path="/recap-success" component={DesktopFakeSuccess} />
        <Route
          exact
          path={`/${DESKTOP}/${CONFIRMATION_ROUTE}`}
          component={DesktopConfirmation}
        />
        {/* ==================================================================== */}
        {/* ==================================================================== */}

        {/* ==================================================================== */}
        {/* ========= CapAdmin (titre configuration) =========== */}
        {/* ==================================================================== */}
        <Route
          exact
          path={`/${CAPADMIN_ROUTE}/${EDITOR_ROUTE}`}
          component={Editor}
        />
        {/* ==================================================================== */}
        {/* ==================================================================== */}
      </Switch>
    </section>
  );
};

export default Routes;
