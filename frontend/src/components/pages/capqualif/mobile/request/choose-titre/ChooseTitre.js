import React from 'react';
import { useSelector } from 'react-redux';
import PropTypes from 'prop-types';

import styles from './ChooseTitre.module.scss';

import {
  BUTTON_LABELS,
  DETAILS_TYPE,
  STATUS_TYPES,
  STEPS,
  VARIOUS,
} from '../../../../../../dictionnary/demandeDeTitre';
import {
  BUTTON_WIDTH,
  FONT_SIZES,
} from '../../../../../../dictionnary/saas/variables';
import {
  MOBILE,
  NEW_TITRE_REQUEST_RECAP_ROUTE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../../app/routesDictionnary';
import CqItemTitre from '../../../../../capqualif/cq-item/mobile/cq-item-titre/CqItemTitre';
import Step from '../../../../../capqualif/step/Step';

const ChooseTitre = (props) => {
  const allTitres = useSelector((state) => state.instructionsReducer.titres);

  return (
    <div>
      <Step label={STEPS.REQUEST_NEW} />
      <div>
        <h3 className={`${styles['cq-choose-titre-h3']} fr-m-2w`}>
          Choix du titre
        </h3>
        <div className={`${styles['cq-choose-titre-titres-container']}`}>
          {allTitres.map((titre) => (
            <CqItemTitre
              subtitle={titre.titre.capacite}
              name={titre.titre.name}
              status={{
                type: STATUS_TYPES.DOSSIER,
                value: titre.instruction.dossierStatus,
              }}
              details={{
                type: DETAILS_TYPE.CONDITIONS,
                content: titre.instruction,
              }}
              action={{
                label: BUTTON_LABELS.DEMAND_THIS,
                labelSize: FONT_SIZES.SMALL,
                width: BUTTON_WIDTH.FULL,
                route:
                  '/' +
                  MOBILE +
                  '/' +
                  NEW_TITRE_REQUEST_ROUTE +
                  '/' +
                  NEW_TITRE_REQUEST_RECAP_ROUTE,
              }}
            />
          ))}
        </div>
        <p className={`${styles['cq-choose-titre-warning-text']} fr-m-2w`}>
          {VARIOUS.CAPQUALIF_BETA_WARNING}
        </p>
      </div>
    </div>
  );
};

ChooseTitre.propTypes = {};

export default ChooseTitre;
