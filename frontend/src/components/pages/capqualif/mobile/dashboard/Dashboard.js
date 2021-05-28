import React from 'react';
import PropTypes from 'prop-types';

import styles from './Dashboard.module.scss';

import Button from '../../../../capqualif/button/Button';
import {
  ACTION_TYPES,
  BUTTON_LABELS,
} from '../../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../../dictionnary/saas/variables';
import { Fragment } from 'react';
import {
  MOBILE,
  NEW_TITRE_REQUEST_CHOICE_ROUTE,
} from '../../../../../app/routesDictionnary';

const Dashboard = (props) => {
  return (
    <Fragment>
      <div className={styles['cq-titres-container']}>
        <h2>Mes titres</h2>
        <p className={styles['cq-dashboard-no-titles']}>
          Vous n'avez aucun titre pour le moment.
        </p>
      </div>
      <div className={styles['cq-dashboard-action-container']}>
        <Button
          label={BUTTON_LABELS.DEMAND_ONE}
          route={`/${MOBILE}/${NEW_TITRE_REQUEST_CHOICE_ROUTE}`}
        />
      </div>
    </Fragment>
  );
};

Dashboard.propTypes = {};

export default Dashboard;
