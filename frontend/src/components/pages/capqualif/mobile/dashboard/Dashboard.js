import React, { Fragment } from 'react';
import { useSelector } from 'react-redux';
import PropTypes from 'prop-types';

import styles from './Dashboard.module.scss';

import {
  DASHBOARD_INFOS,
  BUTTON_LABELS,
  STATUS_TYPES,
  REQUEST,
  INSTRUCTION_STATUS,
} from '../../../../../dictionnary/demandeDeTitre';
import {
  MOBILE,
  NEW_TITRE_REQUEST_CHOICE_ROUTE,
} from '../../../../../app/routesDictionnary';
import { BUTTON_WIDTH } from '../../../../../dictionnary/saas/variables';
import Button from '../../../../capqualif/button/Button';
import CqItemTitre from '../../../../capqualif/cq-item/mobile/cq-item-titre/CqItemTitre';
import { TITRES } from '../../../../../dictionnary/titres';

const Dashboard = (props) => {
  const allTitresOfMarin = useSelector(
    (state) => state.marinsReducer.marinBasicData.allTitresOfMarin
  );

  const allRequestsOfMarinMock = [
    {
      requestedTitre: {
        name: TITRES.CERTIFICATS.MATELOT_PONT,
      },
      requestStatus: REQUEST.STATUS_REQUEST.SENT.SHORT,
      instructionStatus: INSTRUCTION_STATUS.IN_PROGRESS,
      requestDate: '18.06.2020',
    },
  ];

  const displayAllTitresOfMarin = (allTitresOfMarin) => {
    if (allTitresOfMarin.length > 0) {
      return allTitresOfMarin
        .filter(
          (titre) =>
            titre.name === TITRES.CERTIFICATS.MATELOT_PONT ||
            titre.name === TITRES.CERTIFICATS.CFBS
        )
        .map((titre) => (
          <CqItemTitre
            name={titre.name}
            status={{
              type: STATUS_TYPES.TITRE_VALIDITY,
              value: titre.validityStatus,
            }}
            expirationDate={titre.dates.expirationDate}
          />
        ));
    }
    return (
      <p className={styles['cq-dashboard-no-titles']}>
        {DASHBOARD_INFOS.NO_TITLES}
      </p>
    );
  };

  const displayAllRequestsOfMarin = (allRequestsOfMarinMock) => {
    if (allRequestsOfMarinMock.length > 0) {
      return allRequestsOfMarinMock.map((request) => (
        <CqItemTitre
          name={request.requestedTitre.name}
          status={{
            type: STATUS_TYPES.REQUEST,
            value: request.status,
          }}
          // details={request.instructionStatus}
        />
      ));
    }
  };

  return (
    <Fragment>
      <div className={styles['cq-titres-container']}>
        <h2>Mes titres</h2>
        {displayAllRequestsOfMarin(allRequestsOfMarinMock)}
        {displayAllTitresOfMarin(allTitresOfMarin)}
      </div>
      <div className={`${styles['cq-dashboard-action-container']} fr-px-1w`}>
        <Button
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
