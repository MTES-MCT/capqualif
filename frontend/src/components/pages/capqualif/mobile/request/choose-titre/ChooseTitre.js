import React from 'react';
import PropTypes from 'prop-types';

import styles from './ChooseTitre.module.scss';

import {
  BUTTON_LABELS,
  STEPS,
  VARIOUS,
} from '../../../../../../dictionnary/demandeDeTitre';
import {
  BUTTON_WIDTH,
  FONT_SIZES,
} from '../../../../../../dictionnary/saas/variables';
import {
  MOBILE,
  NEW_TITRE_REQUEST_RECAP_ROUTE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../../app/routesDictionnary';
import CqItemTitre from '../../../../../capqualif/cq-item/mobile/cq-item-titre/CqItemTitre';
import Step from '../../../../../capqualif/step/Step';

const ChooseTitre = (props) => {
  const allTitresMock = [
    {
      titre: {
        capacite: 'Monovalence · Pont',
        name: 'Certificat de Matelot Pont',
        id: '1',
        slug: 'certificat-de-matelot-pont',
      },
      details: {
        dossierStatus: false,
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
    },
    {
      titre: {
        capacite: 'Sécurité',
        name: 'Certificat de Formation de Base à la Sécurité',
        id: '2',
        slug: 'certificat-de-formation-de-base-a-la-securite',
      },
      details: {
        dossierStatus: false,
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
                group: 'Aptitude médicale',
                conditions: [
                  {
                    name: 'Aptitude médicale',
                    isSatisfied: true,
                  },
                ],
              },
              {
                group: 'Qualifications spécifiques',
                conditions: [
                  {
                    name: 'Techniques individuelles de survie (UV- TIS-F) ',
                    isSatisfied: true,
                  },
                  {
                    name:
                      'Formation de base à la lutte contre l’incendie (UV-FBLI/F)',
                    isSatisfied: true,
                  },
                  {
                    name: 'Premiers secours élémentaires (PSC1)',
                    isSatisfied: true,
                  },
                  {
                    name: 'Prévention des risques à bord (UV-PRAB/F)',
                    isSatisfied: true,
                  },
                ],
              },
            ],
          },
        },
      },
    },
  ];

  return (
    <div>
      <Step label={STEPS.REQUEST_NEW} />
      <div className="fr-m-2w">
        <h3 className={styles['cq-choose-titre-h3']}>Choix du titre</h3>
        <div className={styles['cq-choose-titre-titres-container']}>
          {allTitresMock.map((titre) => (
            <CqItemTitre
              subtitle={titre.titre.capacite}
              name={titre.titre.name}
              status={titre.details.dossierStatus}
              details={titre.details}
              action={{
                label: BUTTON_LABELS.DEMAND_THIS,
                labelSize: FONT_SIZES.SMALL,
                width: BUTTON_WIDTH.FULL,
                route:
                  '/' +
                  MOBILE +
                  '/' +
                  NEW_TITRE_REQUEST_ROUTE +
                  '/' +
                  titre.titre.id +
                  '/' +
                  titre.titre.slug +
                  '/' +
                  NEW_TITRE_REQUEST_RECAP_ROUTE,
              }}
            />
          ))}
        </div>
        <p className={styles['cq-choose-titre-warning-text']}>
          {VARIOUS.CAPQUALIF_BETA_WARNING}
        </p>
      </div>
    </div>
  );
};

ChooseTitre.propTypes = {};

export default ChooseTitre;
