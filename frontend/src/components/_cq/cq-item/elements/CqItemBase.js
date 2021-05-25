import React, { useState } from 'react';
import { PropTypes } from 'prop-types';

import styles from './CqItemBase.module.scss';

import CqItemHeader from './cq-item-header/CqItemHeader';

const CqItemBase = ({
  subtitle,
  name,
  dates,
  status,
  existingTitreAction,
  details,
  document,
}) => {
  const [isDetailVisible, setIsDetailVisible] = useState(false);

  return (
    <div
      className={`${styles['cq-item']} ${styles['cq-item']} ${styles['cq-item--default']} fr-container fr-my-2w`}
    >
      <div className={`${styles['cq-item__header']}`}>
        <div className="fr-grid-row">
          <div className="fr-col">
            <CqItemHeader subtitle={subtitle} name={name} />
          </div>
          {dates && (
            <div className={`${styles['dates-container']} fr-col`}>{dates}</div>
          )}
          {status && (
            <div className={`${styles['status-container']} fr-col-2`}>
              {status}
            </div>
          )}
          {existingTitreAction && (
            <div className="fr-col-2">{existingTitreAction}</div>
          )}
          {document && (
            <div className={`${styles['document-container']} fr-col-1`}>
              {document}
            </div>
          )}
          {details && (
            <div className={`${styles['expand-container']} fr-col-1 fr-px-2w`}>
              <span
                class={`${styles['expand-container']} fr-fi-arrow-down-s-line cq-helpers__clickable`}
                onClick={() => setIsDetailVisible(!isDetailVisible)}
              ></span>
            </div>
          )}
        </div>
        {details && (
          <div className="fr-grid-row fr-grid-row--gutters">
            {React.cloneElement(details, { isVisible: isDetailVisible })}
          </div>
        )}
      </div>
    </div>
  );
};

CqItemBase.propTypes = {
  subtitle: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  infos: PropTypes.element.isRequired,
  details: PropTypes.object.isRequired,
  existingTitreAction: PropTypes.object.isRequired,
};

export default CqItemBase;
