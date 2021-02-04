import React from 'react';
import Button from '../../button/Button';
import CqItemAdvancedDescription from './cq-items-advanced-description/CqItemAdvancedDescription';

import './CqItemDetails.scss';

import {
  NEW_TITRE_APPLICATION_ROUTE,
  NEW_TITRE_APPLICATION_RECAP_ROUTE,
} from '../../../../app/routesList';

const CqItemDetails = ({ isVisible, itemSlug, details }) => {
  return (
    <div
      id="cq-item-details"
      className={`${isVisible ? '' : 'hidden'} rf-container`}
    >
      <div className="rf-grid-row">
        {details.advancedDescriptions.map((advancedDescription) => (
          <CqItemAdvancedDescription
            categoryName={advancedDescription.categoryName}
            infos={advancedDescription.infos}
          />
        ))}
      </div>
      <div className="rf-mt-5w">
        <div className="rf-grid-row rf-grid-row--gutters">
          <div className="rf-col cq-item-details-container">
            <sub className="cq-item__attribute rf-mb-2w">
              Référence réglementaire
            </sub>
            <div className="cq-item-details__small-text">{details.arrete}</div>
          </div>
          <div className="rf-col cq-item-details-container">
            <sub className="cq-item__attribute rf-mb-2w">Durée de validité</sub>
            <div className="cq-item-details__small-text">
              {details.validityDuration}
            </div>
          </div>
          <div className="rf-col cq-item-details-container">
            <Button
              label="Demander ce titre"
              route={`${NEW_TITRE_APPLICATION_ROUTE}/${itemSlug}${NEW_TITRE_APPLICATION_RECAP_ROUTE}`}
              labelSize="cq-btn__label-size-small"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default CqItemDetails;
