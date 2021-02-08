import React, { Fragment } from 'react';

import './CqItemAdvancedDescription.scss';

const CqItemAdvancedDescription = ({ categoryName, infos }) => {
  return (
    <Fragment>
      <div class="cq-item__attribute cq-helpers__full-width rf-mt-3w rf-mb-1w">
        {categoryName}
      </div>
      <div id="cq-item-single-detail__details-container">
        {infos.map((info) => (
          <div class="cq-item__lined-element cq-item__detail rf-p-1w rf-my-1w">
            {info}
          </div>
        ))}
      </div>
    </Fragment>
  );
};

export default CqItemAdvancedDescription;
