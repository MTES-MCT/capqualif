import React, { useState } from 'react';
import uuid from 'react-uuid';
import {
  findFirst,
  findAndModifyFirst,
  findAndDeleteFirst,
} from 'obj-traverse/lib/obj-traverse';
import PropTypes from 'prop-types';

import './Condition.scss';
import { findInArray } from '../../utils';

const Condition = ({
  allConditions,
  parentId,
  onChangeData,
  onChangeUI,
  uiId,
}) => {
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

  // ============= Act as myself ============

  const [subconditionsBlocks, setSubconditionsBlocks] = useState([]);

  const createNewConditionBlock = () => {
    setSubconditionsBlocks(subconditionsBlocks.concat({ id: uuid() }));
  };

  const tellParentToDeleteMyBlock = () => {
    onChangeUI(uiId);
  };

  // =======================================
  // ============= Act as parent ============

  const handleDeleteOfSubconditionBlock = (uiId) => {
    const subconditionToDelete = findInArray(subconditionsBlocks, 'id', uiId);
    subconditionsBlocks.splice(
      subconditionsBlocks.indexOf(subconditionToDelete),
      1
    );
  };

  // =========================================

  // ============= Act as myself ============

  const handleChange = (event) => {
    setConditionData({
      ...conditionData,
      [event.target.name]: event.target.value,
    });
  };

  const createCondition = (conditionsList, conditionToCreate, parentId) => {
    if (isConditionListEmpty(conditionsList)) {
      conditionsList.push(conditionToCreate);
    } else {
      findConditionById(conditionsList, parentId).subconditions.push(
        conditionToCreate
      );
    }
    onChangeData(conditionsList);
  };

  const findConditionById = (conditionsList, id) => {
    return isConditionNested(conditionsList, id)
      ? findFirst(conditionsList[0], 'subconditions', {
          id: id,
        })
      : findInArray(conditionsList, 'id', id);
  };

  const isConditionNested = (conditionsList, id) => {
    const condition = conditionsList.find((condition) => condition.id === id);
    if (condition === undefined) return true;
  };

  const updateCondition = (
    conditionsList,
    childrenKey,
    id,
    updatedCondition
  ) => {
    if (!isConditionListEmpty(conditionsList)) {
      findAndModifyFirst(
        conditionsList[0],
        childrenKey,
        {
          id: id,
        },
        updatedCondition
      );
    }
    onChangeData(conditionsList);
  };

  const deleteCondition = (conditionsList, childrenKey, id) => {
    deleteFromList(conditionsList, childrenKey, id);
    onChangeData(conditionsList);
    tellParentToDeleteMyBlock();
  };

  const deleteFromList = (conditionList, childrenKey, id) => {
    if (!isConditionListEmpty(conditionList)) {
      if (isConditionNested(conditionList, id)) {
        findAndDeleteFirst(conditionList[0], childrenKey, { id: id });
      } else {
        const conditionToDelete = findConditionById(conditionList, id);
        if (conditionToDelete && conditionToDelete !== undefined)
          conditionList.splice([conditionList.indexOf(conditionToDelete)]);
      }
    }
  };

  const isConditionListEmpty = (conditionList) => {
    if (conditionList && conditionList !== undefined)
      return !conditionList.length > 0;
  };

  // =========================================

  // ============= Act as a parent =============
  // 1) receive subcondition, add it to my subconditions and give it to my own parent
  const handleConditionFromChild = (allConditionsWithNewCondition) => {
    if (allConditionsWithNewCondition)
      allConditions = allConditionsWithNewCondition;
    onChangeData(allConditionsWithNewCondition);
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
      {subconditionsBlocks.map((conditionBlock) => {
        return (
          <Condition
            allConditions={allConditions}
            onChangeData={(subcondition) =>
              handleConditionFromChild(subcondition)
            }
            onChangeUI={(uiId) => handleDeleteOfSubconditionBlock(uiId)}
            parentId={conditionData.id}
            key={conditionBlock.id}
            uiId={conditionBlock.id}
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
