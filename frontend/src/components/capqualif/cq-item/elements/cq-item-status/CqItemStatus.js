import React, { Fragment } from 'react';
import PropTypes from 'prop-types';
import { VscCircleFilled } from 'react-icons/vsc';

import styles from './CqItemStatus.module.scss';
import {
  STATUS_REQUEST,
  STATUS_DOSSIER,
  STATUS_TITRE,
  STATUS_TYPES,
} from '../../../../../dictionnary/demandeDeTitre';

const CqItemStatus = ({ status }) => {
  const whatToShow = (status) => {
    switch (status.type) {
      case STATUS_TYPES.DOSSIER:
        return fillModel(
          status.value,
          STATUS_DOSSIER.COMPLETE,
          STATUS_DOSSIER.NOT_COMPLETE,
          true
        );
      case STATUS_TYPES.TITRE_VALIDITY:
        return fillModel(
          status.value,
          STATUS_TITRE.VALID,
          STATUS_TITRE.NOT_VALID,
          false
        );
      case STATUS_TYPES.REQUEST:
        return fillModel(status.value, STATUS_REQUEST.SENT.SHORT, null, false);
      default:
        return null;
    }
  };

  const fillModel = (statusValue, successLabel, failureLabel, isWithCircle) => {
    return (
      <Fragment>
        {statusValue
          ? successLabel && (
              <Fragment>
                <span
                  className={`${styles['cq-item-status-container-text']} cq-helpers-success fr-pr-1w`}
                >
                  {successLabel}
                </span>
                <span
                  className={`${styles['cq-item-status-container-icon']} cq-helpers-success`}
                >
                  {isWithCircle && <VscCircleFilled />}
                </span>
              </Fragment>
            )
          : failureLabel && (
              <Fragment>
                <span
                  className={`${styles['cq-item-status-container-text']} cq-helpers-failure fr-pr-1w`}
                >
                  {failureLabel}
                </span>
                <span
                  className={`${styles['cq-item-status-container-icon']} cq-helpers-failure`}
                >
                  {isWithCircle && <VscCircleFilled />}
                </span>
              </Fragment>
            )}
      </Fragment>
    );
  };

  return (
    <div className={`${styles['cq-item-status-container']}`}>
      {whatToShow(status)}
    </div>
  );
};

CqItemStatus.propTypes = {
  status: PropTypes.object.isRequired,
};

export default CqItemStatus;
