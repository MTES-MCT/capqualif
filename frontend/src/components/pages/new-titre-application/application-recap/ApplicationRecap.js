import React, { useEffect } from 'react';
import { Link } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';

import './ApplicationRecap.scss';

import { ADD_PIECE_ROUTE, DASHBOARD_ROUTE } from '../../../../app/routesList';

import { getConditions } from '../../../../redux/features/conditions/conditionsSlice';

import SectionHead from '../../../_cq/section/section-head/SectionHead';
import SectionFooter from '../../../_cq/section/section-footer/SectionFooter';

const ApplicationRecap = () => {
  const dispatch = useDispatch();
  const currentTitle = useSelector((state) => state.titlesReducer.currentTitle);
  const marin = useSelector((state) => state.marinsReducer.marinBasicData);

  useEffect(() => {
    dispatch(getConditions('1'));
  }, []);

  const possibleActions = [
    {
      label: 'Enregistrer le dossier',
      nextPageLink: DASHBOARD_ROUTE,
    },
    {
      label: 'Continuer',
      nextPageLink: DASHBOARD_ROUTE,
    },
  ];

  return (
    <div>
      <SectionHead title={currentTitle.libelle} subtitle="Récapitulatif" />

      <SectionFooter possibleActions={possibleActions} />
    </div>
  );
};

export default ApplicationRecap;
