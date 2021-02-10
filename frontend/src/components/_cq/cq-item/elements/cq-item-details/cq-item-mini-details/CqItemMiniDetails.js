import React, { Fragment } from 'react';

import './CqItemMiniDetails.scss';

const CqItemMiniDetails = ({ categoryName, infos }) => {
  return (
    <div className="cq-item__detail-container">
      <div class="cq-item__attribute cq-helpers__full-width rf-mt-3w rf-mt-3w">
        {categoryName}
      </div>

      {Array.isArray(infos) ? (
        infos.map((info) => (
          <div class="cq-item__lined-element cq-item__detail-flagged rf-p-1w rf-my-2w">
            {info}
          </div>
        ))
      ) : (
        <div className="cq-item__detail-not-flagged">{infos}</div>
      )}
    </div>
  );
};

export default CqItemMiniDetails;
