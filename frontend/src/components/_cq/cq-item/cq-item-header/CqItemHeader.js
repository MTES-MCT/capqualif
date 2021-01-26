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
    <div id="cq-item-header" class="cq-item__name-container">
      <div class="cq-item__main-attributes">{topTitle()}</div>
      <div class="cq-item__name">{itemName}</div>
    </div>
  );
};

export default CqItemHeader;
