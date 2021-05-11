import React, { useState, useEffect } from 'react';
import PropTypes from 'prop-types';

import './Condition.scss';

const Condition = ({ shouldISendCondition, sendConditionToParent }) => {
  const condition = {
    name: '',
    operator: '',
    leftOpId: '',
    rightOp: '',
    subconditions: [],
  };

  const [conditionData, setConditionData] = useState(condition);
  const [subconditionsBlocks, setSubconditionsBlocks] = useState([]);
  let subconditionsListUICounter = 0;
  const subconditionsToAdd = [];

  // useEffect(() => {
  //   if (shouldISendCondition) {
  //     sendConditionToParent(conditionData);
  //   }
  // }, [shouldISendCondition]);

  const handleChange = (event) => {
    setConditionData({
      ...conditionData,
      [event.target.name]: event.target.value,
    });
  };

  // TO DO : refactor to a more elegant solution
  const displayNewConditionBlock = () => {
    setSubconditionsBlocks(subconditionsBlocks.concat('condition'));
  };

  // useEffect(() => {

  // }, [conditionData]);

  const addSubconditionFromChild = (subcondition) => {
    const joined = conditionData.subconditions.concat(subcondition);
    setConditionData({ ...conditionData, subconditions: joined });
  };

  const removeSubcondition = (subcondition) => {};

  const validate = () => {
    sendConditionToParent(conditionData);
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
      {subconditionsBlocks.map((condition) => {
        return (
          <Condition
            sendConditionToParent={addSubconditionFromChild}
            // shouldISendCondition={shouldSendCondition}
            key={subconditionsListUICounter++}
          />
        );
      })}
      <div className="buttons">
        <button
          type="button"
          className="add"
          onClick={() => displayNewConditionBlock()}
        >
          Ajouter une sous-condition à {conditionData.name}
        </button>
        <button type="button" className="validate" onClick={() => validate()}>
          Valider
        </button>
      </div>
    </div>
  );
};

Condition.propTypes = {};

export default Condition;
