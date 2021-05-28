import React, { Fragment } from 'react';
import PropTypes from 'prop-types';
import { VscCircleFilled } from 'react-icons/vsc';

import styles from './CqItemStatus.module.scss';

const CqItemStatus = ({ status }) => {
  return (
    <div className={`${styles['cq-item-status-container']}`}>
      {status ? (
        <Fragment>
          <span
            className={`${styles['cq-item-status-container-text']} cq-helpers-success fr-pr-1w`}
          >
            Dossier complet
          </span>
          <span
            className={`${styles['cq-item-status-container-icon']} cq-helpers-success`}
          >
            <VscCircleFilled />
          </span>
        </Fragment>
      ) : (
        <Fragment>
          <span
            className={`${styles['cq-item-status-container-text']} cq-helpers-failure fr-pr-1w`}
          >
            Dossier incomplet
          </span>
          <span
            className={`${styles['cq-item-status-container-icon']} cq-helpers-failure`}
          >
            <VscCircleFilled />
          </span>
        </Fragment>
      )}
    </div>
  );
};

CqItemStatus.propTypes = {
  status: PropTypes.string.isRequired,
};

export default CqItemStatus;
