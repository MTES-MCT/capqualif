import React, { Fragment } from 'react';
import PropTypes from 'prop-types';

import styles from './CqItemTitreDate.module.scss';

const CqItemTitreDate = ({ date }) => {
  return (
    <Fragment>
      <div className={styles.date}>
        <span class="fr-fi-arrow-right-line" aria-hidden="true"></span>&nbsp;
        {date}
      </div>
    </Fragment>
  );
};

CqItemTitreDate.propTypes = {
  date: PropTypes.string.isRequired,
};

export default CqItemTitreDate;
