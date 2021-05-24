import React from 'react';
import { Link } from 'react-router-dom';
import { DASHBOARD_ROUTE, DESKTOP } from '../../../app/routesDictionnary';
import { ReactComponent as LineBullet } from '../../../resources/img/symbols/listBullet.svg';

import './Breadcrumb.scss';

const Breadcrumb = () => {
  return (
    <div id="breadcrumb" className="rf-header no-shadow">
      <div className="rf-container">
        <div className="rf-grid-row">
          <div className="rf-col-2">
            <Link to={`${DESKTOP}/${DASHBOARD_ROUTE}`} className="rf-link">
              Retour à l'accueil
            </Link>
          </div>
          <ul className="rf-col-8">
            <li>Choix du titre</li>

            <li className="cq-no-bullet">
              <LineBullet />
              Récapitulatif du dossier
            </li>
            <li className="cq-no-bullet">
              <LineBullet />
              Confirmation
            </li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Breadcrumb;
