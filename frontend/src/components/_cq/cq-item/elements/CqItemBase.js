import React, { useState } from 'react';
import { PropTypes } from 'prop-types';

import styles from './CqItemBase.module.scss';

import CqItemHeader from './cq-item-header/CqItemHeader';
import CqItemStatus from './cq-item-status/CqItemStatus';

const CqItemBase = ({ subtitle, name, status, action, details }) => {
  const [isDetailVisible, setIsDetailVisible] = useState(false);

  return (
    <div className={`${styles['cq-item']} fr-container fr-mb-2w fr-py-3w`}>
      <div className="fr-grid-row fr-grid-row--middle">
        <div className="fr-col fr-pr-4w">
          <CqItemHeader subtitle={subtitle} name={name} />
        </div>
        <div className={`fr-col-3 fr-mr-1w`}>{status}</div>
        {action && <div className="fr-col-2">{action}</div>}
        {details && (
          <div className={`${styles['expand-container']} fr-col-1 fr-px-2w`}>
            <span
              class={`${styles['expand-container']} fr-ml-1w fr-fi-arrow-up-s-line cq-helpers__clickable`}
              onClick={() => setIsDetailVisible(!isDetailVisible)}
            ></span>
          </div>
        )}
      </div>
      {details && (
        <div className="fr-grid-row">
          {React.cloneElement(details, { isVisible: isDetailVisible })}
        </div>
      )}
    </div>
  );
};

CqItemBase.propTypes = {
  subtitle: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  status: PropTypes.element.isRequired,
  action: PropTypes.element.isRequired,
  details: PropTypes.object.isRequired,
};

export default CqItemBase;
