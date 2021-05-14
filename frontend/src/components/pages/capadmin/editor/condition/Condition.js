import React, { useState } from 'react';
import uuid from 'react-uuid';
import { findFirst, findAndModifyFirst } from 'obj-traverse/lib/obj-traverse';
import PropTypes from 'prop-types';

import './Condition.scss';

const Condition = ({ allConditions, parentId, onChange }) => {
  // ============= Data ==================

  const initialCondition = {
    id: uuid(),
    name: '',
    operator: '',
    leftOpId: '',
    rightOp: '',
    subconditions: [],
  };

  const [conditionData, setConditionData] = useState(initialCondition);

  // =======================================

  // ============= UI =======================

  const [subconditionsBlocks, setSubconditionsBlocks] = useState([]);
  let subconditionsListUICounter = 0;

  // TO DO : refactor to a more elegant solution
  const displayNewConditionBlock = () => {
    setSubconditionsBlocks(subconditionsBlocks.concat('condition'));
  };

  // =========================================

  // ============= Act as a child ============

  const handleChange = (event) => {
    setConditionData({
      ...conditionData,
      [event.target.name]: event.target.value,
    });
  };

  const createCondition = () => {
    if (conditionListIsEmpty(allConditions)) {
      allConditions.push(conditionData);
    } else {
      findConditionById(parentId).subconditions.push(conditionData);
    }
    onChange(allConditions);
  };

  const updateCondition = (id, updatedCondition) => {
    if (!conditionListIsEmpty(allConditions)) {
      const conditionToUpdate = allConditions.find(
        (condition) => condition.id === id
      );
      if (conditionToUpdate !== undefined) {
        updateNotNestedCondition(
          allConditions,
          conditionToUpdate,
          updatedCondition
        );
      } else {
        updateNestedCondition(allConditions, id, updatedCondition);
      }
    }
    onChange(allConditions);
  };

  function updateNotNestedCondition(
    conditionsList,
    conditionToUpdate,
    updatedCondition
  ) {
    const indexOfConditionToUpdate = conditionsList.indexOf(conditionToUpdate);
    conditionsList[indexOfConditionToUpdate] = updatedCondition;
  }

  const updateNestedCondition = (conditionsList, id, updatedCondition) => {
    findAndModifyFirst(
      conditionsList[0],
      'subconditions',
      {
        id: id,
      },
      updatedCondition
    );
  };

  const deleteCondition = (id) => {
    deleteFromList(id);
    deleteFromUI();
  };

  const deleteFromList = (conditionList, id) => {};

  const deleteFromUI = () => {};

  const findConditionById = (id) => {
    const condition = allConditions.find((condition) => condition.id === id);
    if (condition !== undefined) return condition;
    return findFirst(allConditions[0], 'subconditions', {
      id: id,
    });
  };

  const conditionListIsEmpty = (conditionList) => {
    return !conditionList.length > 0;
  };

  // =========================================

  // ============= Act as a parent =============
  // 1) receive subcondition, add it to my subconditions and give it to my own parent
  const handleConditionFromChild = (allConditionsWithNewCondition) => {
    allConditions = allConditionsWithNewCondition;
    onChange(allConditionsWithNewCondition);
  };

  // =========================================

  return (
    <div className="condition">
      <div className="buttons">
        <button
          type="button"
          className="update"
          onClick={() => updateCondition(conditionData.id, conditionData)}
        >
          Modifier
        </button>
        <button
          type="button"
          className="delete"
          onClick={() => deleteCondition(conditionData.id)}
        >
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
        <button
          type="button"
          className="validate"
          onClick={() => createCondition()}
        >
          Valider
        </button>
      </div>
    </div>
  );
};

Condition.propTypes = {};

export default Condition;
