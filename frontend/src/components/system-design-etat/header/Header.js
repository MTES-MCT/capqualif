import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

import styles from './Header.module.scss';

import { ReactComponent as CapQualifLogo } from '../../../resources/img/logo/capqualif-logo.svg';
import HeaderBrand from '../header-brand/HeaderBrand';

const Header = () => {
  return (
    <header role="banner" className={styles['fr-header']}>
      <div className={styles['fr-header__body']}>
        <div className="fr-container">
          <div className={styles['cq-header__container']}>
            <div>
              <a href="/" title="">
                <HeaderBrand administrationLabel={'Ministère de la Mer'} />
              </a>
            </div>
            <CapQualifLogo />
          </div>
        </div>
      </div>
    </header>
    //   <header role="banner" className={styles['fr-header']}>
    //   <div className={styles['fr-header__body']}>
    //     <div className="fr-container">
    //       <div className={styles['fr-header__body-row']}>
    //         <div className={`${styles['fr-header__brand']} fr-enlarge-link`}>
    //           <div className={styles['fr-header__brand-top']}>
    //             <div className={styles['fr-header__logo']}>
    //               <a href="/" title="">
    //                 <HeaderBrand administrationLabel={'Ministère de la Mer'} />
    //               </a>
    //             </div>
    //             <div class="fr-header__operator">
    //               <CapQualifLogo />
    //             </div>
    //           </div>
    //         </div>
    //       </div>
    //     </div>
    //   </div>
    // </header>
  );
};

export default Header;
