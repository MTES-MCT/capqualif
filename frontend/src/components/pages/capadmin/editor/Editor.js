import React, { Children, Fragment, useState } from 'react';
import PropTypes from 'prop-types';
import { useDispatch } from 'react-redux';

import './Editor.scss';

import { createConditions } from '../../../../redux/capadmin/features/conditions/conditionsSlice';
import Condition from './condition/Condition';

const Editor = () => {
  const dispatch = useDispatch();

  const [formData, setFormData] = useState({
    titre: '',
    conditions: [],
  });

  const [shouldSendCondition, setShouldSendCondition] = useState(false);
  const [conditionsList, setConditionsList] = useState([]);

  const handleChange = (event) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    setShouldSendCondition(true);
    // dispatch(createConditions(formData));
  };

  const conditionsToAdd = [];

  const handleConditionFromChild = (condition) => {
    collectConditions(condition);
    const updatedConditions = formData.conditions.concat(conditionsToAdd);
    console.log(updatedConditions);
    setFormData({ ...formData, conditions: updatedConditions });
  };

  const collectConditions = (condition) => {
    conditionsToAdd.push(condition);
  };

  const addCondition = () => {
    setConditionsList(conditionsList.concat('condition'));
  };

  let i = 0;

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
        {conditionsList.map((condition) => {
          i++;
          return (
            <Condition
              sendConditionToParent={handleConditionFromChild}
              shouldISendCondition={shouldSendCondition}
              key={i}
            />
          );
        })}
        <button type="button" id="add" onClick={() => addCondition()}>
          Ajouter une condition
        </button>
        {/* <button onClick={() => addCondition()}>Ajouter une condition</button> */}
        <input type="submit" value="Génerer" data-testid="submit-input" />
      </form>
    </div>
  );
};

Editor.propTypes = {};

export default Editor;
