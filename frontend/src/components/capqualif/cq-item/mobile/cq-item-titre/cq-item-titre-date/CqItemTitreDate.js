import React, { Fragment } from 'react';
import PropTypes from 'prop-types';

const CqItemTitreDate = ({ date }) => {
  return (
    <Fragment>
      <div>{date}</div>
    </Fragment>
  );
};

CqItemTitreDate.propTypes = {};

export default CqItemTitreDate;
