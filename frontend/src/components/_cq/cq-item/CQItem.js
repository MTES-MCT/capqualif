import React from 'react';
import CqItemHeader from './cq-item-header/CqItemHeader';
import CqItemStatus from './cq-item-status/CqItemStatus';
import './CqItem.scss';

import { OWNER } from '../../../dictionnary/common';

// level = Appui, Execution, Direction
// type = ?

function CqItemLogo({ logo }) {
  return (
    <div className="cq-item__document-links">
      <span className={`rf-fi--lg ${logo}`}></span>
    </div>
  );
}

const CqItem = ({
  owner,
  level,
  capacite,
  itemName,
  delivranceDate,
  expirationDate,
  status,
}) => {
  return (
    <div className="cq-item cq-title cq-item--default">
      <div class="cq-item__header">
        <CqItemHeader level={level} capacite={capacite} itemName={itemName} />
        {owner === OWNER.MARIN && (
          <div class="cq-item__right-header">
            <CqItemStatus
              status={status}
              delivranceDate={delivranceDate}
              expirationDate={expirationDate}
            />
            <CqItemLogo logo="rf-fi-file-line" />

            <div class="cq-item__extend">
              <span class="rf-fi-arrow-down-s-line rf-fi--lg"></span>
            </div>
          </div>
        )}
      </div>

      <div class="cq-item__content">{/* TODO */}</div>
    </div>
  );
};

export default CqItem;
