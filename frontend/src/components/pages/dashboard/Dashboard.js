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
          <Link to="/new-title-application/choice" id="ask-for-a-title">
              <button class="rf-btn cq-upper" title="Demander un titre">
                Demander un titre
              </button>
            </Link>
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
                <a class="rf-link" href="#" target="_self">Mon dossier professionnel</a>
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
            <div class="cq-main-content">
          
            <div class="cq-section__title">
                <div class="cq-section__overtitle">Mes</div>
                <h2>demandes en cours</h2>
            </div>

            <br />


            <div class="cq-section__title">
                <div class="cq-section__overtitle">Mes titres pour exercer des</div>
                <h2>fonction principales</h2>
            </div>


            

                <div class="cq-admin-item cq-admin-item-9 cq-title cq-admin-item--default">
                  <div class="cq-admin-item__header">

                    <div class="cq-admin-item__name-container">
                      <div class="cq-admin-item__main-attributes">
                        Appui &#8226; Monovalence pont
                      </div>
                      <div class="cq-admin-item__name">
                        Certificat de matelot pont
                      </div>
                    </div>
                    <div class="cq-admin-item__right-header">

                      <div class="cq-admin-item__timeline">
                        <div class="start-date">18.09.2020</div>
                        <div class="timeline-graphic">
                          <div class="line"></div>
                          <div class="cursor"></div>
                        </div>
                        <div class="end-date">18.09.2025</div>
                      </div>

                      <div class="cq-admin-item__status cq-admin-item__status--valid">
                        Valide
                      </div>
                      
                      <div class="cq-admin-item__document-links">
                        <div class="cq-admin-item__document--title">
                          <span class="rf-fi-file-line"></span>
                        </div>
                      </div>

                      <div class="cq-admin-item__extend">
                        <span class="rf-fi-arrow-down-s-line"></span>
                      </div>

                    </div>
                  </div>

                  <div class="cq-admin-item__content">
                  </div>

                </div>






                <ul className="card">
                  <li>CFBS : dossier en traitement ⏳</li>
                  <li>Premiers secours : dossier à compléter 🖊️</li>
                </ul>
             

              

              <div id="main-title">  
                <div className="card">Matelot Pont</div>
              </div>

              <div class="cq-section__title">
                <div class="cq-section__overtitle">Mes titres pour exercer des</div>
                <h2>fonction particulières</h2>
              </div>

            
              <div id="other-titles-container">
                {store
                  .getState()
                  .sailors.sailorBasicData.sailorEducationData.titles.map((title) => (
                    <TitleCard key={title.id} title={title} />
                  ))}
              </div>
          </div>

      
        </div> {/* ROW */}
      </div> {/* cq-content */}

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
