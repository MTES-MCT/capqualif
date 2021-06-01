import React, { useState } from 'react';
import uuid from 'react-uuid';
import { useDispatch } from 'react-redux';
import PropTypes from 'prop-types';

import './Editor.scss';
import { findInArray } from '../../../../app/utils';

import Condition from './condition/Condition';

const Editor = () => {
  const dispatch = useDispatch();

  const [formData, setFormData] = useState({
    titre: '',
    conditions: [],
  });
  const [conditionsBlocks, setConditionsBlocks] = useState([]);

  // ============= UI =======================

  const createNewConditionBlock = () => {
    setConditionsBlocks(conditionsBlocks.concat({ id: uuid() }));
  };

  const handleDeleteOfConditionBlock = (uiId) => {
    const conditionToDelete = findInArray(conditionsBlocks, 'id', uiId);
    conditionsBlocks.splice(conditionsBlocks.indexOf(conditionToDelete), 1);
  };

  // =======================================

  const handleChange = (event) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
  };

  return (
    <div id="editor">
      <form onSubmit={handleSubmit}>
        <label>
          Intitulé du titre :
          <input
            value={formData.titre || ''}
            aria-label="name-input"
            name="titre"
            onChange={(e) => handleChange(e)}
          />
        </label>
        {conditionsBlocks.map((conditionBlock) => {
          return (
            <Condition
              parentId={uuid()}
              allConditions={formData.conditions}
              onChangeData={(conditions) => {
                setFormData({ ...formData, conditions: conditions });
              }}
              onChangeUI={(uiId) => handleDeleteOfConditionBlock(uiId)}
              key={conditionBlock.id}
              uiId={conditionBlock.id}
            />
          );
        })}
        <button
          type="button"
          className="add"
          onClick={() => createNewConditionBlock()}
        >
          Ajouter des conditions
        </button>
        <input type="submit" value="Génerer" data-testid="submit-input" />
      </form>
    </div>
  );
};

Editor.propTypes = {};

export default Editor;
