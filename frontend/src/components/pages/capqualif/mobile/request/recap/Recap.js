import React, { Fragment } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { unwrapResult } from '@reduxjs/toolkit';
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
  ERROR_ROUTE,
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../../app/routesDictionnary';
import {
  convertDateToEuropeanFormat,
  findIndex,
} from '../../../../../../app/utils';
import {
  addStartDate,
  postRequest,
} from '../../../../../../redux/capqualif/mobile/requests/requestsSlice';
import GenericError from '../../../../../capqualif/errors/GenericError';
import ButtonAction from '../../../../../capqualif/buttons/button-action/ButtonAction';

const Recap = (props) => {
  /**
   * Boilerplate
   */
  const dispatch = useDispatch();
  const history = useHistory();

  /**
   * Let's select data from global state (redux)
   */
  const titres =
    useSelector((state) => state.instructions.possibleTitres) || [];
  const currentTitreId = useSelector(
    (state) => state.currentRequest.currentTitre.id
  );
  const requestor = useSelector((state) => state.requests.requestor);
  const possibleRequests = useSelector(
    (state) => state.requests.possibleRequests
  );

  /**
   * Let's find the titre that the marin is requesting in all possible titres
   * to display it in the UI!
   */
  const titre = titres[findIndex(titres, 'informations.id', currentTitreId)];

  /**
   * Actions on click event
   */
  const confirmRequest = () => {
    dispatch(addStartDate(currentTitreId));
    dispatch(
      postRequest({
        requestor: requestor,
        requestDetails:
          possibleRequests[
            findIndex(possibleRequests, 'requestedTitreId', currentTitreId)
          ],
      })
    )
      .then(unwrapResult)
      .then(() => {
        history.push(
          `/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${CONFIRMATION_ROUTE}`
        );
      })
      .catch(() => {
        history.push(`/${MOBILE}/${ERROR_ROUTE}`);
      });
  };

  /**
   * TODO: transfer this to backend?
   * */
  const computeEndDate = (startDate, duration) => {
    const endDate = new Date(
      startDate.getFullYear() + parseInt(duration),
      startDate.getMonth(),
      startDate.getDate() - 1
    );
    return convertDateToEuropeanFormat(endDate);
  };

  const getTodayDate = () => {
    return new Date();
  };

  /**
   *  ================ UI ================
   */
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

  return titre ? (
    <Fragment>
      <Step label={STEPS.CONFIRM} />
      <div className="fr-mt-2w fr-px-2w">
        <CqItemHeader
          subtitle={titre?.informations?.capacite}
          name={titre?.informations?.name}
        />
        {displayRestrictions(titre?.instruction?.results?.restrictions)}
        <div className={`${styles['spaced']} fr-grid-row fr-my-3w`}>
          <p>{VALIDITY.DURATION}</p>
          <CqItemFlagged
            label={`${titre?.informations?.validityDurationInYears} ans`}
          />
        </div>
        <div className={`${styles['spaced']} fr-grid-row fr-my-2w`}>
          <p>{VALIDITY.START_DATE}</p>
          <CqItemFlagged label={convertDateToEuropeanFormat(getTodayDate())} />
        </div>
        <div className={`${styles['spaced']} fr-grid-row fr-my-2w`}>
          <p>{VALIDITY.END_DATE}</p>
          <CqItemFlagged
            label={computeEndDate(
              getTodayDate(),
              titre?.informations?.validityDurationInYears
            )}
          />
        </div>
        <p className="fr-mb-2w">{VARIOUS.DATES_WARNING}</p>
        <CqItemTitre
          id={currentTitreId}
          subtitle={VARIOUS.RECAPITULATIF}
          name={displayRestrictions(titre?.instruction?.results?.restrictions)}
          status={{
            type: STATUS_TYPES.DOSSIER,
          }}
          details={{
            type: DETAILS_TYPE.CONDITIONS,
            content: titre?.instruction,
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
  ) : (
    <div className={`${styles['centered']}`}>
      <GenericError />
    </div>
  );
};

Recap.propTypes = {};

export default Recap;
