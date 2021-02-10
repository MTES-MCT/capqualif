import React, { useEffect, useState } from 'react';
import { PropTypes } from 'prop-types';

import './CqItemBase.scss';

import CqItemHeader from './cq-item-header/CqItemHeader';

const CqItemBase = ({
  subtitle,
  name,
  infos,
  existingTitreAction,
  details,
}) => {
  const [isDetailVisible, setIsDetailVisible] = useState(false);
  const [nbOfElements, setNbOfElements] = useState(2);

  useEffect(() => {
    adjustHeaderColumns();
  }, []);

  const adjustHeaderColumns = () => {
    if (infos) setNbOfElements(3);
  };

  return (
    <div
      className="cq-item cq-title cq-item--default rf-container rf-my-2w"
      onClick={() => setIsDetailVisible(!isDetailVisible)}
      style={{ cursor: isDetailVisible ? 'default' : 'cursor' }}
    >
      <div class="cq-item__header">
        <div className="rf-grid-row rf-grid-row--gutters">
          <div className={`${nbOfElements === 3 ? 'rf-col-4' : 'rf-col-11'}`}>
            <CqItemHeader subtitle={subtitle} name={name} />
          </div>
          {/* Infos : timeline & validity status */}
          {infos && <div className="rf-col-6 infos-container">{infos}</div>}
          {existingTitreAction && (
            <div className="rf-col-1">{existingTitreAction}</div>
          )}
          <div className="rf-col-1 expand-container rf-px-2w">
            <span
              class="rf-fi-arrow-down-s-line cq-helpers__clickable"
              onClick={() => setIsDetailVisible(!isDetailVisible)}
            ></span>
          </div>
        </div>
        <div className="rf-grid-row rf-grid-row--gutters" id="bipbip">
          {details}
        </div>
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
