import React from 'react';
import store from '../../../redux/store';
import { Link } from 'react-router-dom';

import './Dashboard.scss';

import sailorPicMock from '../../../resources/img/mocks/sailor.png';
import menuPicMock from '../../../resources/img/mocks/menu.png';
import TitleCard from '../../elements/cards/title-card/TitleCard';

const Dashboard = () => {
  return (
    <div id="dashboard">
      {/* <h2>MON TABLEAU DE BORD</h2> */}
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
    </div>
  );
};

export default Dashboard;
