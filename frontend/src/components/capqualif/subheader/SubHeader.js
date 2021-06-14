import React from 'react';
import { store } from '../../../redux/store';

import './SubHeader.scss';

import {
  NEW_TITRE_REQUEST_ROUTE,
  NEW_TITRE_REQUEST_CHOICE_ROUTE,
  DESKTOP,
} from '../../../app/routesDictionnary';
import ButtonLink from '../buttons/ButtonLink';

const SubHeader = () => {
  return (
    <div className="cq-section-header rf-container">
      <div className="cq-welcome">
        <h1>
          {/* Bonjour, {store.getState().marinsReducer.marinBasicData.prenom}. */}
        </h1>
        <h4>
          Bienvenue sur <strong>CapQualif</strong> !
        </h4>
      </div>
      <ButtonLink
        label="Demander un titre"
        route={`/${DESKTOP}/${NEW_TITRE_REQUEST_ROUTE}/${NEW_TITRE_REQUEST_CHOICE_ROUTE}`}
      />
    </div>
  );
};

export default SubHeader;
