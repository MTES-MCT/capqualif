import React from 'react';
import Button from '../../button/Button';
import CqItemSingleDetail from './cq-items-single-detail/CqItemSingleDetail';

import './CqItemDetails.scss';

const CqItemDetails = ({ isVisible }) => {
  return (
    <div
      id="cq-item-details"
      className={`${isVisible ? '' : 'hidden'} rf-container`}
    >
      <div className="rf-grid-row">
        <CqItemSingleDetail
          categoryName="Fonctions"
          detailInfos={["Fonctions d'appui au pont"]}
        />
        <CqItemSingleDetail
          categoryName="Tâches spécialisées"
          detailInfos={[
            'Navigation',
            'Manutention et arrimage de la cargaison',
            "Contrôle de l'exploitation du navire et assistance aux personnes à bord",
            'Entretien et réparation',
          ]}
        />
      </div>
      <div className="rf-mt-5w">
        <div className="rf-grid-row rf-grid-row--gutters">
          <div className="rf-col cq-item-details-container">
            <sub className="cq-item__attribute rf-mb-2w">
              Référence réglementaire
            </sub>
            <div className="cq-item-details__small-text">
              Arrêté du 18 août 2015
            </div>
          </div>
          <div className="rf-col cq-item-details-container">
            <sub className="cq-item__attribute rf-mb-2w">Durée de validité</sub>
            <div className="cq-item-details__small-text">5 ans</div>
          </div>
          <div className="rf-col cq-item-details-container">
            <Button
              label="Demander ce titre"
              route={''}
              labelSize="cq-btn__label-size-small"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default CqItemDetails;
