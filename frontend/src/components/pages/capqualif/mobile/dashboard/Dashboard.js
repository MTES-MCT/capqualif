import React, { Fragment, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import {
  showHeader,
  hideHeader,
} from '../../../../../redux/capqualif/mobile/header/headerSlice';
import PropTypes from 'prop-types';

import styles from './Dashboard.module.scss';

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
} from '../../../../../app/routesDictionnary';
import { BUTTON_WIDTH } from '../../../../../dictionnary/saas/variables';
import ButtonLink from '../../../../capqualif/buttons/ButtonLink';
import CqItemTitre from '../../../../capqualif/cq-item/mobile/cq-item-titre/CqItemTitre';
import { TITRES } from '../../../../../dictionnary/titres';

const Dashboard = (props) => {
  const dispatch = useDispatch();
  const marinTitres = useSelector(
    (state) => state.marins.marinBasicData.allTitresOfMarin
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

  const displayAllRequests = (allRequests) => {
    if (allRequests.length > 0) {
      return (
        <Fragment>
          <h2>Mes demandes</h2>
          {allRequests.map((request) => (
            <CqItemTitre
              name={request.requestedTitre}
              status={{
                type: STATUS_TYPES.REQUEST,
                value: request.requestStatus,
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
                  value: titre.validityStatus,
                }}
                expirationDate={titre.dates.expirationDate}
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
        <ButtonLink
          label={BUTTON_LABELS.DEMAND_ONE}
          width={BUTTON_WIDTH.FULL}
          route={`/${MOBILE}/${NEW_TITRE_REQUEST_CHOICE_ROUTE}`}
        />
      </div>
    </Fragment>
  );
};

Dashboard.propTypes = {};

export default Dashboard;
