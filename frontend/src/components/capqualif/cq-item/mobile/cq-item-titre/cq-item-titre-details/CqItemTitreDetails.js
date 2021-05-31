import React from 'react';
import { GrAdd } from 'react-icons/gr';
import PropTypes from 'prop-types';

import commonStyles from './common.module.scss';
import styles from './CqItemTitreDetails.module.scss';
import CqItemCondition from './cq-item-condition/CqItemCondition';
import { Fragment } from 'react';
import Validity from '../../../../validity/Validity';
import {
  DETAILS_TYPE,
  IDENTITY_MARKERS,
  MARIN_INFOS,
  REQUEST,
} from '../../../../../../dictionnary/demandeDeTitre';

const CqItemTitreDetails = ({ isVisible, details, action }) => {
  const chooseWhatToDisplay = (type) => {
    switch (type) {
      case DETAILS_TYPE.REQUEST:
        return (
          <div className={`${isVisible ? '' : styles.hidden}`}>
            {REQUEST.DATES.START_DATE}+ +{details.requestDate}
          </div>
        );
      case DETAILS_TYPE.CONDITIONS:
        return (
          <div className={`${isVisible ? '' : styles.hidden}`}>
            <div
              className={`${commonStyles.section} cq-helpers-bordered-section fr-p-2w fr-mt-3w fr-grid-row`}
            >
              <div>
                <h3>{MARIN_INFOS.IDENTITY}</h3>
                <h4>{MARIN_INFOS.NAME}</h4>
                <p className={`${styles.identity}`}>
                  {details.marinIdentity.basicInfos.firstName}&nbsp;
                  {details.marinIdentity.basicInfos.lastName}
                </p>
              </div>
              <h4>{MARIN_INFOS.ID_NUMBER}</h4>
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
                  isValid={
                    details.marinIdentity.identityMarkers.isSignatureValid
                  }
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
      default:
        return null;
    }
  };

  return;
};

CqItemTitreDetails.propTypes = {};

export default CqItemTitreDetails;
