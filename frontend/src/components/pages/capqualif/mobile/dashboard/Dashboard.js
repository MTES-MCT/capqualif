import React, { Fragment, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { useHistory } from 'react-router-dom';
import PropTypes from 'prop-types';

import styles from './Dashboard.module.scss';

import {
  showHeader,
  hideHeader,
} from '../../../../../redux/capqualif/mobile/header/headerSlice';
import {
  DASHBOARD_INFOS,
  BUTTON_LABELS,
  STATUS_TYPES,
  INSTRUCTION_STATUS,
  DETAILS_TYPE,
  REQUEST,
} from '../../../../../dictionnary/demandeDeTitre';
import {
  MOBILE,
  NEW_TITRE_REQUEST_CHOICE_ROUTE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../app/routesDictionnary';
import { BUTTON_WIDTH } from '../../../../../dictionnary/saas/variables';
import CqItemTitre from '../../../../capqualif/cq-item/mobile/cq-item-titre/CqItemTitre';
import { TITRES } from '../../../../../dictionnary/titres';
import ButtonAction from '../../../../capqualif/buttons/button-action/ButtonAction';
import {
  cleanRequests,
  createRequest,
} from '../../../../../redux/capqualif/mobile/requests/requestsSlice';

const Dashboard = (props) => {
  /**
   * Boilerplate
   */
  const dispatch = useDispatch();
  const history = useHistory();

  /**
   * Let's select data from global state (redux)
   */
  const marin = useSelector((state) => state.marins.marinBasicData);
  const marinTitres = marin.allTitresOfMarin;

  const requestableTitres = useSelector(
    (state) => state.instructions.possibleTitres
  );

  useEffect(() => {
    dispatch(showHeader());
    return function cleanUp() {
      dispatch(hideHeader());
    };
  }, []);

  const allRequestsMock = [
    {
      requestor: {
        firstName: 'Mile',
        lastName: 'End',
      },
      requestedTitre: TITRES.CERTIFICATS.MATELOT_PONT,
      startDate: '2020/06/18',
      requestStatus: REQUEST.STATUS_REQUEST.SENT.SHORT,
      instructionStatus: INSTRUCTION_STATUS.IN_PROGRESS,
      documents: [],
    },
  ];

  /**
   * Actions on click event
   */
  const startRequest = (marin, requestableTitres) => {
    dispatch(cleanRequests());
    requestableTitres.forEach((titre) => {
      dispatch(
        createRequest({
          requestor: {
            numeroDeMarin: marin.numeroDeMarin,
            firstName: marin.prenom,
            lastName: marin.nom,
          },
          titreId: titre.informations.id,
        })
      );
    });
    history.push(
      `/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${NEW_TITRE_REQUEST_CHOICE_ROUTE}`
    );
  };

  /**
   *  ================ UI ================
   */
  const displayAllRequests = (allRequests) => {
    if (allRequests.length > 0) {
      return (
        <Fragment>
          <h2>Mes demandes</h2>
          {allRequests.map((request) => (
            <CqItemTitre
              id={'1'}
              name={request?.requestedTitre}
              status={{
                type: STATUS_TYPES.REQUEST,
                value: request?.requestStatus,
              }}
              details={{
                type: DETAILS_TYPE.REQUEST,
                content: request,
              }}
            />
          ))}
        </Fragment>
      );
    }
  };

  const displayAllMarinTitres = (marinTitres) => {
    if (marinTitres.length > 0) {
      return (
        <Fragment>
          <h2>Mes titres</h2>
          {marinTitres
            .filter(
              (titre) =>
                titre.name === TITRES.CERTIFICATS.MATELOT_PONT ||
                titre.name === TITRES.CERTIFICATS.CFBS
            )
            .map((titre) => (
              <CqItemTitre
                id={titre.id}
                name={titre.name}
                status={{
                  type: STATUS_TYPES.TITRE_VALIDITY,
                  value: titre?.validityStatus,
                }}
                expirationDate={titre?.dates?.expirationDate}
              />
            ))}
        </Fragment>
      );
    }
    return (
      <p className={styles['cq-dashboard-no-titles']}>
        {DASHBOARD_INFOS.NO_TITLES}
      </p>
    );
  };

  return (
    <Fragment>
      <div className="fr-m-2w">
        {displayAllRequests(allRequestsMock)}
        {displayAllMarinTitres(marinTitres)}
      </div>
      <div
        className={`${styles['cq-dashboard-action-container']} fr-mt-2w fr-pt-1w fr-px-1w`}
      >
        <ButtonAction
          label={BUTTON_LABELS.DEMAND_ONE}
          width={BUTTON_WIDTH.FULL}
          actionOnClick={() => startRequest(marin, requestableTitres)}
        />
      </div>
    </Fragment>
  );
};

Dashboard.propTypes = {};

export default Dashboard;
