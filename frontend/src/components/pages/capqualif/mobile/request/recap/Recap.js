import React, { Fragment } from 'react';
import PropTypes from 'prop-types';

import commonStyles from '../../../../../capqualif/cq-item/common.module.scss';
import styles from './Recap.module.scss';

import Step from '../../../../../capqualif/step/Step';
import {
  BUTTON_LABELS,
  RESTRICTIONS,
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

const Recap = (props) => {
  const titreMock = {
    titre: {
      capacite: 'Monovalence · Pont',
      name: 'Certificat de Matelot Pont',
      id: '1',
      slug: 'certificat-de-matelot-pont',
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

  return (
    <Fragment>
      <Step label={STEPS.CONFIRM} />
      <div className="fr-mt-2w fr-px-2w">
        <CqItemHeader
          subtitle={'Appui · Pont'}
          name={'Certificat de Matelot Pont'}
        />
        <p>{RESTRICTIONS.NO_RESTRICTION}</p>
        <div className={`${styles['spaced']} fr-grid-row fr-my-3w`}>
          <p>{VALIDITY.DURATION}</p>
          <CqItemFlagged label={'5 ans'} />
        </div>
        <div className={`${styles['spaced']} fr-grid-row fr-my-2w`}>
          <p>{VALIDITY.START_DATE}</p>
          <CqItemFlagged label={'18.06.2021'} />
        </div>
        <div className={`${styles['spaced']} fr-grid-row fr-my-2w`}>
          <p>{VALIDITY.END_DATE}</p>
          <CqItemFlagged label={'17.06.2021'} />
        </div>
        <p className="fr-mb-2w">
          Ces dates peuvent changer si la délivrance de votre titre n'est pas
          immédiate.
        </p>
        <CqItemTitre
          subtitle={VARIOUS.RECAPITULATIF}
          name={RESTRICTIONS.NO_RESTRICTION}
          status={titreMock.details.dossierStatus}
          details={titreMock.details}
          action={{
            label: BUTTON_LABELS.CONFIRM,
            labelSize: FONT_SIZES.SMALL,
            width: BUTTON_WIDTH.FULL,
            route: '',
          }}
        />
      </div>
    </Fragment>
  );
};

Recap.propTypes = {};

export default Recap;
