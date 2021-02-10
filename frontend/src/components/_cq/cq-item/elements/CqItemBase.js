import React, { useEffect, useState } from 'react';
import { PropTypes } from 'prop-types';

import './CqItemBase.scss';

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
    <div className="cq-item cq-title cq-item--default rf-container rf-my-2w">
      <div class="cq-item__header">
        <div className="rf-grid-row">
          <div className="rf-col">
            <CqItemHeader subtitle={subtitle} name={name} />
          </div>
          {dates && <div className="rf-col dates-container">{dates}</div>}
          {status && <div className="rf-col-2 status-container">{status}</div>}
          {existingTitreAction && (
            <div className="rf-col-2">{existingTitreAction}</div>
          )}
          {document && (
            <div className="rf-col-1 document-container">{document}</div>
          )}
          {details && (
            <div className="rf-col-1 expand-container rf-px-2w">
              <span
                class="rf-fi-arrow-down-s-line cq-helpers__clickable"
                onClick={() => setIsDetailVisible(!isDetailVisible)}
              ></span>
            </div>
          )}
        </div>
        {details && (
          <div className="rf-grid-row rf-grid-row--gutters">
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
