import React from 'react';
import PropTypes from 'prop-types';

import styles from './CqItemTitreDetails.module.scss';
import CqItemCondition from './cq-item-condition/CqItemCondition';
import { Fragment } from 'react';

const CqItemTitreDetails = ({ isVisible, details, action }) => {
  return (
    <div className={`${isVisible ? '' : styles.hidden}`}>
      <div className={`${styles.section} fr-py-2w fr-mt-3w`}>
        {details.marinIdentity.basicInfos.firstName}
        {details.marinIdentity.basicInfos.lastName}
      </div>
      <div className="">{details.marinIdentity.basicInfos.numeroDeMarin}</div>

      {details.marinIdentity.identityMarkers.isPhotoValid}
      {details.marinIdentity.identityMarkers.isSignatureValid}

      {details.results.details.conditions.map((condition) => (
        <CqItemCondition condition={condition} />
      ))}

      {action && <div className="fr-pt-2w">{action}</div>}
    </div>
  );
};

CqItemTitreDetails.propTypes = {};

export default CqItemTitreDetails;
