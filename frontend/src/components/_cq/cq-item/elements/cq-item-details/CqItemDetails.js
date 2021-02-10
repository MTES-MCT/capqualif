import React from 'react';
import PropTypes from 'prop-types';

import CqItemMiniDetails from './cq-item-mini-details/CqItemMiniDetails';

import './CqItemDetails.scss';

const CqItemDetails = ({ isDetailVisible, details, action }) => {
  return (
    <div
      id="cq-item-details"
      className="cq-helpers__full-width"
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
        <div className="rf-px-3w rf-pt-2w isolated-details-container cq-helpers__full-width">
          {details
            .filter((detail) => !Array.isArray(detail.infos))
            .map((detail) => (
              <CqItemMiniDetails
                categoryName={detail.categoryName}
                infos={detail.infos}
              />
            ))}
          {action && <div className="rf-pt-2w">{action}</div>}
        </div>
      </div>
    </div>
  );
};

CqItemDetails.propTypes = {
  isDetailVisible: PropTypes.bool.isRequired,
  details: PropTypes.array.isRequired,
  action: PropTypes.element.isRequired,
};

export default CqItemDetails;
