import React from 'react';
import { store } from '../../../../redux/store';

import './DashboardContent.scss';

import CQItem from '../../../_cq/cq-item/CQItem';

const DashboardContent = () => {
  return (
    <div className="cq-dashboard-content">
      <div className="cq-title-small">
        Mes <span className="cq-title-big">demandes en cours</span>
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

      <div className="cq-title-small">
        <div className="cq-section__overtitle">
          Mes <span className="cq-title-big">titres</span>
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
  );
};

export default DashboardContent;
