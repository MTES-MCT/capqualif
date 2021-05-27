import React from 'react';
import PropTypes from 'prop-types';

import styles from './CqItemTitreDetails.module.scss';
import CqItemCondition from './cq-item-condition/CqItemCondition';

const CqItemTitreDetails = ({ isVisible, details, action }) => {
  return (
    <div
      className={`${
        isVisible ? '' : styles.hidden
      } cq-helpers__full-width fr-container`}
    >
      <div className="fr-grid-row">
        {details.marinIdentity.basicInfos.firstName}
        {details.marinIdentity.basicInfos.lastName}
        {details.marinIdentity.basicInfos.numeroDeMarin}
        {details.marinIdentity.identityMarkers.isPhotoValid}
        {details.marinIdentity.identityMarkers.isSignatureValid}
      </div>

      {details.results.details.conditions.map((condition) => (
        <CqItemCondition condition={condition} />
      ))}

      {action && <div className="fr-pt-2w">{action}</div>}
    </div>
  );
};

CqItemTitreDetails.propTypes = {};

export default CqItemTitreDetails;
