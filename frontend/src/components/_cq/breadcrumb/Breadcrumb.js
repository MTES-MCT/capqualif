import React from 'react';
import { ReactComponent as LineBullet } from '../../../resources/img/symbols/listBullet.svg';

import './Breadcrumb.scss';

const Breadcrumb = () => {
  return (
    <div id="breadcrumb" className="rf-header no-shadow">
      <div className="rf-container">
        <div className="rf-grid-row">
          <div class="rf-col-2">
            <a class="rf-link">Retour à l'accueil</a>
          </div>
          <ul class="rf-col-8">
            <li>Choix du titre</li>

            <li className="cq-no-bullet">
              <LineBullet />
              Les pièces à fournir
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
