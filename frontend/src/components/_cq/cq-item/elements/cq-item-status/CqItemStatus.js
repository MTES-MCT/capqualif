import React from 'react';
import PropTypes from 'prop-types';

import { Icon } from 'semantic-ui-react';
import styles from './CqItemStatus.module.scss';

const CqItemStatus = ({ status }) => {
  return (
    <div className={`${styles['cq-item-status-container']}`}>
      <span className={`${styles['cq-item-status-container-text']} fr-pr-1w`}>
        {status}
      </span>
      <Icon name="circle thin" />
    </div>
  );
};

CqItemStatus.propTypes = {
  status: PropTypes.string.isRequired,
};

export default CqItemStatus;
