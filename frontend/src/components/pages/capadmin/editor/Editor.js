import React, { useState } from 'react';
import uuid from 'react-uuid';
import { useDispatch } from 'react-redux';
import PropTypes from 'prop-types';

import './Editor.scss';

import Condition from './condition/Condition';
import { createConditions } from '../../../../redux/capadmin/features/conditions/conditionsSlice';

const Editor = () => {
  const dispatch = useDispatch();

  const [formData, setFormData] = useState({
    titre: '',
    conditions: [],
  });
  const [conditionsBlocks, setConditionsBlocks] = useState([]);
  let conditionsListUICounter = 0;

  const handleChange = (event) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
  };

  // TO DO : refactor to a more elegant solution
  const displayNewConditionBlock = () => {
    setConditionsBlocks(conditionsBlocks.concat('condition'));
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
        {conditionsBlocks.map((condition) => {
          return (
            <Condition
              parentId={uuid()}
              allConditions={formData.conditions}
              onChange={(conditions) => {
                console.log('final action !');
                console.log(conditions);
                setFormData({ ...formData, conditions: conditions });
              }}
              key={conditionsListUICounter++}
            />
          );
        })}
        <button
          type="button"
          className="add"
          onClick={() => displayNewConditionBlock()}
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
