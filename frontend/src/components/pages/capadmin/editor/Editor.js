import React, { Fragment, useState } from 'react';
import PropTypes from 'prop-types';
import { useDispatch } from 'react-redux';

import './Editor.scss';

import { generateConditions } from './logic';
import { createConditions } from '../../../../redux/capadmin/features/conditions/conditionsSlice';

const Editor = () => {
  const [formData, setFormData] = useState({
    name: '',
    conditions: '',
  });

  const dispatch = useDispatch();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch(createConditions(formData));
  };

  return (
    <Fragment>
      <form onSubmit={(e) => handleSubmit(e)}>
        <label>
          Intitulé du titre :
          <input
            value={formData.name || ''}
            aria-label="name-input"
            name="name"
            onChange={(e) => handleChange(e)}
          />
        </label>
        <input type="submit" value="Génerer" data-testid="submit-input" />
      </form>
    </Fragment>
  );
};

Editor.propTypes = {};

export default Editor;
