import React, { useState, useEffect } from 'react';
import { store } from '../../../redux/store';
import { Link } from 'react-router-dom';

import './Dashboard.scss';

import TitleCard from '../../_cq/title-card/TitleCard';
import Header from '../../_rf/header/Header';
import CQItem from '../../_cq/cq-item/CQItem';
import { NEW_TITLE_APPLICATION_CHOICE_PATH } from '../../../app/pathes';

const Dashboard = () => {
  const [marinData, setMarinData] = useState({});

  useEffect(() => {
    console.log(store.getState());
    setMarinData(store.getState().marinsReducer.marinBasicData);
  }, [marinData]);

  return (
    <div id="accueil" className="page">
      <div className="cq-section-header rf-container">
        <div className="cq-content-left">
          <div className="cq-welcome">
            <h1>Bonjour, {marinData.prenom}.</h1>
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
              <li className="rf-nav__item rf-nav__item--active cq-nav__vertical-item">
                <a className="rf-link" href="#" target="_self">
                  Mes Demande en cours
                </a>
              </li>
              <li className="rf-nav__item rf-nav__item--active cq-nav__vertical-item">
                <a className="rf-link" href="#" target="_self">
                  Fonction principales
                </a>
              </li>
              <li className="rf-nav__item cq-nav__vertical-item">
                <a className="rf-link" href="#" target="_self">
                  Fonction secondaire
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
                  Mes titres pour exercer des
                </div>
                <h2>fonction principales</h2>
              </div>

              <CQItem
                level={'Appui'}
                type={'Monovalence pont'}
                itemName={'Certificat de matelot pont'}
                timeline={true}
                startDate={'18.09.2020'}
                endDate={'18.09.2025'}
                status={'Valide'}
              />

              <div className="cq-section__title">
                <div className="cq-section__overtitle">
                  Mes titres pour exercer des
                </div>
                <h2>fonction particulières</h2>
              </div>

              <CQItem
                level={''}
                type={'Médicale'}
                itemName={'Enseignement médical de niveau 1'}
                timeline={true}
                startDate={'21.06.2018'}
                endDate={'20.06.2023'}
                status={'Valide'}
              />
              <CQItem
                level={''}
                type={'Radio-télécomunication'}
                itemName={"Certificat général d'opérateur"}
                timeline={true}
                startDate={'12.03.2019'}
                endDate={'11.03.2024'}
                status={'Valide'}
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
