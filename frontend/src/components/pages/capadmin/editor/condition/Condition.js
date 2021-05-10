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
  const [conditionsBlocks, setConditionsBlocks] = useState([]);
  let conditionsListUICounter = 0;
  const conditionsToAdd = [];

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

  // TO DO : refactor to a more elegant solution
  const displayNewConditionBlock = () => {
    setConditionsBlocks(conditionsBlocks.concat('condition'));
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
      {conditionsBlocks.map((condition) => {
        return (
          <Condition
            // sendConditionToParent={handleConditionFromChild}
            // shouldISendCondition={shouldSendCondition}
            key={conditionsListUICounter++}
          />
        );
      })}
      <button
        type="button"
        className="add"
        onClick={() => displayNewConditionBlock()}
      >
        Ajouter une sous-condition à {conditionData.name}
      </button>
    </div>
  );
};

Condition.propTypes = {};

export default Condition;
