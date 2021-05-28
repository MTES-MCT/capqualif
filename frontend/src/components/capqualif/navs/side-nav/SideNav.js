import React from 'react';

import './SideNav.scss';

const SideNav = () => {
  return (
    <ul className="cq-sidemenu">
      {/* <li className="rf-nav__item cq-nav__vertical-item">
        <a className="rf-link" href="#" target="_self">
          Mes demandes en cours
        </a>
      </li> */}
      <li className="rf-nav__item cq-nav__vertical-item">
        <a className="rf-link" href="#" target="_self">
          Fonctions principales
        </a>
      </li>
      <li className="rf-nav__item cq-nav__vertical-item">
        <a className="rf-link" href="#" target="_self">
          Fonctions spécifiques
        </a>
      </li>
      <li className="rf-nav__item cq-nav__vertical-item">
        <a className="rf-link" href="#" target="_self">
          Diplômes : à venir
        </a>
      </li>
      <li className="rf-nav__item cq-nav__vertical-item">
        <a className="rf-link" href="#" target="_self">
          Mes anciens titres : à venir
        </a>
      </li>
    </ul>
  );
};

export default SideNav;
