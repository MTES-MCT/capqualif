import React, { Fragment, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import './ApplicationRecap.scss';

import {
  FONT_COLORS,
  FONT_SIZES,
} from '../../../../dictionnary/saas/variables';
import { ADD_PIECE_ROUTE, DASHBOARD_ROUTE } from '../../../../app/routesList';

import { getTitre } from '../../../../redux/features/titresCatalog/titresSlice';

import Breadcrumb from '../../../_cq/breadcrumb/Breadcrumb';
import SectionHead from '../../../_cq/section/section-head/SectionHead';

import SectionFooter from '../../../_cq/section/section-footer/SectionFooter';
import CqItemOfMarin from '../../../_cq/cq-item/marin/CqItemOfMarin';
import {
  ACTION_TYPES,
  BUTTON_LABELS,
  STATUS_APTITUDE_MEDICALE,
  STATUS_TITRE,
} from '../../../../dictionnary/demandeDeTitre';
import Button from '../../../_cq/button/Button';

const ApplicationRecap = ({ match }) => {
  const dispatch = useDispatch();
  const marin = useSelector((state) => state.marinsReducer.marinBasicData);

  const conditionsResultsMock = [
    {
      conditionJuridicalName: 'Âge',
      validity: true,
      relatedMarinData: {
        birthDate: marin.dateNaissance,
      },
    },
    {
      conditionJuridicalName: 'Aptitude médicale',
      validity: true,
      relatedMarinData: {
        diagnosis: STATUS_APTITUDE_MEDICALE.APTE,
        dates: {
          debutApplicationDate: '03/09/2020',
          expirationDate: '02/09/2022',
        },
        medicalRestrictions: [],
      },
    },
    {
      conditionJuridicalName: 'Formation de base à la sécurité',
      validity: true,
      relatedMarinData: {
        modules: [
          {
            name: 'Module',
            description: 'Formation de base à la lutte incendie',
            validity: true,
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
          {
            name: 'Module',
            description: 'Sécurité des Personnes et Responsabilités Sociales',
            validity: true,
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
          {
            name: 'Module',
            description: 'Technique Individuelle de Survie',
            validity: true,
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
          {
            name: 'Module',
            description: 'Médical1',
            validity: true,
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
        ],
      },
    },
    {
      conditionJuridicalName: 'Formation pour le certificat de matelot pont',
      validity: true,
      relatedMarinData: {
        modules: [
          {
            name: 'Module P1–Appui',
            description: 'Navigation',
            validity: true,
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
          {
            name: 'Module P2–Appui',
            description: 'Manutention et arrimage de la cargaison, pêche',
            validity: true,
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
          {
            name: '! Module P3–Appui',
            description: 'Exploitation, assistance, entretien, réparation',
            validity: false,
            dates: null,
          },
          {
            name: 'Module NP–Appui',
            description: 'Module national pont',
            validity: true,
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
        ],
      },
    },
  ];

  useEffect(() => {
    dispatch(getTitre(match.params.itemSlug));
  }, []);

  const possibleActions = [
    {
      label: 'Sauvegarder la demande',
      nextPageLink: DASHBOARD_ROUTE,
      disabled: false,
    },
    {
      label: 'Continuer',
      nextPageLink: DASHBOARD_ROUTE,
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
      {/* <div
        id="application-recap"
        className="cq-helpers__with-footer rf-container"
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
                        Ma signature est sauvegardée
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div> */}

      {/* Famille de conditions 1 */}
      {/* <div className="rf-grid-row rf-grid-row--gutters with-margin">
          <div className="rf-col">
            <div className="container">
              <span
                className={`
                ${
                  conditionsResultsMock.age.validity
                    ? 'rf-fi-checkbox-line'
                    : 'rf-fi-close-circle-line'
                }`}
              ></span>
              <div className="rf-pt-1w rf-pl-2w">
                <p>
                  Mon âge&nbsp;: {''}
                  <span className="dynamic-infos cq-helpers__display-inline">
                    {computeAge(conditionsResultsMock.age.marinData.birthDate)}
                  </span>
                </p>
              </div>
            </div>
          </div>
        </div> */}

      {/* Famille de conditions 2 */}
      {/* <div className="rf-grid-row rf-grid-row--gutters with-margin">
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
              <div className="rf-pt-1w rf-pl-2w cq-helpers__full-width">
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
        </div> */}

      {/* Famille de conditions 3 */}
      {/* <div className="rf-grid-row rf-grid-row--gutters with-margin">
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
                <div className="rf-pt-1w rf-pl-2w cq-helpers__full-width">
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
        </div>

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
      </div> */}
    </Fragment>
  );
};

export default ApplicationRecap;
