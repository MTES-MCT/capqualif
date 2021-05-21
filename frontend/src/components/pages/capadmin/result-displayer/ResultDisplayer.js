import React from 'react';
import PropTypes from 'prop-types';

const ResultDisplayer = (result) => {
  return <div>{JSON.stringify(result)}</div>;
};

ResultDisplayer.propTypes = {
  result: PropTypes.object.isRequired,
};

export default ResultDisplayer;
