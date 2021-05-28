import React from 'react';
import { GrAdd } from 'react-icons/gr';
import PropTypes from 'prop-types';

import commonStyles from './common.module.scss';
import styles from './CqItemTitreDetails.module.scss';
import CqItemCondition from './cq-item-condition/CqItemCondition';
import { Fragment } from 'react';
import Validity from '../../../../validity/Validity';

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
        <Validity
          isValid={details.marinIdentity.identityMarkers.isPhotoValid}
          validLabel={"Photo d'identité valide"}
          notValidLabel={"Photo d'identité non valide"}
        />
        <Validity
          isValid={details.marinIdentity.identityMarkers.isSignatureValid}
          validLabel={'Signature valide'}
          notValidLabel={'Signature non valide'}
        />
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
