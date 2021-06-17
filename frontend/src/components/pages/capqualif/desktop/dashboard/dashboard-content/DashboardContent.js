import React from 'react';
import { useSelector } from 'react-redux';

import './DashboardContent.scss';

import CqItemOfMarin from '../../../../../capqualif/cq-item/marin/CqItemOfMarin';
import {
  ACTION_TYPES,
  BUTTON_LABELS,
  CATEGORY_NAMES,
  STATUS_TITRE,
} from '../../../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../../../dictionnary/saas/variables';

const DashboardContent = () => {
  const allTitresOfMarin = useSelector(
    (state) => state.marins.marinBasicData.allTitresOfMarin
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
              existingTitreAction={
                titreOfMarin.validityStatus !== STATUS_TITRE.VALID && {
                  label: BUTTON_LABELS.RENEW,
                  labelSize: FONT_SIZES.VERY_SMALL,
                  route: '',
                  actionType: ACTION_TYPES.SECONDARY,
                }
              }
              details={[
                {
                  label: CATEGORY_NAMES.CAPACITES,
                  infos: [titreOfMarin.capacite],
                },
                {
                  label: CATEGORY_NAMES.RESTRICTIONS,
                  infos: titreOfMarin.restrictionsInStandardFormat,
                },
                {
                  label: CATEGORY_NAMES.DELIVRANCE_AUTORITE,
                  infos: titreOfMarin.autoriteDeDelivrance,
                },
                {
                  label: CATEGORY_NAMES.DELIVRANCE_DATE,
                  infos: titreOfMarin.dates.delivranceDate,
                },
              ]}
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
              existingTitreAction={
                titreOfMarin.validityStatus !== STATUS_TITRE.VALID && {
                  label: BUTTON_LABELS.RENEW,
                  labelSize: FONT_SIZES.VERY_SMALL,
                  route: '',
                  actionType: ACTION_TYPES.SECONDARY,
                }
              }
              details={[
                {
                  label: CATEGORY_NAMES.CAPACITES,
                  infos: titreOfMarin.capacite,
                },
                {
                  label: CATEGORY_NAMES.RESTRICTIONS,
                  infos: titreOfMarin.restrictionsInStandardFormat,
                },
                {
                  label: CATEGORY_NAMES.DELIVRANCE_AUTORITE,
                  infos: titreOfMarin.autoriteDeDelivrance,
                },
                {
                  label: CATEGORY_NAMES.DELIVRANCE_DATE,
                  infos: titreOfMarin.dates.delivranceDate,
                },
              ]}
            />
          ))}
      </div>
    </div>
  );
};

export default DashboardContent;
