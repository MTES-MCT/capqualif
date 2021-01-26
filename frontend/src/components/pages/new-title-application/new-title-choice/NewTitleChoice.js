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
import { OWNER } from '../../../../dictionnary/common';
import Breadcrumb from '../../../_cq/breadcrumb/Breadcrumb';
import { G800, MARIANNE_BLUE } from '../../../../dictionnary/saas/colors';

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
        <div className="rf-grid-row">
          <div class="rf-col">
            <SectionHead
              subtitle="Demande d'un nouveau titre"
              title="Choix du titre"
              color={MARIANNE_BLUE}
            />
          </div>
        </div>
        <div className="rf-grid-row">
          <div class="rf-search-bar" id="search-input">
            <label class="rf-label" for="search-input-input">
              Rechercher un titre
            </label>
            <input
              class="rf-input"
              placeholder="Rechercher un titre"
              type="search"
              id="search-input-input"
              name="search-input-input"
            />
            <button class="rf-btn" title="Rechercher">
              <span>Rechercher</span>
            </button>
          </div>
        </div>
        <div className="rf-grid-row rf-grid-row--gutters">
          <div class="rf-col">
            <SectionHead
              subtitle="Suggestions pour exercer des"
              title="Fonctions principales"
              color={G800}
            />
            <CqItem
              owner={OWNER.CATALOG}
              level={''}
              capacite={'Sécurité'}
              itemName={'Certificat de matelot pont'}
            />
            <CqItem
              owner={OWNER.CATALOG}
              level={''}
              capacite={'Sécurité'}
              itemName={'Certificat de formation de base à la sécurité'}
            />
            <CqItem
              owner={OWNER.CATALOG}
              level={''}
              capacite={'Sécurité'}
              itemName={'Certificat de formation de base à la sécurité'}
            />
          </div>
          <div class="rf-col">
            <SectionHead
              subtitle="Suggestions pour exercer des"
              title="Fonctions spécifiques"
              color={G800}
            />
            <CqItem
              owner={OWNER.CATALOG}
              level={''}
              capacite={'Médicale'}
              itemName={'Formation médicale de base '}
            />
            <CqItem
              owner={OWNER.CATALOG}
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
