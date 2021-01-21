import React from 'react';

import './CqItemStatus.scss';
import { VALID } from '../../../../dictionnary/demandeDeTitre';

const CqItemStatus = ({ status, delivranceDate, expirationDate }) => {
  return (
    <div className="cq-item__status-container">
      <div className="cq-item__timeline">
        <div>{delivranceDate}</div>
        <div className="timeline-graphic">
          <div className="line"></div>
          <div className="cursor"></div>
        </div>
        <div>{expirationDate}</div>
      </div>
      <div className="cq-item__status-label">{status}</div>
    </div>
  );
};

export default CqItemStatus;
