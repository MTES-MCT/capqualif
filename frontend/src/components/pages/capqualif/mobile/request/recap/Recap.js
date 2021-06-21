import React, { Fragment, useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useHistory } from 'react-router-dom';
import PropTypes from 'prop-types';

import styles from './Recap.module.scss';

import Step from '../../../../../capqualif/step/Step';
import {
  BUTTON_LABELS,
  DETAILS_TYPE,
  RESTRICTIONS,
  STATUS_TYPES,
  STEPS,
  VALIDITY,
  VARIOUS,
} from '../../../../../../dictionnary/demandeDeTitre';
import CqItemHeader from '../../../../../capqualif/cq-item/elements/cq-item-header/CqItemHeader';
import CqItemFlagged from '../../../../../capqualif/cq-item/elements/cq-item-flagged/CqItemFlagged';
import CqItemTitre from '../../../../../capqualif/cq-item/mobile/cq-item-titre/CqItemTitre';
import { BUTTON_WIDTH } from '../../../../../../dictionnary/saas/variables';
import {
  CONFIRMATION_ROUTE,
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../../app/routesDictionnary';
import { convertDateToEuropeanFormat } from '../../../../../../app/utils';
import ButtonAction from '../../../../../capqualif/buttons/button-action/ButtonAction';
import {
  addRequestedTitre,
  addRequestor,
  addStartDate,
} from '../../../../../../redux/capqualif/mobile/requests/requestsSlice';

const Recap = (props) => {
  const dispatch = useDispatch();
  const history = useHistory();

  const findTitreIndex = (array, value) => {
    return array.findIndex((titre) => titre.titre.id === value);
  };

  const titres = useSelector((state) => state.instructions.possibleTitres);
  const currentTitreId = useSelector(
    (state) => state.currentRequest.currentTitre.id
  );
  const [titre, setTitre] = useState(
    titres[findTitreIndex(titres, currentTitreId)]
  );

  const { numeroDeMarin, nom, prenom } = useSelector(
    (state) => state.marins.marinBasicData
  );

  const requestedTitreId = useSelector(
    (state) => state.currentRequest.currentTitre.id
  );

  const displayRestrictions = (restrictions) => {
    if (restrictions.length === 0) {
      return <p>{RESTRICTIONS.NO_RESTRICTION}</p>;
    }
    return (
      <p>
        Restrictions&nbsp;:{' '}
        {restrictions.map((restriction) => (
          <p>{restriction}</p>
        ))}
      </p>
    );
  };

  const confirmRequest = () => {
    dispatch(
      addRequestor({
        numeroDeMarin,
        firstName: prenom,
        lastName: nom,
      })
    );
    dispatch(addStartDate());
    dispatch(addRequestedTitre(requestedTitreId));
    history.push(`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${CONFIRMATION_ROUTE}`);
  };

  /**
   * TODO: transfer this to backend
   * */
  const computeEndDate = (startDate, duration) => {
    const start = new Date(startDate);
    const endDate = new Date(
      start.getFullYear() + parseInt(duration),
      start.getMonth(),
      start.getDate() - 1
    );
    return convertDateToEuropeanFormat(endDate);
  };

  const today = () => {
    return new Date();
  };

  return (
    <Fragment>
      <Step label={STEPS.CONFIRM} />
      <div className="fr-mt-2w fr-px-2w">
        <CqItemHeader
          subtitle={'Appui · Pont'}
          name={'Certificat de Matelot Pont'}
        />
        {displayRestrictions(titre.instruction.results.restrictions)}
        <div className={`${styles['spaced']} fr-grid-row fr-my-3w`}>
          <p>{VALIDITY.DURATION}</p>
          <CqItemFlagged label={`${titre.titre.validityDurationInYears} ans`} />
        </div>
        <div className={`${styles['spaced']} fr-grid-row fr-my-2w`}>
          <p>{VALIDITY.START_DATE}</p>
          <CqItemFlagged label={convertDateToEuropeanFormat(today.startDate)} />
        </div>
        <div className={`${styles['spaced']} fr-grid-row fr-my-2w`}>
          <p>{VALIDITY.END_DATE}</p>
          <CqItemFlagged
            label={computeEndDate(
              today.startDate,
              titre.titre.validityDurationInYears
            )}
          />
        </div>
        <p className="fr-mb-2w">{VARIOUS.DATES_WARNING}</p>
        <CqItemTitre
          subtitle={VARIOUS.RECAPITULATIF}
          name={displayRestrictions(titre.instruction.results.restrictions)}
          status={{
            type: STATUS_TYPES.DOSSIER,
            value: titre.instruction.dossierStatus,
          }}
          details={{
            type: DETAILS_TYPE.CONDITIONS,
            content: titre.instruction,
          }}
        />
        <ButtonAction
          label={BUTTON_LABELS.CONFIRM}
          width={BUTTON_WIDTH.FULL}
          marginsInRem={{ top: 1, bottom: 1 }}
          actionOnClick={confirmRequest}
        />
      </div>
    </Fragment>
  );
};

Recap.propTypes = {};

export default Recap;
