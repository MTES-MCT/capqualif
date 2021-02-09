import React from 'react';
import Button from '../../../button/Button';
import CqItemFlagDetails from './cq-items-advanced-description/CqitemFlagDetails';

import './CqItemDetails.scss';
import { FONT_SIZES } from '../../../../../dictionnary/saas/variables';

const CqItemDetails = ({ isDetailVisible, details, buttonRoute }) => {
  return (
    <div
      id="cq-item-details"
      // className={`${isDetailVisible ? '' : 'hidden'} rf-container`}
    >
      <div className="rf-grid-row">
        {details.map((detail) => (
          <CqItemFlagDetails
            categoryName={detail.categoryName}
            infos={detail.infos}
          />
        ))}
      </div>
      <div className="rf-mt-5w">
        <div className="rf-grid-row rf-grid-row--gutters">
          {/* <div className="rf-col cq-item-details-container">
            <sub className="cq-item__attribute rf-mb-2w">
              Référence réglementaire
            </sub>
            <div className="cq-item-details__small-text">{details.arrete}</div>
          </div> */}
          {/* <div className="rf-col cq-item-details-container">
            <sub className="cq-item__attribute rf-mb-2w">Durée de validité</sub>
            <div className="cq-item-details__small-text">
              {details.validityDuration}
            </div>
          </div> */}
          <div className="rf-col cq-item-details-container">
            <Button
              label="Demander ce titre"
              route={buttonRoute}
              labelSize={FONT_SIZES.SMALL}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default CqItemDetails;
