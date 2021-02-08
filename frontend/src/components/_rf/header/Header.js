import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { DASHBOARD_ROUTE } from '../../../app/routesList';
import { store } from '../../../redux/store';
import HeaderBrand from '../header-brand/HeaderBrand';

const Header = ({ numeroDeMarin }) => {
  const [localMarinData, setLocalMarinData] = useState('');

  useEffect(() => {
    setLocalMarinData(store.getState().marinsReducer.marinBasicData);
  }, []);

  return (
    <header className="rf-header">
      <div className="rf-container rf-container__header">
        <div className="rf-header__body">
          <HeaderBrand
            administrationLabel1={'Ministère'}
            administrationLabel2={'de la mer'}
          />

          <div className="rf-header__navbar">
            <div className="rf-service">
              <Link
                to={DASHBOARD_ROUTE}
                className="rf-service__title"
                title="CapQualif"
              >
                CapQualif
              </Link>
              <p className="rf-service__tagline">
                Direction des affaires maritimes
              </p>
            </div>
          </div>

          <div class="rf-header__tools">
            <div class="cq-user">
              <div class="cq-user__name">
                {localMarinData.prenom} {localMarinData.nom}
              </div>
              <div class="cq-user__sailor-number">
                <span class="label">identifiant :</span>
                <span class="nb">{localMarinData.numeroDeMarin}</span>
              </div>
            </div>

            <div className="cq-user__picture"></div>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;
