import React, { useState } from 'react';
import { PropTypes } from 'prop-types';

import './CqItemBase.scss';

import CqItemHeader from './cq-item-header/CqItemHeader';

const CqItemBase = ({ subtitle, name, children }) => {
  const [isDetailVisible, setIsDetailVisible] = useState(false);

  return (
    <div
      className="cq-item cq-title cq-item--default rf-container rf-my-2w"
      onClick={() => setIsDetailVisible(!isDetailVisible)}
      style={{ cursor: isDetailVisible ? 'default' : 'cursor' }}
    >
      <div class="cq-item__header">
        <div className="rf-grid-row rf-grid-row--gutters">
          <div className="rf-col-5">
            <CqItemHeader subtitle={subtitle} name={name} />
          </div>
          <div className="rf-col-6">
            <div className="children-container">{children}</div>
          </div>
          <div className="rf-col-1">
            <span class="rf-fi-arrow-down-s-line"></span>
          </div>
        </div>
      </div>
    </div>
  );
};

CqItemBase.propTypes = {
  subtitle: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  children: PropTypes.element.isRequired,
};

export default CqItemBase;
