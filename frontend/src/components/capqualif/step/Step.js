import React from 'react';
import { useHistory } from 'react-router-dom';
import PropTypes from 'prop-types';

import styles from './Step.module.scss';

const Step = ({ label, isDark }) => {
  const history = useHistory();

  return (
    <div
      className={`${styles['step-container']} ${isDark ? styles['dark'] : ''}`}
    >
      <h2
        className={`${styles['step-h2']} ${
          isDark ? styles['dark'] : styles['ligth']
        } fr-m-2w`}
      >
        {label}
      </h2>
      <span
        class="fr-fi-close-line fr-mr-2w"
        aria-hidden="true"
        onClick={history.goBack}
      ></span>
    </div>
  );
};

Step.propTypes = {
  label: PropTypes.string.isRequired,
  isDark: PropTypes.bool,
};

export default Step;
