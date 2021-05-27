import React from 'react';
import PropTypes from 'prop-types';
import { Fragment } from 'react';

import styles from './ChooseTitre.module.scss';

import CqItemCatalog from '../../../../../_cq/cq-item/catalog/CqItemCatalog';
import {
  ACTION_TYPES,
  BUTTON_LABELS,
} from '../../../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../../../dictionnary/saas/variables';
import {
  DESKTOP,
  MOBILE,
  NEW_TITRE_REQUEST_RECAP_ROUTE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../../app/routesDictionnary';
import CqItemTitre from '../../../../../_cq/cq-item/mobile/cq-item-titre/CqItemTitre';

const ChooseTitre = (props) => {
  const allTitresMock = [
    {
      titre: {
        capacite: 'Monovalence · Pont',
        name: 'Certificat de matelot pont',
        id: '1',
        slug: 'certificat-de-matelot-pont',
      },
      details: {
        marinIdentity: {
          basicInfos: {
            firstName: 'Thomas',
            lastName: 'Laval',
            numeroDeMarin: '1234945',
          },
          identityMarkers: {
            isPhotoValid: true,
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
    // {
    //   capacite: 'Sécurité',
    //   name: 'Certificat de formation de base à la sécurité',
    //   id: '2',
    //   slug: 'certificat-de-formation-de-base-a-la-securite',
    //   details: [],
    //   status: 'Dossier complet',
    // },
  ];

  return (
    <Fragment>
      <div className={styles['cq-choose-titre-h2-container']}>
        <h2 className={`${styles['cq-choose-titre-h2']} fr-m-2w`}>
          Demander un nouveau titre
        </h2>
        <span class="fr-fi-close-line" aria-hidden="true"></span>
      </div>
      <div className="fr-m-2w">
        <h3 className={styles['cq-choose-titre-h3']}>Choix du titre</h3>
        <div className={styles['cq-choose-titre-titres-container']}>
          {allTitresMock.map((titre) => (
            <CqItemTitre
              subtitle={titre.titre.capacite}
              name={titre.titre.name}
              status={titre.details.results.finalResult}
              details={titre.details}
              action={{
                label: BUTTON_LABELS.DEMAND_THIS,
                labelSize: FONT_SIZES.SMALL,
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
                actionType: ACTION_TYPES.PRIMARY,
              }}
            />
          ))}
        </div>

        <p className={styles['cq-choose-titre-warning-text']}>
          CapQualif bêta ne propose que ces deux titres pour le moment.
        </p>
      </div>
    </Fragment>
  );
};

ChooseTitre.propTypes = {};

export default ChooseTitre;
