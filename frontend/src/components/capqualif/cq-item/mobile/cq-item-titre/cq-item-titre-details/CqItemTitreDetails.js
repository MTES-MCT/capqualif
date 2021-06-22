import React, { Fragment } from 'react';
import PropTypes from 'prop-types';

import commonStyles from './common.module.scss';
import styles from './CqItemTitreDetails.module.scss';
import CqItemCondition from './cq-item-condition/CqItemCondition';
import Validity from '../../../../validity/Validity';
import {
  DETAILS_TYPE,
  IDENTITY_MARKERS,
  MARIN_INFOS,
  REQUEST,
} from '../../../../../../dictionnary/demandeDeTitre';
import { convertDateToEuropeanFormat } from '../../../../../../app/utils';
import GenericError from '../../../../errors/GenericError';

const CqItemTitreDetails = ({ isVisible, titreId, details, action }) => {
  /**
   *  ================ UI ================
   */

  const chooseWhatToDisplay = (details) => {
    switch (details.type) {
      case DETAILS_TYPE.REQUEST:
        return displayRequests();
      case DETAILS_TYPE.CONDITIONS:
        return displayConditions();
      default:
        return <GenericError />;
    }
  };

  const displayRequests = () => {
    const { startDate } = details.content.startDate;
    const { instructionStatus } = details.content;
    return (
      <div className={`${isVisible ? '' : styles.hidden}`}>
        <p className="fr-px-2w fr-mt-2w">
          {`${REQUEST.DATES.START_DATE} : ${convertDateToEuropeanFormat(
            startDate
          )}
        `}
          <br />
          {instructionStatus}.
        </p>
      </div>
    );
  };

  const displayConditions = () => {
    const marinIdentityMarkers = details.content.marinIdentity.identityMarkers;
    const marinBasicsInfos = details.content.marinIdentity.basicInfos;
    return (
      <div className={`${isVisible ? '' : styles.hidden}`}>
        <div
          className={`${commonStyles.section} cq-helpers-bordered-section fr-p-2w fr-mt-3w fr-grid-row`}
        >
          <div>
            <h3>{MARIN_INFOS.IDENTITY}</h3>
            <h4>{MARIN_INFOS.NAME}</h4>
            <p className={`${styles.identity}`}>
              {marinBasicsInfos.firstName}&nbsp;
              {marinBasicsInfos.lastName}
            </p>
          </div>
          <h4>{MARIN_INFOS.ID_NUMBER}</h4>
          <p className={`${styles.identity}`}>
            {marinBasicsInfos.numeroDeMarin}
          </p>
          <div className="fr-mt-2w">
            <Validity
              titreId={titreId}
              document={{ id: 'photo', name: 'photo' }}
              isValid={marinIdentityMarkers.photoStatus}
              validLabel={IDENTITY_MARKERS.PHOTO}
              notValidLabel={IDENTITY_MARKERS.PHOTO}
            />
            <Validity
              titreId={titreId}
              document={{ id: 'signature', name: 'signature' }}
              isValid={marinIdentityMarkers.signatureStatus}
              validLabel={IDENTITY_MARKERS.SIGNATURE}
              notValidLabel={IDENTITY_MARKERS.SIGNATURE}
            />
          </div>
        </div>

        {details.content.results.allConditionsGroups.map((condition) => (
          <CqItemCondition titreId={titreId} condition={condition} />
        ))}

        {action && <div>{action}</div>}
      </div>
    );
  };

  return <Fragment>{chooseWhatToDisplay(details)}</Fragment>;
};

CqItemTitreDetails.propTypes = {
  isVisible: PropTypes.bool.isRequired,
  titreId: PropTypes.string.isRequired,
  details: PropTypes.object.isRequired,
  action: PropTypes.object,
};

export default CqItemTitreDetails;
