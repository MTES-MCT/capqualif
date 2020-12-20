import React from 'react';
import HeaderBrand from '../header-brand/HeaderBrand';

const Header = ({serviceName,adminName,username,sailorNumber}) => {

  return (
    <header className="rf-header">
      <div className="rf-container rf-container__header">
        <div className="rf-header__body">

        < HeaderBrand administrationLabel1={'Ministère'} administrationLabel2={'de la mer'}/>
      
        <div className="rf-header__navbar">
          <div className="rf-service">
            <a className="rf-service__title" href="#" title="Nom du service">
              {serviceName}
            </a>
            <p className="rf-service__tagline">
              {adminName}
            </p>
          </div>
        </div>

          <div class="rf-header__tools">
            
            <div class="cq-user">

              <div class='cq-user__name'>{username}</div>
              <div class="cq-user__sailor-number">
                <span class="label">identifiant :</span><span class="nb">{sailorNumber}</span>
              </div>

            </div>  

            <div className="cq-user__picture">  
            </div>

          </div>

        </div>
      </div>
    </header>
  );
};

export default Header;
