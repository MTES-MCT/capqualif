import React from 'react';
import PropTypes from 'prop-types';
import { VscCircleFilled } from 'react-icons/vsc';

import styles from './CqItemStatus.module.scss';

const CqItemStatus = ({ status }) => {
  return (
    <div className={`${styles['cq-item-status-container']}`}>
      <span className={`${styles['cq-item-status-container-text']} fr-pr-1w`}>
        {status}
      </span>
      <span className={`${styles['cq-item-status-container-icon']}`}>
        <VscCircleFilled />
      </span>
    </div>
  );
};

CqItemStatus.propTypes = {
  status: PropTypes.string.isRequired,
};

export default CqItemStatus;
