import React from 'react';
import { GrAdd } from 'react-icons/gr';
import PropTypes from 'prop-types';

import commonStyles from './common.module.scss';
import styles from './CqItemTitreDetails.module.scss';
import CqItemCondition from './cq-item-condition/CqItemCondition';
import { Fragment } from 'react';
import Validity from '../../../../validity/Validity';
import { IDENTITY_MARKERS } from '../../../../../../dictionnary/demandeDeTitre';

const CqItemTitreDetails = ({ isVisible, details, action }) => {
  return (
    <div className={`${isVisible ? '' : styles.hidden}`}>
      <div
        className={`${commonStyles.section} cq-helpers-bordered-section fr-p-2w fr-mt-3w fr-grid-row`}
      >
        <div>
          <h3>Identitié</h3>
          <h4>Prénom, nom</h4>
          <p className={`${styles.identity}`}>
            {details.marinIdentity.basicInfos.firstName}&nbsp;
            {details.marinIdentity.basicInfos.lastName}
          </p>
        </div>
        <h4>Numéra d'identification</h4>
        <p className={`${styles.identity}`}>
          {details.marinIdentity.basicInfos.numeroDeMarin}
        </p>
        <div className="fr-mt-2w">
          <Validity
            isValid={details.marinIdentity.identityMarkers.isPhotoValid}
            validLabel={IDENTITY_MARKERS.PHOTO}
            notValidLabel={IDENTITY_MARKERS.PHOTO}
          />
          <Validity
            isValid={details.marinIdentity.identityMarkers.isSignatureValid}
            validLabel={IDENTITY_MARKERS.SIGNATURE}
            notValidLabel={IDENTITY_MARKERS.SIGNATURE}
          />
        </div>
      </div>

      {details.results.details.conditions.map((condition) => (
        <CqItemCondition condition={condition} />
      ))}

      {action && <div>{action}</div>}
    </div>
  );
};

CqItemTitreDetails.propTypes = {};

export default CqItemTitreDetails;
