import React from 'react';
import { store } from '../../../redux/store';

import './SubHeader.scss';

import { NEW_TITRE_APPLICATION_CHOICE_ROUTE } from '../../../app/routesList';
import Button from '../button/Button';

const SubHeader = () => {
  return (
    <div className="cq-section-header rf-container">
      <div className="cq-welcome">
        <h1>
          Bonjour, {store.getState().marinsReducer.marinBasicData.prenom}.
        </h1>
        <h4>
          Bienvenue sur <strong>CapQualif</strong> !
        </h4>
      </div>
      <Button
        label="Demander un titre"
        route={NEW_TITRE_APPLICATION_CHOICE_ROUTE}
      />
    </div>
  );
};

export default SubHeader;
