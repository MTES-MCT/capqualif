import React, { Fragment } from 'react';

import './CqItemSingleDetail.scss';

const CqItemSingleDetail = ({ categoryName, detailInfos }) => {
  return (
    <Fragment>
      <div class="cq-item__attribute cq-helpers__full-width rf-mt-3w rf-mb-1w">
        {categoryName}
      </div>
      <div id="cq-item-single-detail__details-container">
        {detailInfos.map((detailInfo) => (
          <div class="cq-item__lined-element cq-item__detail rf-p-1w rf-my-1w">
            {detailInfo}
          </div>
        ))}
      </div>
    </Fragment>
  );
};

export default CqItemSingleDetail;
