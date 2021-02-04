import React, { Fragment, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import './ApplicationRecap.scss';

import { G800, MARIANNE_BLUE } from '../../../../dictionnary/saas/colors';
import { ADD_PIECE_ROUTE, DASHBOARD_ROUTE } from '../../../../app/routesList';

import { getTitre } from '../../../../redux/features/titresCatalog/titresSlice';

import Breadcrumb from '../../../_cq/breadcrumb/Breadcrumb';
import SectionHead from '../../../_cq/section/section-head/SectionHead';
import SectionFooter from '../../../_cq/section/section-footer/SectionFooter';

const ApplicationRecap = ({ match }) => {
  const dispatch = useDispatch();
  const marin = useSelector((state) => state.marinsReducer.marinBasicData);
  // const currentTitre = useSelector((state) => state.titreReducer.currentTitre);

  useEffect(() => {
    dispatch(getTitre(match.params.itemSlug));
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

  const computeAge = () => {
    // https://stackoverflow.com/a/21984136
    const date = Date.parse(marin.dateNaissance);
    const age = Date.now() - date;
    const ageDate = new Date(age);
    return Math.abs(ageDate.getUTCFullYear() - 1970);
  };

  return (
    <Fragment>
      <Breadcrumb />
      <div id="application-recap" className="rf-container">
        <div className="rf-grid-row">
          <SectionHead
            title="Récapitulatif du dossier"
            subtitle="Demande d'un nouveau titre"
            color={MARIANNE_BLUE}
          />
        </div>
        <div className="rf-grid-row rf-grid-row--gutters with-margin">
          <div className="rf-col">
            <div className="container rf-grid-row">
              <span className="rf-fi-checkbox-line"></span>
              <div id="identity-container" className="rf-pl-2w">
                <p>Mon identité</p>
                <div id="identity-specifics-container" className="rf-mt-2w">
                  <div className="rf-mr-12w">
                    <p className="dynamic-infos">
                      {marin.prenom} {marin.nom}
                    </p>
                    <p>
                      Identification&nbsp;: {''}
                      <span className="dynamic-infos cq-helpers__display-inline">
                        {marin.numeroDeMarin}
                      </span>
                    </p>
                  </div>
                  <div>
                    <div className="identity-check">
                      <span className="rf-fi-check-line"></span>
                      <p className="rf-ml-1w dynamic-infos">
                        Ma photo d'identité est sauvegardée
                      </p>
                    </div>
                    <div className="identity-check">
                      <span className="rf-fi-check-line"></span>
                      <p className="rf-ml-1w dynamic-infos">
                        Ma signature est sauvgardée
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div className="rf-grid-row rf-grid-row--gutters with-margin">
          <div className="rf-col-3">
            <div className="container">
              <span className="rf-fi-checkbox-line"></span>
              <div className="rf-pt-1w rf-pl-2w">
                <p>
                  Mon âge&nbsp;: {''}
                  <span className="dynamic-infos cq-helpers__display-inline">
                    {computeAge()}
                  </span>
                </p>
              </div>
            </div>
          </div>
        </div>

        <SectionFooter possibleActions={possibleActions} />
      </div>
    </Fragment>
  );
};

export default ApplicationRecap;
