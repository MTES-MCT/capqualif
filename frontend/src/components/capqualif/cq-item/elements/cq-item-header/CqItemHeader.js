import React from 'react';
import { PropTypes } from 'prop-types';

import commonStyles from '../../common.module.scss';
import styles from './CqItemHeader.module.scss';

const CqItemHeader = ({ subtitle, name }) => {
  return (
    <div>
      <div className={`${commonStyles['cq-item-attribute']}`}>{subtitle}</div>
      <div className={`${styles['cq-item__name']}`}>{name}</div>
    </div>
  );
};

CqItemHeader.propTypes = {
  subtitle: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
};

export default CqItemHeader;
