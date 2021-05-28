import React from 'react';
import PropTypes from 'prop-types';

import styles from './CqItemFlagged.module.scss';

const CqItemFlagged = ({ label }) => {
  return (
    <div
      className={`${styles['cq-item-lined-element']} ${styles['cq-item__detail-flagged']} fr-px-1w`}
    >
      {label}
    </div>
  );
};

CqItemFlagged.propTypes = {
  label: PropTypes.string.isRequired,
};

export default CqItemFlagged;
