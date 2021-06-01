import React, { Fragment } from 'react';
import PropTypes from 'prop-types';

import commonStyles from './common.module.scss';
import styles from './CqItemTitreDetails.module.scss';
import CqItemCondition from './cq-item-condition/CqItemCondition';
import Validity from '../../../../validity/Validity';
import {
  DETAILS_TYPE,
  IDENTITY_MARKERS,
  INSTRUCTION_STATUS,
  MARIN_INFOS,
  REQUEST,
} from '../../../../../../dictionnary/demandeDeTitre';
import { convertToEuropeanFormat } from '../../../../../../app/utils';

const CqItemTitreDetails = ({ isVisible, details, action }) => {
  const chooseWhatToDisplay = (details) => {
    switch (details.type) {
      case DETAILS_TYPE.REQUEST:
        return (
          <div className={`${isVisible ? '' : styles.hidden}`}>
            <p className="fr-px-2w fr-mt-2w">
              {`${REQUEST.DATES.START_DATE} : ${convertToEuropeanFormat(
                details.content.requestDate
              )}
              `}
              <br />
              {details.content.instructionStatus}
            </p>
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
                  {details.content.marinIdentity.basicInfos.firstName}&nbsp;
                  {details.content.marinIdentity.basicInfos.lastName}
                </p>
              </div>
              <h4>{MARIN_INFOS.ID_NUMBER}</h4>
              <p className={`${styles.identity}`}>
                {details.content.marinIdentity.basicInfos.numeroDeMarin}
              </p>
              <div className="fr-mt-2w">
                <Validity
                  documentName={'photo'}
                  isValid={
                    details.content.marinIdentity.identityMarkers.isPhotoValid
                  }
                  validLabel={IDENTITY_MARKERS.PHOTO}
                  notValidLabel={IDENTITY_MARKERS.PHOTO}
                />
                <Validity
                  documentName={'signature'}
                  isValid={
                    details.content.marinIdentity.identityMarkers
                      .isSignatureValid
                  }
                  validLabel={IDENTITY_MARKERS.SIGNATURE}
                  notValidLabel={IDENTITY_MARKERS.SIGNATURE}
                />
              </div>
            </div>

            {details.content.results.details.conditions.map((condition) => (
              <CqItemCondition condition={condition} />
            ))}

            {action && <div>{action}</div>}
          </div>
        );
      default:
        return null;
    }
  };

  return <Fragment>{chooseWhatToDisplay(details)}</Fragment>;
};

CqItemTitreDetails.propTypes = {
  isVisible: PropTypes.bool.isRequired,
  details: PropTypes.object.isRequired,
  action: PropTypes.object,
};

export default CqItemTitreDetails;
