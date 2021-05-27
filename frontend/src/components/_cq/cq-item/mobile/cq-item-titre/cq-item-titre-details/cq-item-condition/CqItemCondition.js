import React from 'react';
import PropTypes from 'prop-types';

import './CqItemCondition.module.scss';
import { Fragment } from 'react';

const CqItemCondition = ({ condition }) => {
  return (
    <div className="fr-grid-row">
      <h3>{condition.group}</h3>
      {condition.conditions.map((cond) => (
        <Fragment>
          <div>{cond.name}</div>
          <div>{cond.isSatisfied ? 'valide' : 'à compléter'}</div>
        </Fragment>
      ))}
    </div>
  );
};

CqItemCondition.propTypes = {
  condition: PropTypes.object.isRequired,
};

export default CqItemCondition;
