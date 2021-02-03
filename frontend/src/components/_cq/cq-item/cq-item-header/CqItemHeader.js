import React from 'react';

import './CqItemHeader.scss';

const CqItemHeader = ({ itemName, level, capacite }) => {
  const topTitle = () => {
    if (!level || level === undefined || level === '') {
      return capacite;
    } else {
      return level + ' • ' + capacite;
    }
  };

  return (
    <div id="cq-item-header" class="cq-item__lined-element rf-pl-1w">
      <div class="cq-item__attribute">{topTitle()}</div>
      <div class="cq-item__name">{itemName}</div>
    </div>
  );
};

export default CqItemHeader;
