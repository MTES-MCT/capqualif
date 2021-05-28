import React, { Fragment } from 'react';
import { GrAdd } from 'react-icons/gr';
import PropTypes from 'prop-types';

import styles from './Validity.module.scss';

const Validity = ({ isValid, validLabel, notValidLabel }) => {
  return (
    <Fragment>
      {isValid ? (
        <p className="fr-p-1w fr-my-1w">
          <span
            className="cq-helpers-success fr-fi-check-line"
            aria-hidden="true"
          ></span>
          {validLabel}
        </p>
      ) : (
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
          <span className={`${styles['add-icon']} fr-mr-1w fr-p-1w`}>
            <GrAdd />
          </span>
        </div>
      )}
    </Fragment>
  );
};

Validity.propTypes = {};

export default Validity;
