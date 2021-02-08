import React from 'react';

import './CqItemHeader.scss';

const CqItemHeader = ({ subtitle, itemName }) => {
  return (
    <div id="cq-item-header" class="cq-item__lined-element rf-pl-1w">
      <div class="cq-item__attribute">{subtitle}</div>
      <div class="cq-item__name">{itemName}</div>
    </div>
  );
};

export default CqItemHeader;
