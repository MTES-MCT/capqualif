import React from 'react';
import Button from '../../../button/Button';
import CqItemMiniDetails from './cq-item-mini-details/CqItemMiniDetails';

import './CqItemDetails.scss';
import { FONT_SIZES } from '../../../../../dictionnary/saas/variables';
import { ACTION_TYPES } from '../../../../../dictionnary/demandeDeTitre';

const CqItemDetails = ({ isDetailVisible, details, buttonRoute }) => {
  return (
    <div
      id="cq-item-details"
      // className={`${isDetailVisible ? '' : 'hidden'} rf-container`}
    >
      <div className="rf-grid-row">
        <div className="rf-px-3w">
          {details
            .filter((detail) => Array.isArray(detail.infos))
            .map((detail) => (
              <CqItemMiniDetails
                categoryName={detail.categoryName}
                infos={detail.infos}
              />
            ))}
        </div>
      </div>
      <div className="rf-grid-row">
        <div className="rf-px-3w isolated-details-container cq-helpers__full-width">
          {details
            .filter((detail) => !Array.isArray(detail.infos))
            .map((detail) => (
              <CqItemMiniDetails
                categoryName={detail.categoryName}
                infos={detail.infos}
              />
            ))}
          <Button
            label="Demander ce titre"
            route={buttonRoute}
            labelSize={FONT_SIZES.SMALL}
            actionType={ACTION_TYPES.PRIMARY}
          />
        </div>
      </div>
    </div>
  );
};

export default CqItemDetails;
