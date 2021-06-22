import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useHistory } from 'react-router-dom';
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
  NEW_TITRE_REQUEST_RECAP_ROUTE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../../app/routesDictionnary';
import CqItemTitre from '../../../../../capqualif/cq-item/mobile/cq-item-titre/CqItemTitre';
import Step from '../../../../../capqualif/step/Step';
import { setCurrentTitreId } from '../../../../../../redux/capqualif/mobile/requests/currentRequest';
import { findIndex } from '../../../../../../app/utils';

const ChooseTitre = (props) => {
  const history = useHistory();
  const dispatch = useDispatch();

  const allTitres = useSelector((state) => state.instructions.possibleTitres);
  const possibleRequests = useSelector(
    (state) => state.requests.possibleRequests
  );

  /**
   * TODO: move to CqItemTitre?
   */
  const requestThisTitre = (id, possibleRequests) => {
    dispatch(setCurrentTitreId(id));
    if (
      possibleRequests[findIndex(possibleRequests, 'requestedTitreId', id)]
        .canBeSent
    ) {
      history.push(
        `${NEW_TITRE_REQUEST_ROUTE}/${NEW_TITRE_REQUEST_RECAP_ROUTE}`
      );
    }
  };

  const whatStatus = () => {
    return;
  };

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
              id={titre.informations.id}
              subtitle={titre.informations.capacite}
              name={titre.informations.name}
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
                onClick: () => requestThisTitre(titre.informations.id),
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
