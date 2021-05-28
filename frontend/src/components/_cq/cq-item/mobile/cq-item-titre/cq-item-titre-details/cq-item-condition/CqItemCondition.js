import React from 'react';
import PropTypes from 'prop-types';

import commonStyles from '../common.module.scss';
import './CqItemCondition.module.scss';
import { Fragment } from 'react';

const CqItemCondition = ({ condition }) => {
  return (
    <div
      className={`${commonStyles.section} cq-helpers-bordered-section fr-p-2w`}
    >
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
