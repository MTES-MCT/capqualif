import React, { useState, useEffect } from 'react';
import PropTypes from 'prop-types';

import './Condition.scss';

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

  const handleChange = (event) => {
    setConditionData({
      ...conditionData,
      [event.target.name]: event.target.value,
    });
  };

  return (
    <div className="condition">
      <label>
        Intitulé de la condition :
        <input
          value={conditionData.name || ''}
          aria-label="condition-name-input"
          name="name"
          onChange={(event) => handleChange(event)}
        />
      </label>
      <label>
        Operateur :
        <input
          value={conditionData.operator || ''}
          aria-label="condition-operator-input"
          name="operator"
          onChange={(event) => handleChange(event)}
        />
      </label>
      <label>
        Left Op Id :
        <input
          value={conditionData.leftOpId || ''}
          aria-label="condition-name-input"
          name="leftOpId"
          onChange={(event) => handleChange(event)}
        />
      </label>
      <label>
        Right Op :
        <input
          value={conditionData.rightOp || ''}
          aria-label="condition-name-input"
          name="rightOp"
          onChange={(event) => handleChange(event)}
        />
      </label>
    </div>
  );
};

Condition.propTypes = {};

export default Condition;
