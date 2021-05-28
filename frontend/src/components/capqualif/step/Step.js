import React from 'react';
import { useHistory } from 'react-router-dom';
import PropTypes from 'prop-types';

import styles from './Step.module.scss';

const Step = ({ label }) => {
  let history = useHistory();

  return (
    <div className={styles['step-container']}>
      <h2 className={`${styles['step-h2']} fr-m-2w`}>{label}</h2>
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
};

export default Step;
