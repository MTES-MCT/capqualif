import React from 'react';
import PropTypes from 'prop-types';

import styles from './CqItemTitreDetails.module.scss';

const CqItemTitreDetails = ({ isVisible, details, action }) => {
  return (
    <div
      className={`${
        isVisible ? '' : styles.hidden
      } cq-helpers__full-width fr-container`}
    >
      <div className="fr-grid-row">Blablabla</div>
    </div>
  );
};

CqItemTitreDetails.propTypes = {};

export default CqItemTitreDetails;
