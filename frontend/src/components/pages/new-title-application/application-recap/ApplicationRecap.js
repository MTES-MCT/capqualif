import React from 'react';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

import './ApplicationRecap.scss';

import { ADD_PIECE_PATH } from '../../../../app/pathes';

import SectionHead from '../../../elements/section/section-head/SectionHead';
import SectionFooter from '../../../elements/section/section-footer/SectionFooter';

const ApplicationRecap = () => {
  const currentTitle = useSelector((state) => state.titles.currentTitle);

  const possibleActions = [
    {
      label: 'Enregistrer le dossier',
      nextPageLink: '',
    },
    {
      label: 'Continuer',
      nextPageLink: '',
    },
  ];

  return (
    <div>
      <SectionHead
        title={currentTitle.titleName}
        subtitle="Demande d'un nouveau titre"
      />
      <div>
        Il manque CETTE PIECE <Link to={ADD_PIECE_PATH}>Ajouter</Link>
      </div>
      <SectionFooter possibleActions={possibleActions} />
    </div>
  );
};

export default ApplicationRecap;
