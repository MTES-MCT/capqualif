import React, { useState } from 'react';
import { PropTypes } from 'prop-types';

import './CqItemBase.scss';

import CqItemHeader from './cq-item-header/CqItemHeader';

const CqItemBase = ({ subtitle, itemName, children }) => {
  const [isDetailVisible, setIsDetailVisible] = useState(false);

  return (
    <div
      className="cq-item cq-title cq-item--default rf-container rf-my-2w"
      onClick={() => setIsDetailVisible(!isDetailVisible)}
      style={{ cursor: isDetailVisible ? 'default' : 'cursor' }}
    >
      <div class="cq-item__header">
        <div className="rf-grid-row">
          <div className="rf-col">
            <CqItemHeader subtitle={subtitle} itemName={itemName} />
          </div>
          <div className="rf-col">
            {/* <div className="cq-item__right-header">{children}</div> */}
            <div className="children-container">{children}</div>
          </div>
          <span class="rf-fi-arrow-down-s-line"></span>
        </div>
      </div>
    </div>
  );
};

CqItemBase.propTypes = {
  subtitle: PropTypes.string.isRequired,
  itemName: PropTypes.string.isRequired,
  children: PropTypes.element.isRequired,
};

export default CqItemBase;
