import React, { Fragment, useEffect } from 'react';
import { GrAdd } from 'react-icons/gr';
import { useDispatch, useSelector } from 'react-redux';
import { Link, useHistory } from 'react-router-dom';
import PropTypes from 'prop-types';

import styles from './Validity.module.scss';
import {
  ADD_DOCUMENT_ROUTE,
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../app/routesDictionnary';
import { CONDITION } from '../../../dictionnary/demandeDeTitre';
import {
  setCurrentTitreId,
  setCurrentConditionInfos,
} from '../../../redux/capqualif/mobile/requests/currentRequest';
import { findIndex } from '../../../app/utils';
import { changeConditionStatus } from '../../../redux/capqualif/mobile/instructions/instructionsSlice';

const Validity = ({ document, titreId, status, validLabel, notValidLabel }) => {
  /**
   * Boilerplate
   */
  const dispatch = useDispatch();
  const history = useHistory();

  /**
   * Let's select data from global state (redux)
   */
  const possibleRequests = useSelector(
    (state) => state.requests.possibleRequests
  );

  /**
   * Let's check what status to show for each condition
   */
  useEffect(() => {
    if (document.id) {
      const addedDocuments =
        possibleRequests[
          findIndex(possibleRequests, 'requestedTitreId', titreId)
        ].documents;
      const index = findIndex(addedDocuments, 'conditionId', document.id);
      if (
        index !== -1 &&
        addedDocuments[findIndex(addedDocuments, 'conditionId', document.id)]
          .conditionDocuments.length > 0
      ) {
        console.log('change cond status triggered from validity');
        dispatch(changeConditionStatus(document.id));
      }
    }
  }, []);

  /**
   *  ================ UI ================
   */

  const chooseWhatToDisplay = (status) => {
    switch (status) {
      case CONDITION.STATUS.VALID:
        return displayValidCondition();
      case CONDITION.STATUS.NOT_VALID:
        return displayNotValidCondition();
      case CONDITION.STATUS.DOCUMENT_ADDED:
        return displayDocumentAdded();
      default:
        return null;
    }
  };

  const displayValidCondition = () => {
    return (
      <p className="fr-p-1w fr-my-1w`">
        <span
          className="cq-helpers-success-green fr-fi-check-line fr-mr-1w"
          aria-hidden="true"
        ></span>
        <span className={styles.label}>{validLabel}</span>
      </p>
    );
  };

  const displayNotValidCondition = () => {
    return (
      <div
        className={`${styles.centered} ${styles.highlight} fr-p-1w fr-my-1w`}
      >
        <p className={styles.label}>
          <span
            className={`cq-helpers-failure fr-fi-close-line fr-mr-1w`}
            aria-hidden="true"
          ></span>
          {notValidLabel}
        </p>
        <span
          className={`${styles['add-icon']} fr-p-1w`}
          onClick={() => startDocumentAdding(titreId, document)}
        >
          <GrAdd />
        </span>
      </div>
    );
  };

  const startDocumentAdding = (titreId, document) => {
    dispatch(setCurrentTitreId(titreId));
    dispatch(setCurrentConditionInfos(document));
    history.push(`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}`);
  };

  const displayDocumentAdded = () => {
    return (
      <div className={`${styles.centered} fr-p-1w fr-my-1w`}>
        <p className={styles.label}>
          <span
            className="cq-helpers-success-green fr-fi-mail-line fr-mr-1w"
            aria-hidden="true"
          ></span>
          {notValidLabel}
        </p>
      </div>
    );
  };

  return <Fragment>{chooseWhatToDisplay(status)}</Fragment>;
};

Validity.propTypes = {
  document: PropTypes.object,
  titreId: PropTypes.string,
  isValid: PropTypes.bool,
  validLabel: PropTypes.string,
  notValidLabel: PropTypes.string,
};

export default Validity;
