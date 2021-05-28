import React, { Fragment, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import './ApplicationRecap.scss';

import {
  FONT_COLORS,
  FONT_SIZES,
} from '../../../../../../dictionnary/saas/variables';
import {
  DASHBOARD_ROUTE,
  DESKTOP,
} from '../../../../../../app/routesDictionnary';

import Breadcrumb from '../../../../../capqualif/breadcrumb/Breadcrumb';
import SectionHead from '../../../../../capqualif/section/section-head/SectionHead';

import SectionFooter from '../../../../../capqualif/section/section-footer/SectionFooter';
import CqItemOfMarin from '../../../../../capqualif/cq-item/marin/CqItemOfMarin';
import {
  ACTION_TYPES,
  BUTTON_LABELS,
} from '../../../../../../dictionnary/demandeDeTitre';
import Button from '../../../../../capqualif/button/Button';

import { getConditions } from '../../../../../../redux/capqualif/desktop/features/conditions/conditionsSlice';

const ApplicationRecap = () => {
  const dispatch = useDispatch();
  const marin = useSelector((state) => state.marinsReducer.marinBasicData);
  const conditions = useSelector((state) => state.conditionsReducer.conditions);

  useEffect(() => {
    dispatch(
      getConditions({
        titreId: '1',
        numeroDeMarin: '123',
      })
    );
  }, []);

  const possibleActions = [
    {
      label: 'Sauvegarder la demande',
      nextPageLink: `/${DESKTOP}/${DASHBOARD_ROUTE}`,
      disabled: false,
    },
    {
      label: 'Continuer',
      nextPageLink: `/${DESKTOP}/${DASHBOARD_ROUTE}`,
      disabled: true,
    },
  ];

  const computeAge = (birthDate) => {
    // https://stackoverflow.com/a/21984136
    const date = Date.parse(birthDate);
    const age = Date.now() - date;
    const ageDate = new Date(age);
    return Math.abs(ageDate.getUTCFullYear() - 1970);
  };

  return (
    <Fragment>
      <Breadcrumb />
      <div
        id="application-recap"
        className="cq-helpers-with-footer rf-container"
      >
        <div className="rf-grid-row">
          <SectionHead
            title="Récapitulatif du dossier"
            subtitle="Demande d'un nouveau titre"
            color={FONT_COLORS.MARIANNE_BLUE}
          />
        </div>
        <div className="rf-grid-row rf-grid-row--gutters with-margin">
          <div className="rf-col">
            <div className="not-center-aligning-container rf-grid-row">
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
                      <span className="dynamic-infos cq-helpers-display-inline">
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
                        Ma signature est sauvegardée
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        {conditions.map((condition) => renderCondition(condition))}

        {/* 

        < className="rf-grid-row rf-grid-row--gutters with-margin">
          <div className="rf-col">
            <div className="container">
              <span
                className={`
                ${
                  conditionsResultsMock.aptitudeMedicale.validity
                    ? 'rf-fi-checkbox-line'
                    : 'rf-fi-close-circle-line'
                }`}
              ></span>
              <div className="rf-pt-1w rf-pl-2w cq-helpers-full-width">
                <p>Mes aptitudes médicales</p>
                <CqItemOfMarin
                  name="Visite annuelle"
                  subtitle="Aptitude médicale"
                  dates={conditionsResultsMock.aptitudeMedicale.marinData.dates}
                  status={STATUS_APTITUDE_MEDICALE.APTE}
                  action={
                    !conditionsResultsMock.aptitudeMedicale.validity && {
                      label: BUTTON_LABELS.ADD_DOCUMENT,
                      labelSize: FONT_SIZES.VERY_SMALL,
                      route: '',
                      actionType: ACTION_TYPES.SECONDARY,
                    }
                  }
                />
              </div>
            </div>
          </div>
        </>

        <div className="rf-grid-row rf-grid-row--gutters with-margin">
          <div className="rf-col">
            <p>Mes formations</p>
            {conditionsResultsMock.formations.map((formation) => (
              <div className="container">
                <span
                  className={`
                ${
                  formation.validity
                    ? 'rf-fi-checkbox-line'
                    : 'rf-fi-close-circle-line'
                }`}
                ></span>
                <div className="rf-pt-1w rf-pl-2w cq-helpers-full-width">
                  <CqItemOfMarin
                    name={formation.name}
                    subtitle={formation.type}
                    status={formation.validity && STATUS_TITRE.VALID}
                    existingTitreAction={
                      !formation.validity && {
                        label: BUTTON_LABELS.ADD_DOCUMENT,
                        labelSize: FONT_SIZES.VERY_SMALL,
                        route: ADD_PIECE_ROUTE,
                        actionType: ACTION_TYPES.SECONDARY,
                      }
                    }
                    details={formation.marinData.modules.map((module) => ({
                      label: module.name,
                      labelStatus: 'validity-' + module.validity,
                      infos: module.description,
                    }))}
                  />
                </div>
              </div>
            ))}
          </div>
        </div> */}
        <div
          id="ask-for-advice-button-container"
          className="rf-grid-row rf-grid-row--gutters with-margin"
        >
          <Button
            label={BUTTON_LABELS.ASK_FOR_ADVICE}
            labelSize={FONT_SIZES.SMALL}
            route=""
            actionType={ACTION_TYPES.SECONDARY}
          />
        </div>
        <SectionFooter possibleActions={possibleActions} />
      </div>
    </Fragment>
  );
};

export default ApplicationRecap;

const renderCondition = (condition) => {
  const result = condition.conditionMet;
  const conditionName =
    condition.comparisonResultForMainCriterion.conditionJuridicalDesignation;
  const conditionNameLowercased = condition.comparisonResultForMainCriterion.conditionJuridicalDesignation.toLowerCase();
  if (conditionNameLowercased.includes('âge')) {
    return renderBasicCondition(conditionName, result);
  }
  if (
    conditionNameLowercased.includes('aptitude médicale') ||
    conditionNameLowercased.includes('formation') ||
    conditionNameLowercased.includes('certificat')
  ) {
    return renderComplexCondition(conditionName, result);
  }
};

const renderBasicCondition = (conditionName, result) => {
  return (
    <div className="rf-grid-row rf-grid-row--gutters with-margin">
      <div className="rf-col">
        <div className="container">
          <span
            className={`
              ${result ? 'rf-fi-checkbox-line' : 'rf-fi-close-circle-line'}`}
          ></span>
          <div className="rf-pt-1w rf-pl-2w">
            <p>
              {conditionName}
              <span className="dynamic-infos cq-helpers-display-inline">
                {''} ma donnée
              </span>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

const renderComplexCondition = (conditionName, result) => {
  return (
    <div className="rf-grid-row rf-grid-row--gutters with-margin">
      <div className="rf-col">
        <div className="container">
          <span
            className={`
        ${result ? 'rf-fi-checkbox-line' : 'rf-fi-close-circle-line'}`}
          ></span>
          <div className="rf-pt-1w rf-pl-2w cq-helpers-full-width">
            <p>Nom de la famille de condition</p>
            <CqItemOfMarin
              name={''}
              subtitle={conditionName}
              dates={''}
              status={''}
              action={
                !result && {
                  label: BUTTON_LABELS.ADD_DOCUMENT,
                  labelSize: FONT_SIZES.VERY_SMALL,
                  route: '',
                  actionType: ACTION_TYPES.SECONDARY,
                }
              }
            />
          </div>
        </div>
      </div>
    </div>
  );
};
