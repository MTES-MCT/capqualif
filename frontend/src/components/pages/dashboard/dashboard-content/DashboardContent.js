import React from 'react';
import { useSelector } from 'react-redux';

import './DashboardContent.scss';

import CqItemOfMarin from '../../../_cq/cq-item/marin/CqItemOfMarin';

const DashboardContent = () => {
  const allTitresOfMarin = useSelector(
    (state) => state.marinsReducer.marinBasicData.allTitresOfMarin
  );

  return (
    <div className="cq-dashboard-content">
      <div className="rf-my-2w">
        <div className="cq-title-small">
          <div className="cq-section__overtitle">
            Mes titres pour exercer des{' '}
            <span className="cq-title-big">Fonctions principales</span>
          </div>
        </div>
        {/* TO DO : remove this temporary patch check and make something more robust */}
        {allTitresOfMarin
          .filter((titreOfMarin) => titreOfMarin.capacite !== '')
          .map((titreOfMarin) => (
            <CqItemOfMarin
              subtitle={titreOfMarin.capacite}
              name={titreOfMarin.name}
              dates={titreOfMarin.dates}
              status={titreOfMarin.validityStatus}
            />
          ))}
      </div>
      <div className="rf-my-2w">
        <div className="cq-title-small">
          <div className="cq-section__overtitle">
            Mes titres pour exercer des{' '}
            <span className="cq-title-big">Fonctions spécifiques</span>
          </div>
        </div>
        {allTitresOfMarin
          .filter((titreOfMarin) => titreOfMarin.capacite === '')
          .map((titreOfMarin) => (
            <CqItemOfMarin
              subtitle={titreOfMarin.capacite}
              name={titreOfMarin.name}
              dates={titreOfMarin.dates}
              status={titreOfMarin.validityStatus}
            />
          ))}
      </div>
    </div>
  );
};

export default DashboardContent;
