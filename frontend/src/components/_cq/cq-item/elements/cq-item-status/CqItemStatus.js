import React from 'react';

import './CqItemStatus.scss';

const CqItemStatus = ({ status }) => {
  return (
    <div className="cq-item__status-container">
      <div className="cq-item__status-label">{status}</div>
    </div>
  );
};

export default CqItemStatus;
