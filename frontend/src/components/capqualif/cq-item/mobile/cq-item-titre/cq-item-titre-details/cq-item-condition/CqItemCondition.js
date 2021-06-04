import React from 'react';
import PropTypes from 'prop-types';

import commonStyles from '../common.module.scss';
import './CqItemCondition.module.scss';
import Validity from '../../../../../validity/Validity';

const CqItemCondition = ({ condition }) => {
  return (
    <div
      className={`${commonStyles.section} cq-helpers-bordered-section fr-p-2w`}
    >
      <h3>{condition.group}</h3>
      {condition.conditions.map((cond) => (
        <Validity
          documentName={cond.name}
          isValid={cond.isSatisfied}
          validLabel={`${cond.name}`}
          notValidLabel={`${cond.name}`}
        />
      ))}
    </div>
  );
};

CqItemCondition.propTypes = {
  condition: PropTypes.object.isRequired,
};

export default CqItemCondition;