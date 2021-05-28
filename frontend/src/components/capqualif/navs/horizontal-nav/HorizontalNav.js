import React from 'react';

const HorizontalNav = () => {
  return (
    <nav className="rf-header no-shadow" aria-label="Menu principal">
      <div className="rf-container">
        <div className="rf-nav">
          <ul className="rf-nav__list">
            <li className="rf-nav__item rf-nav__item--active">
              <a className="rf-link" href="#" target="_self">
                Mes titres
              </a>
            </li>
            <li className="rf-nav__item">
              <a className="rf-link" href="#" target="_self">
                Mon dossier professionnel : à venir
              </a>
            </li>
            <li className="rf-nav__item">
              <a className="rf-link" href="#" target="_self">
                Mes informations personnelles : à venir
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default HorizontalNav;
