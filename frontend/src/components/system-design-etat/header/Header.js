import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

import styles from './Header.module.scss';

import { ReactComponent as CapQualifLogo } from '../../../resources/img/logo/capqualif-logo.svg';
import HeaderBrand from '../header-brand/HeaderBrand';
import { Fragment } from 'react';

const Header = () => {
  const isVisible = useSelector((state) => state.header.isVisible);
  const [isVisibleInternal, setIsVisibleInternal] = useState(false);

  useEffect(() => {
    setIsVisibleInternal(isVisible);
  }, [isVisible]);

  return (
    <Fragment>
      {isVisibleInternal && (
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
      )}
    </Fragment>
  );
};

export default Header;
