import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { store } from '../../../redux/store';
import HeaderBrand from '../header-brand/HeaderBrand';

import './Header.scss'; // component
import '../../../sass/style/core.scss';
import './header-sde.scss'; // design system

import sailor from '../../../resources/img/mocks/sailor.png';
import { ReactComponent as CapQualifLogo } from '../../../resources/img/logo/capqualif-logo.svg';

const Header = ({ numeroDeMarin }) => {
  const [localMarinData, setLocalMarinData] = useState('');

  useEffect(() => {
    setLocalMarinData(store.getState().marinsReducer.marinBasicData);
  }, []);

  return (
    <header role="banner" class="fr-header">
      <div class="fr-header__body">
        <div class="fr-container">
          <div class="fr-header__body-row">
            <div class="fr-header__brand fr-enlarge-link">
              <div class="fr-header__brand-top">
                <div class="fr-header__logo">
                  <a href="/" title="">
                    <HeaderBrand administrationLabel={'Ministère de la Mer'} />
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;
