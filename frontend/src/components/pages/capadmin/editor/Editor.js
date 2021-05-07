import React, { Fragment, useState } from 'react';
import PropTypes from 'prop-types';
import { useDispatch } from 'react-redux';

import './Editor.scss';

import { createConditions } from '../../../../redux/capadmin/features/conditions/conditionsSlice';
import Condition from './condition/Condition';

const Editor = () => {
  const [formData, setFormData] = useState({
    titre: '',
    conditions: [],
  });

  const [shouldSendCondition, setShouldSendCondition] = useState(false);

  const dispatch = useDispatch();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setShouldSendCondition(true);
    dispatch(createConditions(formData));
  };

  const handleConditionFromChild = (condition) => {
    const updatedConditions = formData.conditions.concat(condition);
    setFormData({ ...formData, conditions: updatedConditions });
  };

  return (
    <Fragment>
      <form onSubmit={(e) => handleSubmit(e)}>
        <label>
          Intitulé du titre :
          <input
            value={formData.titre || ''}
            aria-label="name-input"
            name="titre"
            onChange={(e) => handleChange(e)}
          />
        </label>
        <Condition
          sendConditionToParent={handleConditionFromChild}
          shouldISendCondition={shouldSendCondition}
        />
        <input type="submit" value="Génerer" data-testid="submit-input" />
      </form>
    </Fragment>
  );
};

Editor.propTypes = {};

export default Editor;
