import React, { useEffect } from 'react';
import { Link } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';

import './ApplicationRecap.scss';

import { ADD_PIECE_PATH, DASHBOARD_PATH } from '../../../../app/pathes';

import { getConditions } from '../../../../redux/features/conditions/conditionsSlice';

import SectionHead from '../../../_cq/section/section-head/SectionHead';
import SectionFooter from '../../../_cq/section/section-footer/SectionFooter';

const ApplicationRecap = () => {
  const dispatch = useDispatch();
  const currentTitle = useSelector((state) => state.titles.currentTitle);
  const marin = useSelector((state) => state.titles.currentTitle);

  useEffect(() => {
    dispatch(getConditions('1'));
  }, []);

  const possibleActions = [
    {
      label: 'Enregistrer le dossier',
      nextPageLink: DASHBOARD_PATH,
    },
    {
      label: 'Continuer',
      nextPageLink: DASHBOARD_PATH,
    },
  ];

  return (
    <div>
      <SectionHead title={currentTitle.libelle} subtitle="Récapitulatif" />
      <div>
        {/* Il manque CETTE PIECE <Link to={ADD_PIECE_PATH}>Ajouter</Link> */}
      </div>
      <SectionFooter possibleActions={possibleActions} />
    </div>
  );
};

export default ApplicationRecap;
