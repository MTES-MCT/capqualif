import React, { Fragment } from 'react';
import { GrAdd, GrDocumentVerified } from 'react-icons/gr';
import PropTypes from 'prop-types';

import styles from './Validity.module.scss';
import { Link } from 'react-router-dom';
import {
  ADD_DOCUMENT_ROUTE,
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../app/routesDictionnary';
import { CONDITION } from '../../../dictionnary/demandeDeTitre';

const Validity = ({ documentName, status, validLabel, notValidLabel }) => {
  const chooseWhatToDisplay = (status) => {
    console.log(status);
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
      <p className="fr-p-1w fr-my-1w">
        <span
          className="cq-helpers-success-green fr-fi-check-line"
          aria-hidden="true"
        ></span>
        {validLabel}
      </p>
    );
  };

  const displayNotValidCondition = () => {
    return (
      <div
        className={`${styles.centered} ${styles.highlight} fr-p-1w fr-my-1w`}
      >
        <p>
          <span
            className={`cq-helpers-failure fr-fi-close-line`}
            aria-hidden="true"
          ></span>
          {notValidLabel}
        </p>
        <Link
          to={`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}/${documentName}/`}
        >
          <span className={`${styles['add-icon']} fr-p-1w`}>
            <GrAdd />
          </span>
        </Link>
      </div>
    );
  };

  const displayDocumentAdded = () => {
    return (
      <div className={`${styles.centered} fr-p-1w fr-my-1w`}>
        <p>
          <span aria-hidden="true"></span>
          {notValidLabel}
        </p>
        <Link
          to={`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}/${documentName}/`}
        >
          <span className={`${styles['add-icon']} fr-p-1w`}>
            <GrDocumentVerified />
          </span>
        </Link>
      </div>
    );
  };

  return <Fragment>{chooseWhatToDisplay(status)}</Fragment>;
};

Validity.propTypes = {
  documentName: PropTypes.string,
  isValid: PropTypes.bool,
  validLabel: PropTypes.string,
  notValidLabel: PropTypes.string,
};

export default Validity;
