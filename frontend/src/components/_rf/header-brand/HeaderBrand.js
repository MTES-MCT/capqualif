import React from 'react';

import styles from './HeaderBrand.module.scss';

const HeaderBrand = ({ administrationLabel }) => {
  return (
    <p className={`${styles['cq-logo-text']} ${styles['fr-logo']}`}>
      {administrationLabel}
    </p>
  );
};

export default HeaderBrand;
