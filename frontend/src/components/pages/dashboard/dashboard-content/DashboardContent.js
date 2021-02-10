import React from 'react';
import { useSelector } from 'react-redux';

import './DashboardContent.scss';

import CqItemOfMarin from '../../../_cq/cq-item/marin/CqItemOfMarin';
import ActionableCqItemOfMarin from '../../../_cq/cq-item/marin/actionable-cq-item-of-marin/ActionableCqItemOfMarin';
import {
  ACTION_TYPES,
  BUTTON_LABELS,
  STATUS_TITRE,
} from '../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../dictionnary/saas/variables';

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
            <ActionableCqItemOfMarin
              subtitle={titreOfMarin.capacite}
              name={titreOfMarin.name}
              dates={titreOfMarin.dates}
              status={titreOfMarin.validityStatus}
              shouldShowAction={
                titreOfMarin.validityStatus !== STATUS_TITRE.VALID
              }
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
            <ActionableCqItemOfMarin
              subtitle={titreOfMarin.capacite}
              name={titreOfMarin.name}
              dates={titreOfMarin.dates}
              status={titreOfMarin.validityStatus}
              action={
                titreOfMarin.validityStatus !== STATUS_TITRE.VALID && {
                  label: BUTTON_LABELS.RENEW,
                  labelSize: FONT_SIZES.VERY_SMALL,
                  route: '',
                  actionType: ACTION_TYPES.SECONDARY,
                }
              }
            />
          ))}
      </div>
    </div>
  );
};

export default DashboardContent;
