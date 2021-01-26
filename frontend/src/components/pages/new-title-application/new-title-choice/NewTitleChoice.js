import React, { Fragment, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { store } from '../../../../redux/store';

import { getAllTitles } from '../../../../redux/features/titlesCatalog/titlesSlice';

import './NewTitleChoice.scss';
import SectionHead from '../../../_cq/section/section-head/SectionHead';
import TitleCard from '../../../_cq/title-card/TitleCard';
import CqItem from '../../../_cq/cq-item/CqItem';
import { NEW_TITLE_APPLICATION_DETAILS_ROUTE } from '../../../../app/routesList';
import { CATALOG } from '../../../../dictionnary/common';
import Breadcrumb from '../../../_cq/breadcrumb/Breadcrumb';

const NewTitleChoice = () => {
  const dispatch = useDispatch();
  const allTitres = useSelector((state) => state.titlesReducer.allTitles);

  useEffect(() => {
    dispatch(getAllTitles());
  }, [dispatch]);

  return (
    <Fragment>
      <Breadcrumb />
      <div id="new-title-choice" className="rf-container">
        <div className="rf-grid-row"></div>
        <div className="rf-grid-row">
          <div class="rf-col">
            <SectionHead
              title="Demande d'un nouveau titre"
              subtitle="Choisissez le titre"
            />
          </div>
        </div>
        <div className="rf-grid-row">
          <div class="rf-col">
            <h3>Titres recommandés pour vous : à venir</h3>
            <CqItem
              owner={CATALOG}
              level={''}
              capacite={'Sécurité'}
              itemName={'Certificat de formation de base à la sécurité'}
            />
          </div>
          <div class="rf-col">
            <h3>Tous les titres : à venir</h3>
            <input type="text"></input>
            <CqItem
              owner={CATALOG}
              level={''}
              capacite={'Sécurité'}
              itemName={'Certificat de formation de base à la sécurité'}
            />
          </div>
        </div>
      </div>
    </Fragment>
  );
};

export default NewTitleChoice;
