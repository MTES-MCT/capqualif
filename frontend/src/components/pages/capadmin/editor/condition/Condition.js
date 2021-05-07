import React, { Fragment, useState, useEffect } from 'react';
import PropTypes from 'prop-types';

const Condition = ({ shouldISendCondition, sendConditionToParent }) => {
  const condition = {
    name: '',
    operator: '',
    leftOpId: '',
    rightOp: '',
    subConditions: [],
  };

  const [conditionData, setConditionData] = useState(condition);

  useEffect(() => {
    if (shouldISendCondition) {
      sendConditionToParent(conditionData);
    }
  }, [shouldISendCondition]);

  const handleChange = (e) => {
    setConditionData({ ...conditionData, [e.target.name]: e.target.value });
  };

  return (
    <Fragment>
      <label>
        Intitulé de la condition :
        <input
          value={conditionData.name || ''}
          aria-label="condition-name-input"
          name="name"
          onChange={(e) => handleChange(e)}
        />
      </label>
      <label>
        Operateur :
        <input
          value={conditionData.operator || ''}
          aria-label="condition-operator-input"
          name="operator"
          onChange={(e) => handleChange(e)}
        />
      </label>
      <label>
        Left Op Id :
        <input
          value={conditionData.leftOpId || ''}
          aria-label="condition-name-input"
          name="leftOpId"
          onChange={(e) => handleChange(e)}
        />
      </label>
      <label>
        Right Op :
        <input
          value={conditionData.rightOp || ''}
          aria-label="condition-name-input"
          name="rightOp"
          onChange={(e) => handleChange(e)}
        />
      </label>
    </Fragment>
  );
};

Condition.propTypes = {};

export default Condition;
