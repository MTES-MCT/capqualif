import React from 'react';

import commonStyles from '../../common.scss';
import styles from './CqItemHeader.module.scss';

const CqItemHeader = ({ subtitle, name }) => {
  return (
    <div className={`${commonStyles['cq-item__lined-element']} fr-pl-1w`}>
      <div className={`${commonStyles['cq-item__attribute']} fr-pl-1w`}>
        {subtitle}
      </div>
      <div className={`${styles['cq-item__name']} fr-pl-1w`}>{name}</div>
    </div>
  );
};

export default CqItemHeader;
