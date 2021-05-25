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
      <div className="fr-grid-row">Identité</div>
      <div className="fr-grid-row">Aptitude médicale</div>
      <div className="fr-grid-row">Qualifications principales</div>
      <div className="fr-grid-row">Qualifications spécifiques</div>
      {action && <div className="fr-pt-2w">{action}</div>}
    </div>
  );
};

CqItemTitreDetails.propTypes = {};

export default CqItemTitreDetails;
