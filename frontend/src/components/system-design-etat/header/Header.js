import React from 'react';
import { Link } from 'react-router-dom';

import styles from './Header.module.scss';

import { ReactComponent as CapQualifLogo } from '../../../resources/img/logo/capqualif-logo.svg';
import HeaderBrand from '../header-brand/HeaderBrand';

const Header = () => {
  return (
    <header
      role="banner"
      className={`${styles['fr-header']} ${styles['cq-header']}`}
    >
      <div className={styles['fr-header__body']}>
        <div className="fr-container">
          <div className={styles['header-container']}>
            <a href="/" title="">
              <HeaderBrand administrationLabel={'Ministère de la Mer'} />
            </a>
            <Link to="">
              <CapQualifLogo />
            </Link>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;
