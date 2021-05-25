import React from 'react';

import commonStyles from '../../common.module.scss';
import styles from './CqItemHeader.module.scss';

const CqItemHeader = ({ subtitle, name }) => {
  return (
    <div>
      <div className={`${commonStyles['cq-item__attribute']}`}>{subtitle}</div>
      <div className={`${styles['cq-item__name']}`}>{name}</div>
    </div>
  );
};

export default CqItemHeader;
