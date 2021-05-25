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
      capacite: 'Monovalence Pont',
      name: 'Certificat de matelot pont',
      id: '1',
      slug: 'certificat-de-matelot-pont',
      details: [],
    },
    {
      capacite: 'Sécurité',
      name: 'Certificat de formation de base à la sécurité',
      id: '2',
      slug: 'certificat-de-formation-de-base-a-la-securite',
      details: [],
    },
  ];

  return (
    <Fragment>
      <div>
        <h2 className={styles['cq-choose-titre-h2']}>
          Demander un nouveau titre
        </h2>
        x
      </div>
      <div>
        <h3>Choix du titre</h3>
        <div className={styles['cq-choose-titre-titres-container']}>
          {allTitresMock.map((titre) => (
            <CqItemTitre
              subtitle={titre.capacite}
              name={titre.name}
              status={'Dossier complet'}
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
                  titre.id +
                  '/' +
                  titre.slug +
                  '/' +
                  NEW_TITRE_REQUEST_RECAP_ROUTE,
                actionType: ACTION_TYPES.PRIMARY,
              }}
            />
          ))}
        </div>

        <p>CapQualif bêta ne propose que ces deux titres pour le moment.</p>
      </div>
    </Fragment>
  );
};

ChooseTitre.propTypes = {};

export default ChooseTitre;
