import React from 'react';
import PropTypes from 'prop-types';
import SectionFooter from '../../../_cq/section/section-footer/SectionFooter';

import './Confirmation.scss';

import {
  DASHBOARD_ROUTE,
  NEW_TITRE_APPLICATION_RECAP_ROUTE,
  NEW_TITRE_APPLICATION_ROUTE,
} from '../../../../app/routesList';
import CqItemCatalog from '../../../_cq/cq-item/catalog/CqItemCatalog';
import {
  ACTION_TYPES,
  BUTTON_LABELS,
} from '../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../dictionnary/saas/variables';

const Confirmation = (props) => {
  const possibleActions = [
    {
      label: 'Sauvegarder la demande',
      nextPageLink: DASHBOARD_ROUTE,
      disabled: false,
    },
    {
      label: 'Continuer',
      nextPageLink: DASHBOARD_ROUTE,
      disabled: false,
    },
  ];

  const currentTitreMock = [
    {
      capacite: 'Monovalence Pont',
      name: 'Certificat de matelot pont',
      id: '1',
      slug: 'certificat-de-matelot-pont',
      details: [
        {
          label: 'Fonctions',
          infos: ["Fonctions d'appui au pont"],
        },
        {
          label: 'Tâches spécialisées',
          infos: [
            'Navigation',
            'Manutention et arrimage de la cargaison',
            "Contrôle de l'exploitation du navire et assistance aux personnes à bord",
            'Entretien et réparation',
          ],
        },
        {
          label: 'Référence réglementaire',
          infos: 'Arrêté du 18 août 2015',
        },
        {
          label: 'Durée de validité',
          infos: '5 ans',
        },
      ],
    },
  ];

  return (
    <div id="confirmation">
      <h3>
        Félicitations ! Votre dossier est complet.
        <br />
        Souhaitez-vous confirmer la demande pour obtenir ce titre ?
      </h3>
      <div id="titre-container">
        {currentTitreMock
          .filter((titre) => titre.capacite !== '')
          .map((titre) => (
            <CqItemCatalog
              subtitle={titre.capacite}
              name={titre.name}
              details={titre.details}
            />
          ))}
      </div>
      <SectionFooter possibleActions={possibleActions} />
    </div>
  );
};

Confirmation.propTypes = {};

export default Confirmation;
