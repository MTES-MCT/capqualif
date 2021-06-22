import React, { Fragment } from 'react';
import { GrAdd } from 'react-icons/gr';
import { useDispatch } from 'react-redux';
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

const Validity = ({ document, titreId, status, validLabel, notValidLabel }) => {
  const history = useHistory();
  const dispatch = useDispatch();

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
