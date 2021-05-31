import React, { Fragment } from 'react';
import PropTypes from 'prop-types';

import commonStyles from '../../../../../capqualif/cq-item/common.module.scss';
import styles from './Recap.module.scss';

import Step from '../../../../../capqualif/step/Step';
import {
  BUTTON_LABELS,
  RESTRICTIONS,
  STATUS_TYPES,
  STEPS,
  VALIDITY,
  VARIOUS,
} from '../../../../../../dictionnary/demandeDeTitre';
import CqItemHeader from '../../../../../capqualif/cq-item/elements/cq-item-header/CqItemHeader';
import CqItemFlagged from '../../../../../capqualif/cq-item/elements/cq-item-flagged/CqItemFlagged';
import CqItemTitre from '../../../../../capqualif/cq-item/mobile/cq-item-titre/CqItemTitre';
import {
  BUTTON_WIDTH,
  FONT_SIZES,
} from '../../../../../../dictionnary/saas/variables';
import {
  CONFIRMATION_ROUTE,
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../../app/routesDictionnary';
import CqItemAction from '../../../../../capqualif/cq-item/elements/cq-item-action/CqItemAction';
import { convertToEuropeanFormat } from '../../../../capadmin/utils';

const Recap = (props) => {
  const titreMock = {
    titre: {
      id: '1',
      slug: 'certificat-de-matelot-pont',
      capacite: 'Monovalence · Pont',
      name: 'Certificat de Matelot Pont',
      validityDurationInYears: '5',
    },
    details: {
      dossierStatus: true,
      marinIdentity: {
        basicInfos: {
          firstName: 'Thomas',
          lastName: 'Laval',
          numeroDeMarin: '1234945',
        },
        identityMarkers: {
          isPhotoValid: false,
          isSignatureValid: true,
        },
      },
      results: {
        finalResult: false,
        details: {
          restrictions: [],
          conditions: [
            {
              group: 'Âge',
              conditions: [
                {
                  name: 'Âge',
                  isSatisfied: true,
                },
              ],
            },
            {
              group: 'Aptitude médicale',
              conditions: [
                {
                  name: 'Aptitude médicale',
                  isSatisfied: true,
                },
              ],
            },
            {
              group: 'Qualifications principales',
              conditions: [
                {
                  name: 'Module P1-Appui',
                  isSatisfied: true,
                },
                {
                  name: 'Module P2-Appui',
                  isSatisfied: true,
                },
                {
                  name: 'Module P3-Appui',
                  isSatisfied: false,
                },
                {
                  name: 'Module NP-Appui',
                  isSatisfied: true,
                },
              ],
            },
            {
              group: 'Qualifications spécifiques',
              conditions: [
                {
                  name: 'Certificat de Formation de Base à la Sécurité',
                  isSatisfied: true,
                },
              ],
            },
          ],
        },
      },
    },
  };

  const requestMock = {
    startDate: '2021-06-18',
  };

  const displayRestrictions = (restrictions) => {
    if (restrictions.length === 0) {
      return <p>{RESTRICTIONS.NO_RESTRICTION}</p>;
    }
    return (
      <p>
        Restrictions&nbsp;:{' '}
        {restrictions.map((restriction) => (
          <p>{restriction}</p>
        ))}
      </p>
    );
  };

  const computeEndDate = (startDate, duration) => {
    const start = new Date(startDate);
    const endDate = new Date(
      start.getFullYear() + parseInt(duration),
      start.getMonth(),
      start.getDate() - 1
    );
    return convertToEuropeanFormat(endDate);
  };

  return (
    <Fragment>
      <Step label={STEPS.CONFIRM} />
      <div className="fr-mt-2w fr-px-2w">
        <CqItemHeader
          subtitle={'Appui · Pont'}
          name={'Certificat de Matelot Pont'}
        />
        {displayRestrictions(titreMock.details.results.details.restrictions)}
        <div className={`${styles['spaced']} fr-grid-row fr-my-3w`}>
          <p>{VALIDITY.DURATION}</p>
          <CqItemFlagged
            label={`${titreMock.titre.validityDurationInYears} ans`}
          />
        </div>
        <div className={`${styles['spaced']} fr-grid-row fr-my-2w`}>
          <p>{VALIDITY.START_DATE}</p>
          <CqItemFlagged
            label={convertToEuropeanFormat(requestMock.startDate)}
          />
        </div>
        <div className={`${styles['spaced']} fr-grid-row fr-my-2w`}>
          <p>{VALIDITY.END_DATE}</p>
          <CqItemFlagged
            label={computeEndDate(
              requestMock.startDate,
              titreMock.titre.validityDurationInYears
            )}
          />
        </div>
        <p className="fr-mb-2w">{VARIOUS.DATES_WARNING}</p>
        <CqItemTitre
          subtitle={VARIOUS.RECAPITULATIF}
          name={displayRestrictions(
            titreMock.details.results.details.restrictions
          )}
          status={{
            type: STATUS_TYPES.DOSSIER,
            value: titreMock.details.dossierStatus,
          }}
          details={titreMock.details}
        />
        <CqItemAction
          action={{
            label: BUTTON_LABELS.CONFIRM,
            labelSize: FONT_SIZES.SMALL,
            width: BUTTON_WIDTH.FULL,
            route:
              '/' +
              MOBILE +
              '/' +
              NEW_TITRE_REQUEST_ROUTE +
              '/' +
              CONFIRMATION_ROUTE,
          }}
        />
      </div>
    </Fragment>
  );
};

Recap.propTypes = {};

export default Recap;
