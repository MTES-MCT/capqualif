import React, { useState } from 'react';
import uuid from 'react-uuid';
import {
  findFirst,
  findAndModifyFirst,
  findAndDeleteFirst,
  findAndDeleteAll,
} from 'obj-traverse/lib/obj-traverse';
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
  const createNewConditionBlock = () => {
    setSubconditionsBlocks(subconditionsBlocks.concat('condition'));
  };

  const deleteConditionBlock = () => {};

  // =========================================

  // ============= Act as a child ============

  const handleChange = (event) => {
    setConditionData({
      ...conditionData,
      [event.target.name]: event.target.value,
    });
  };

  const createCondition = (conditionsList, conditionToCreate, parentId) => {
    if (conditionListIsEmpty(conditionsList)) {
      conditionsList.push(conditionToCreate);
    } else {
      findConditionById(conditionsList, parentId).subconditions.push(
        conditionToCreate
      );
    }
    onChange(conditionsList);
  };

  const findConditionById = (conditionsList, id) => {
    const condition = allConditions.find(
      (condition) => condition.id === parentId
    );
    if (condition !== undefined) return condition;
    return findFirst(conditionsList[0], 'subconditions', {
      id: id,
    });
  };

  const updateCondition = (
    conditionsList,
    childrenKey,
    id,
    updatedCondition
  ) => {
    if (!conditionListIsEmpty(conditionsList)) {
      findAndModifyFirst(
        conditionsList[0],
        childrenKey,
        {
          id: id,
        },
        updatedCondition
      );
    }
    onChange(conditionsList);
  };

  const deleteCondition = (conditionsList, childrenKey, id) => {
    deleteFromList(conditionsList, childrenKey, id);
    deleteConditionBlock();
    onChange(conditionsList);
  };

  const deleteFromList = (conditionList, childrenKey, id) => {
    // For some unkown reason, findAndDeleteFirst does not work in case we only have one condition,
    // so we have to imlplement this use case ourselves.

    // TO DO : implement delete for not nested conditions
    const conditionToDelete = findConditionById(conditionList, id);
    findAndDeleteFirst(conditionList[0], childrenKey, { id: id });
    // if (conditionList.length === 1) conditionList.pop();
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
          onClick={() =>
            updateCondition(
              allConditions,
              'subconditions',
              conditionData.id,
              conditionData
            )
          }
        >
          Modifier
        </button>
        <button
          type="button"
          className="delete"
          onClick={() =>
            deleteCondition(allConditions, 'subconditions', conditionData.id)
          }
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
          onClick={() => createNewConditionBlock()}
        >
          Ajouter une sous-condition à {conditionData.name}
        </button>
        <button
          type="button"
          className="validate"
          onClick={() =>
            createCondition(allConditions, conditionData, parentId)
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
