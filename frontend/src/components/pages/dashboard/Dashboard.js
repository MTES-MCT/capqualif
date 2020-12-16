import React from 'react';
import store from '../../../redux/store';
import { Link } from 'react-router-dom';

import './Dashboard.scss';

import sailorPicMock from '../../../resources/img/mocks/sailor.png';
import menuPicMock from '../../../resources/img/mocks/menu.png';
import TitleCard from '../../elements/cards/title-card/TitleCard';
import Header from '../../elements/header/Header';


const Dashboard = () => {

  const user = store.getState().sailors.sailorBasicData.sailorCivilData;
  const username = user.firstName + ' ' + user.lastName;
  const userSailorNumber = user.sailorNumber;
  console.log(user);

  return (
    <div id="accueil" className="page">
      <Header serviceName={'CapQualif'} adminName={'Direction des affaires maritimes'} username={username} userSailorNumber={userSailorNumber}/>
        
        <div className="cq-section-header rf-container">
  
          <div class="cq-content-left">
            <div class="cq-welcome">
              
              <h1>Bonjour {user.firstName}</h1> 
        
              <h4>Bienvenue sur <strong>CapQualif !</strong></h4>
            </div>
          </div>

          <div class="cq-content-right">
              <button class="rf-btn cq-upper" title="Demander un titre">
                Demander un titre
              </button>
          </div>


        </div>

      <header class="rf-header no-shadow" >
        <div class="rf-container">
        
        <nav class="rf-nav cq" role="navigation" aria-label="Menu principal">
          <ul class="rf-nav__list">
              <li class="rf-nav__item rf-nav__item--active">
                <a class="rf-link" href="#" target="_self">Mes titres</a>
              </li>
              <li class="rf-nav__item">
                <a class="rf-link" href="#" target="_self">Mon dossier</a>
              </li>
              <li class="rf-nav__item">
                <a class="rf-link" href="#" target="_self">Mes informations personelles</a>
              </li>
          </ul>
        </nav>


        </div>
      </header>

      <div class="cq-content rf-container">
        <div class="rf-grid-row">
          <div class="rf-col-3 cq-left-3">
            <ul class="cq-sidemenu">
            <li class="rf-nav__item rf-nav__item--active cq-nav__vertical-item">
            <a class="rf-link" href="#" target="_self">Mes Demande en cours</a>
              </li>
              <li class="rf-nav__item rf-nav__item--active cq-nav__vertical-item">
              <a class="rf-link" href="#" target="_self">Fonction principales</a>
              </li>
              <li class="rf-nav__item cq-nav__vertical-item">
              <a class="rf-link" href="#" target="_self">Fonction secondaire</a>
              </li>
              <li class="rf-nav__item cq-nav__vertical-item">
              <a class="rf-link" href="#" target="_self">Diplômes</a>
              </li>
              <li class="rf-nav__item cq-nav__vertical-item">
              <a class="rf-link" href="#" target="_self">Mes anciens titres</a>
              </li>
            </ul>
          </div>


          <div class="rf-col-9 cq-right-col-9">

          <div id="applications-in-progress" class="cq-main-content">
        <p className="title">Mes demandes en cours</p>
        <ul className="card">
          <li>CFBS : dossier en traitement ⏳</li>
          <li>Premiers secours : dossier à compléter 🖊️</li>
        </ul>
      </div>
      <div id="main-title">
        <p className="title">Fonction principales</p>
        <div className="card">Matelot Pont</div>
      </div>
      <div id="other-titles">
        <p className="title">Mes autres titres</p>
        <div id="other-titles-container">
          {store
            .getState()
            .sailors.sailorBasicData.sailorEducationData.titles.map((title) => (
              <TitleCard key={title.id} title={title} />
            ))}
        </div>
      </div>



          </div>
        </div>


      </div>

      

      {/*

        <nav>
        <div id="photo">
          <img src={sailorPicMock} alt="a fake sailor's pic" />
        </div>
        <div id="menu">
          <img src={menuPicMock} />
        </div>
      </nav>
      <div id="greetings">
        <h3>
          Bonjour,{' '}
          {store.getState().sailors.sailorBasicData.sailorCivilData.firstName} !
        </h3>
      </div>
      <Link to="/new-title-application/choice" id="ask-for-a-title">
        <button>Demander un titre</button>
      </Link>
      <div id="applications-in-progress">
        <p className="title">Mes demandes en cours</p>
        <ul className="card">
          <li>CFBS : dossier en traitement ⏳</li>
          <li>Premiers secours : dossier à compléter 🖊️</li>
        </ul>
      </div>
      <div id="main-title">
        <p className="title">Mon titre le plus récent</p>
        <div className="card">Matelot Pont</div>
      </div>
      <div id="other-titles">
        <p className="title">Mes autres titres</p>
        <div id="other-titles-container">
          {store
            .getState()
            .sailors.sailorBasicData.sailorEducationData.titles.map((title) => (
              <TitleCard key={title.id} title={title} />
            ))}
        </div>
      </div>
      <div id="service-lines">
        <p className="title">Mes lignes de service</p>
        <div className="card service-line-card">
          Ba blab blab la lorem ipsum fugu dzouigi dzouigi
        </div>
        <div className="card  service-line-card">
          Ba blab blab la lorem ipsum fugu dzouigi dzouigi
        </div>
        <div className="card  service-line-card">
          Ba blab blab la lorem ipsum fugu dzouigi dzouigi
        </div>
      </div>
      
      
      
      */}

</div>    
  );
};

export default Dashboard;
