import React, { useState, useEffect } from 'react';
import { store } from '../../../redux/store';
import { Link } from 'react-router-dom';

import './Dashboard.scss';

import TitleCard from '../../_cq/title-card/TitleCard';
import Header from '../../_rf/header/Header';
import CQItem from '../../_cq/cq-item/CQItem';
import { NEW_TITLE_APPLICATION_CHOICE_PATH } from '../../../app/pathes';

const Dashboard = () => {
  return (
    <div id="accueil" className="page">
      <div className="cq-section-header rf-container">
        <div className="cq-content-left">
          <div className="cq-welcome">
            <h1>
              Bonjour, {store.getState().marinsReducer.marinBasicData.prenom}.
            </h1>
            <h4>
              Bienvenue sur <strong>CapQualif</strong> !
            </h4>
          </div>
        </div>
        <div className="cq-content-right">
          <Link to={NEW_TITLE_APPLICATION_CHOICE_PATH} id="ask-for-a-title">
            <button className="rf-btn cq-upper" title="Demander un titre">
              Demander un titre
            </button>
          </Link>
        </div>
      </div>

      <header className="rf-header no-shadow">
        <div className="rf-container">
          <nav
            className="rf-nav cq"
            role="navigation"
            aria-label="Menu principal"
          >
            <ul className="rf-nav__list">
              <li className="rf-nav__item rf-nav__item--active">
                <a className="rf-link" href="#" target="_self">
                  Mes titres
                </a>
              </li>
              <li className="rf-nav__item">
                <a className="rf-link" href="#" target="_self">
                  Mon dossier professionnel
                </a>
              </li>
              <li className="rf-nav__item">
                <a className="rf-link" href="#" target="_self">
                  Mes informations personelles
                </a>
              </li>
            </ul>
          </nav>
        </div>
      </header>

      <div className="cq-content rf-container">
        <div className="rf-grid-row">
          <div className="rf-col-3 cq-left-3">
            <ul className="cq-sidemenu">
              <li className="rf-nav__item cq-nav__vertical-item">
                <a className="rf-link" href="#" target="_self">
                  Mes Demandes en cours
                </a>
              </li>
              <li className="rf-nav__item cq-nav__vertical-item">
                <a className="rf-link" href="#" target="_self">
                  Fonctions principales
                </a>
              </li>
              <li className="rf-nav__item cq-nav__vertical-item">
                <a className="rf-link" href="#" target="_self">
                  Fonctions secondaires
                </a>
              </li>
              <li className="rf-nav__item cq-nav__vertical-item">
                <a className="rf-link" href="#" target="_self">
                  Diplômes
                </a>
              </li>
              <li className="rf-nav__item cq-nav__vertical-item">
                <a className="rf-link" href="#" target="_self">
                  Mes anciens titres
                </a>
              </li>
            </ul>
          </div>
          <div className="rf-col-9 cq-right-col-9">
            <div className="cq-main-content">
              <div className="cq-section__title">
                <div className="cq-section__overtitle">Mes</div>
                <h2>demandes en cours</h2>
              </div>
              <CQItem
                level={''}
                type={'Sécurité'}
                itemName={'Certificat de formation de base à la sécurité'}
                timeline={false}
                startDate={''}
                endDate={''}
                status={'En cours de traitement'}
              />

              <div className="cq-section__title">
                <div className="cq-section__overtitle">
                  Mes <h2>titres</h2>
                </div>
              </div>
              {store
                .getState()
                .marinsReducer.marinBasicData.allTitresOfMarin.map((titre) => (
                  <CQItem
                    level={''}
                    type={titre.capacite}
                    itemName={titre.name}
                    delivranceDate={titre.delivranceDate}
                    expirationDate={titre.expirationDate}
                    status={titre.validityStatus}
                  />
                ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
