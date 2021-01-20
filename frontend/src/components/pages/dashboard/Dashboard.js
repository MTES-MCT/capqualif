import React, { useState, useEffect } from 'react';
import { store } from '../../../redux/store';
import { Link } from 'react-router-dom';

import './Dashboard.scss';

import { NEW_TITLE_APPLICATION_CHOICE_ROUTE } from '../../../app/routesList';
// import TitleCard from '../../_cq/title-card/TitleCard';
// import Header from '../../_rf/header/Header';
import CQItem from '../../_cq/cq-item/CQItem';
import SideNav from '../../../components/_cq/navs/side-nav/SideNav';
import Button from '../../_cq/button/Button';
import HorizontalNav from '../../_cq/navs/horizontal-nav/HorizontalNav';

const Dashboard = () => {
  return (
    <div id="dashboard">
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
        <Button
          label="Demander un titre"
          route={NEW_TITLE_APPLICATION_CHOICE_ROUTE}
        />
      </div>
      <HorizontalNav />
      <div className="cq-content rf-container">
        <div className="rf-grid-row">
          <div className="rf-col-3 cq-left-3">
            <SideNav />
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
