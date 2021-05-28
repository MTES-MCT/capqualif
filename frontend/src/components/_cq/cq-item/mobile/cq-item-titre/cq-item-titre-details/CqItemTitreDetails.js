import React from 'react';
import { GrAdd } from 'react-icons/gr';
import PropTypes from 'prop-types';

import commonStyles from './common.module.scss';
import styles from './CqItemTitreDetails.module.scss';
import CqItemCondition from './cq-item-condition/CqItemCondition';
import { Fragment } from 'react';

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
        {details.marinIdentity.identityMarkers.isPhotoValid ? (
          <p>
            <span
              className="cq-helpers-success fr-fi-check-line"
              aria-hidden="true"
            ></span>
            Photo d'identité valide
          </p>
        ) : (
          <Fragment>
            <p>
              <span
                className={`${commonStyles['icon']} cq-helpers-failure fr-fi-close-line`}
                aria-hidden="true"
              ></span>
              Photo d'identité non valide
              <span className={`${commonStyles['add-icon']} fr-ml-1w fr-p-1w`}>
                <GrAdd />
              </span>
            </p>
          </Fragment>
        )}
        <p>{details.marinIdentity.identityMarkers.isSignatureValid}</p>
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
