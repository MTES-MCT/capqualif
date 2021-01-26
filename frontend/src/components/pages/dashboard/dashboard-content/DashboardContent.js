import React from 'react';
import { store } from '../../../../redux/store';

import './DashboardContent.scss';

import { MARIN } from '../../../../dictionnary/common';
import { IN_PROGRESS } from '../../../../dictionnary/demandeDeTitre';
import CqItem from '../../../_cq/cq-item/CqItem';

const DashboardContent = () => {
  return (
    <div className="cq-dashboard-content">
      <div className="cq-title-small">
        Mes <span className="cq-title-big">demandes en cours </span>: à venir
      </div>
      <CqItem
        owner={MARIN}
        level={''}
        capacite={'Sécurité'}
        itemName={'Certificat de formation de base à la sécurité'}
        timeline={true}
        status={IN_PROGRESS}
      />

      <div className="cq-title-small">
        <div className="cq-section__overtitle">
          Mes <span className="cq-title-big">titres</span>
        </div>
      </div>

      {store
        .getState()
        .marinsReducer.marinBasicData.allTitresOfMarin.map((titre) => (
          <CqItem
            level={''}
            capacite={titre.capacite}
            itemName={titre.name}
            delivranceDate={titre.delivranceDate}
            expirationDate={titre.expirationDate}
            status={titre.validityStatus}
          />
        ))}
    </div>
  );
};

export default DashboardContent;
