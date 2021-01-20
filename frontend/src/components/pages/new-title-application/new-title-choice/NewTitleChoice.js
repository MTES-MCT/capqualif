import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { store } from '../../../../redux/store';

import { getAllTitles } from '../../../../redux/features/titlesCatalog/titlesSlice';

import './NewTitleChoice.scss';
import SectionHead from '../../../_cq/section/section-head/SectionHead';
import TitleCard from '../../../_cq/title-card/TitleCard';
import Header from '../../../_rf/header/Header';
import { NEW_TITLE_APPLICATION_DETAILS_PATH } from '../../../../app/routesList';

const NewTitleChoice = () => {
  const dispatch = useDispatch();
  const allTitles = useSelector((state) => state.titlesReducer.allTitles);

  useEffect(() => {
    // TO DO : implement dispatch(getSuggestedTitles());
    dispatch(getAllTitles());
  }, []);

  const user = store.getState().sailors.sailorBasicData.sailorCivilData;
  const username = user.firstName + ' ' + user.lastName;
  const userSailorNumber = user.sailorNumber;

  return (
    <div id="new-title-choice" className="page">
      <header class="rf-header cq-subheader no-shadow">
        <div class="rf-container cq-breadcrumb">
          <a class="cq-simple-link">Retour à l'accueil</a>
        </div>
      </header>

      <SectionHead
        title="Demande d'un nouveau titre"
        subtitle="Choisissez le titre"
      />
      <div>
        <h3>Titres recommandés pour vous</h3>
        {allTitles.map((title) => (
          <Link to={NEW_TITLE_APPLICATION_DETAILS_PATH}>
            <TitleCard key={title.id} title={title} titleType="fromCatalog" />
          </Link>
        ))}
      </div>
      <div>
        <h3>Tous les titres</h3>
        <input type="text"></input>
        {allTitles.map((title) => (
          <Link to={NEW_TITLE_APPLICATION_DETAILS_PATH}>
            <TitleCard key={title.id} title={title} titleType="fromCatalog" />
          </Link>
        ))}
      </div>
    </div>
  );
};

export default NewTitleChoice;
