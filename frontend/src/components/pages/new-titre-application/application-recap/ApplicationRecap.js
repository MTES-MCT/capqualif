import React, { Fragment, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import './ApplicationRecap.scss';

import { FONT_COLORS } from '../../../../dictionnary/saas/variables';
import { ADD_PIECE_ROUTE, DASHBOARD_ROUTE } from '../../../../app/routesList';

import { getTitre } from '../../../../redux/features/titresCatalog/titresSlice';

import Breadcrumb from '../../../_cq/breadcrumb/Breadcrumb';
import SectionHead from '../../../_cq/section/section-head/SectionHead';
import CqItemBase from '../../../_cq/cq-item/elements/CqItemBase';

import SectionFooter from '../../../_cq/section/section-footer/SectionFooter';
import CqItemCatalog from '../../../_cq/cq-item/catalog/CqItemCatalog';
import CqItemOfMarin from '../../../_cq/cq-item/marin/CqItemOfMarin';
import { STATUS_APTITUDE_MEDICALE } from '../../../../dictionnary/demandeDeTitre';

const ApplicationRecap = ({ match }) => {
  const dispatch = useDispatch();
  const marin = useSelector((state) => state.marinsReducer.marinBasicData);

  const conditionsResultsMock = {
    aptitudeMedicale: {
      validity: true,
      marinData: {
        diagnosis: STATUS_APTITUDE_MEDICALE.APTE,
        dates: {
          debutApplicationDate: '03/09/2020',
          expirationDate: '02/09/2022',
        },
        medicalRestrictions: [],
      },
    },
    formations: [
      {
        validity: true,
        name: 'Formation de base à la sécurité',
        type: 'Formation spécifique',
        marinData: {
          modules: [
            {
              name: 'UV formation de base à la lutte incendie',
              dates: {
                acquisitionDate: '23/06/2020',
                expirationDate: '23/06/2025',
              },
            },
          ],
        },
      },
      {
        validity: false,
        name: 'Formation pour le certificat de matelot pont',
        type: 'Formation modulaire',
        modules: [
          {
            name: 'Module P1–Appui',
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
          {
            name: 'Module P2–Appui',
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
          {
            name: 'Module P3–Appui',
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
          {
            name: 'Module NP–Appui',
            dates: {
              acquisitionDate: '23/06/2020',
              expirationDate: '23/06/2025',
            },
          },
        ],
      },
    ],
  };

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
        </div>

        <div className="rf-grid-row rf-grid-row--gutters with-margin">
          <div className="rf-col">
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

        <div className="rf-grid-row rf-grid-row--gutters with-margin">
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
                />
              </div>
            </div>
          </div>
        </div>

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
                <div className="rf-pt-1w rf-pl-2w cq-helpers__full-width">
                  <CqItemOfMarin
                    name={formation.name}
                    subtitle={formation.type}
                  />
                </div>
              </div>
            ))}
          </div>
        </div>

        <div className="rf-grid-row rf-grid-row--gutters with-margin"></div>

        {/* <SectionFooter possibleActions={possibleActions} /> */}
      </div>
    </Fragment>
  );
};

export default ApplicationRecap;
