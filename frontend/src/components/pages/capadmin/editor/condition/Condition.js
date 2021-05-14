import React, { useState } from 'react';
import uuid from 'react-uuid';
import { findFirst } from 'obj-traverse/lib/obj-traverse';
import PropTypes from 'prop-types';

import './Condition.scss';

const Condition = ({ allConditions, parentId, onChange }) => {
  const initialCondition = {
    id: uuid(),
    name: '',
    operator: '',
    leftOpId: '',
    rightOp: '',
    subconditions: [],
  };

  const [conditionData, setConditionData] = useState(initialCondition);

  // UI
  const [subconditionsBlocks, setSubconditionsBlocks] = useState([]);
  let subconditionsListUICounter = 0;

  // Act as a child
  // 1) save my condition data in my state
  const handleChange = (event) => {
    setConditionData({
      ...conditionData,
      [event.target.name]: event.target.value,
    });
  };

  const validate = () => {
    // console.log('my parent id is ');
    // console.log(parentId);
    // console.log('my id is ');
    // console.log(conditionData.id);
    // console.log('before adding, allConditions is ');
    // console.log(allConditions);
    if (allConditions.length > 0) {
      findConditionById(conditionData.id).subconditions.push(conditionData);
    } else {
      allConditions.push(conditionData);
    }
    // console.log('now, allConditions is ');
    // console.log(allConditions);
    // 2) send my condition data to my parent (onChange) by triggering the function it gave me
    onChange(allConditions);
  };

  const update = () => {};

  const findConditionById = (id) => {
    const condition = allConditions.find(
      (condition) => condition.id === parentId
    );
    if (condition !== undefined) {
      return condition;
    } else {
      return findFirst(allConditions[0], 'subconditions', {
        id: parentId,
      });
    }
  };

  // Act as a parent
  // 1) receive subcondition, add it to my subconditions and give it to my own parent
  const handleConditionFromChild = (allConditionsWithNewCondition) => {
    // console.log('received data are');
    // console.log(allConditionsWithNewCondition);
    allConditions = allConditionsWithNewCondition;
    // console.log("let's send this to my parent :");
    // console.log(allConditions);
    onChange(allConditionsWithNewCondition);
  };

  // TO DO : refactor to a more elegant solution
  const displayNewConditionBlock = () => {
    setSubconditionsBlocks(subconditionsBlocks.concat('condition'));
  };

  return (
    <div className="condition">
      <div className="buttons">
        <button type="button" className="update" onClick={() => update()}>
          Modifier
        </button>
        <button type="button" className="delete">
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
            allConditions={allConditions}
            onChange={(subcondition) => handleConditionFromChild(subcondition)}
            parentId={conditionData.id}
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
