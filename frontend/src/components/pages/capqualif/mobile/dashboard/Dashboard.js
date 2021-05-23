import React from 'react';
import PropTypes from 'prop-types';

import styles from './Dashboard.module.scss';
const Dashboard = (props) => {
  return (
    <div className={styles['cq-container']}>
      <h2>Mes titres</h2>
      <p className={styles['cq-no-titles']}>
        Vous n'avez aucun titre pour le moment.
      </p>
    </div>
  );
};

Dashboard.propTypes = {};

export default Dashboard;
