import React from 'react';
import PropTypes from 'prop-types';

import styles from './Dashboard.module.scss';

import Button from '../../../../_cq/button/Button';
import {
  ACTION_TYPES,
  BUTTON_LABELS,
} from '../../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../../dictionnary/saas/variables';

const Dashboard = (props) => {
  return (
    <div className={styles['cq-container']}>
      <h2>Mes titres</h2>
      <p className={styles['cq-no-titles']}>
        Vous n'avez aucun titre pour le moment.
      </p>
      <Button label={BUTTON_LABELS.DEMAND} />
    </div>
  );
};

Dashboard.propTypes = {};

export default Dashboard;
