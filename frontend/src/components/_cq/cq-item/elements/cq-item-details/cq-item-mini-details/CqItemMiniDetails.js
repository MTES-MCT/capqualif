import React from 'react';

import './CqItemMiniDetails.scss';

const CqItemMiniDetails = ({ categoryName, infos }) => {
  if (infos && infos !== '' && infos.length > 0) {
    return (
      <div className="cq-item__detail-container">
        <div class="cq-item__attribute  rf-my-1w">{categoryName}</div>

        {infos && infos !== '' && Array.isArray(infos) ? (
          infos.map((info) => (
            <div class="cq-item__lined-element cq-item__detail-flagged rf-p-1w rf-mb-2w">
              {info}
            </div>
          ))
        ) : (
          <div className="cq-item__detail-not-flagged">{infos}</div>
        )}
      </div>
    );
  } else {
    return null;
  }
};

export default CqItemMiniDetails;
// export default CqItemMiniDetails;
