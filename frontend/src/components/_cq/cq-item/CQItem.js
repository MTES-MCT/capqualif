import React from 'react';
import CqItemStatus from './cq-item-status/CqItemStatus';
import './CqItem.scss';

// level = Appui, Execution, Direction
// type = ?

const CqItem = ({
  owner,
  level,
  capacite,
  itemName,
  delivranceDate,
  expirationDate,
  status,
}) => {
  console.log(status);

  const topTitle = () => {
    if (!level || level === undefined || level === '') {
      return capacite;
    } else {
      return level + ' • ' + capacite;
    }
  };

  return (
    <div className="cq-item cq-title cq-item--default">
      <div class="cq-item__header">
        <div class="cq-item__name-container">
          <div class="cq-item__main-attributes">{topTitle()}</div>
          <div class="cq-item__name">{itemName}</div>
        </div>
        <div class="cq-item__right-header">
          <CqItemStatus
            status={status}
            delivranceDate={delivranceDate}
            expirationDate={expirationDate}
          />
          <div class="cq-item__document-links">
            <div class="cq-item__document-item">
              <span class="rf-fi-file-line rf-fi--lg"></span>
            </div>
          </div>
          <div class="cq-item__extend">
            <span class="rf-fi-arrow-down-s-line rf-fi--lg"></span>
          </div>
        </div>
      </div>

      <div class="cq-item__content">{/* TODO */}</div>
    </div>
  );
};

export default CqItem;
