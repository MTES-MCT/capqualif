import React, { useState, useEffect } from 'react';
import PropTypes from 'prop-types';

import './Condition.scss';

const Condition = ({
  shouldISendCondition,
  tellParentToAddSubcondition,
  tellParentToRemoveSubcondition,
}) => {
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

  // TO DO : REMOVE ?
  useEffect(() => {
    if (shouldISendCondition) {
      tellParentToAddSubcondition(conditionData);
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
    setSubconditionsBlocks(subconditionsBlocks.concat('condition'));
  };

  useEffect(() => {
    console.log('inside 1');
    console.log(conditionData.subconditions);
  }, []);

  useEffect(() => {
    console.log('inside 2');
    console.log(conditionData.subconditions);
    tellParentToAddSubcondition(conditionData);
  }, [conditionData.subconditions]);

  const addSubconditionFromChild = (subcondition) => {
    const joined = conditionData.subconditions.concat(subcondition);
    setConditionData({ ...conditionData, subconditions: joined });
    // setConditionData({ ...conditionData, subconditions: subcondition });
  };

  const removeSubconditionFromChild = (subcondition) => {
    console.log(conditionData.subconditions);
    const newValue = conditionData.subconditions.filter(
      (subcond) => subcond !== subcondition
    );
    setConditionData({ ...conditionData, subconditions: newValue });
    // setSubconditionsBlocks(subconditionsBlocks.filter())
  };

  const validate = () => {
    tellParentToAddSubcondition(conditionData);
  };

  const update = () => {};

  const remove = () => {
    tellParentToRemoveSubcondition(conditionData);
  };

  return (
    <div className="condition">
      <div className="buttons">
        <button type="button" className="update" onClick={() => update()}>
          Modifier
        </button>
        <button type="button" className="delete" onClick={() => remove()}>
          X
        </button>
      </div>
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
            tellParentToAddSubcondition={addSubconditionFromChild}
            tellParentToRemoveSubcondition={removeSubconditionFromChild}
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
