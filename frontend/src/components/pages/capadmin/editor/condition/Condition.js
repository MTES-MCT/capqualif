import React, { useState } from 'react';
import uuid from 'react-uuid';
import { findFirst, findAndModifyFirst } from 'obj-traverse/lib/obj-traverse';
import PropTypes from 'prop-types';

import './Condition.scss';

const Condition = ({ allConditions: conditionsList, parentId, onChange }) => {
  // ============= Data ==================

  const initialCondition = {
    id: uuid(),
    name: '',
    operator: '',
    leftOpId: '',
    rightOp: '',
    subconditions: [],
  };

  const [conditionToCreate, setConditionData] = useState(initialCondition);

  // =======================================

  // ============= UI =======================

  const [subconditionsBlocks, setSubconditionsBlocks] = useState([]);
  let subconditionsListUICounter = 0;

  // TO DO : refactor to a more elegant solution
  const createNewConditionBlock = () => {
    setSubconditionsBlocks(subconditionsBlocks.concat('condition'));
  };

  const deleteConditionBlock = () => {};

  // =========================================

  // ============= Act as a child ============

  const handleChange = (event) => {
    setConditionData({
      ...conditionToCreate,
      [event.target.name]: event.target.value,
    });
  };

  const createCondition = (conditionsList, conditionToCreate, parentId) => {
    if (conditionListIsEmpty(conditionsList)) {
      conditionsList.push(conditionToCreate);
    } else {
      findConditionById(parentId).subconditions.push(conditionToCreate);
    }
    onChange(conditionsList);
  };

  const findConditionById = (id) => {
    const condition = conditionsList.find((condition) => condition.id === id);
    if (condition !== undefined) return condition;
    return findFirst(conditionsList[0], 'subconditions', {
      id: id,
    });
  };

  const updateCondition = (conditionsList, id, updatedCondition) => {
    if (!conditionListIsEmpty(conditionsList)) {
      findAndModifyFirst(
        conditionsList[0],
        'subconditions',
        {
          id: id,
        },
        updatedCondition
      );
    }
    onChange(conditionsList);
  };

  const deleteCondition = (id) => {
    deleteFromList(id);
    deleteConditionBlock();
  };

  const deleteFromList = (conditionList, id) => {};

  const conditionListIsEmpty = (conditionList) => {
    return !conditionList.length > 0;
  };

  // =========================================

  // ============= Act as a parent =============
  // 1) receive subcondition, add it to my subconditions and give it to my own parent
  const handleConditionFromChild = (allConditionsWithNewCondition) => {
    conditionsList = allConditionsWithNewCondition;
    onChange(allConditionsWithNewCondition);
  };

  // =========================================

  return (
    <div className="condition">
      <div className="buttons">
        <button
          type="button"
          className="update"
          onClick={() =>
            updateCondition(
              conditionsList,
              conditionToCreate.id,
              conditionToCreate
            )
          }
        >
          Modifier
        </button>
        <button
          type="button"
          className="delete"
          onClick={() => deleteCondition(conditionToCreate.id)}
        >
          X
        </button>
      </div>
      <label>
        Intitulé de la condition :
        <input
          value={conditionToCreate.name || ''}
          aria-label="condition-name-input"
          name="name"
          onChange={(event) => handleChange(event)}
        />
      </label>
      <label>
        Operateur :
        <input
          value={conditionToCreate.operator || ''}
          aria-label="condition-operator-input"
          name="operator"
          onChange={(event) => handleChange(event)}
        />
      </label>
      <label>
        Left Op Id :
        <input
          value={conditionToCreate.leftOpId || ''}
          aria-label="condition-name-input"
          name="leftOpId"
          onChange={(event) => handleChange(event)}
        />
      </label>
      <label>
        Right Op :
        <input
          value={conditionToCreate.rightOp || ''}
          aria-label="condition-name-input"
          name="rightOp"
          onChange={(event) => handleChange(event)}
        />
      </label>
      {subconditionsBlocks.map((condition) => {
        return (
          <Condition
            allConditions={conditionsList}
            onChange={(subcondition) => handleConditionFromChild(subcondition)}
            parentId={conditionToCreate.id}
            key={subconditionsListUICounter++}
          />
        );
      })}
      <div className="buttons">
        <button
          type="button"
          className="add"
          onClick={() => createNewConditionBlock()}
        >
          Ajouter une sous-condition à {conditionToCreate.name}
        </button>
        <button
          type="button"
          className="validate"
          onClick={() =>
            createCondition(conditionsList, conditionToCreate, parentId)
          }
        >
          Valider
        </button>
      </div>
    </div>
  );
};

Condition.propTypes = {};

export default Condition;
