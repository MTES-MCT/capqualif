import React, { Fragment, useState } from 'react';
import PropTypes from 'prop-types';

import './Editor.scss';
import { generateConditions } from './logic';
import ResultDisplayer from '../result-displayer/ResultDisplayer';

const Editor = () => {
  const [formData, setFormData] = useState({
    name: '',
    conditions: '',
  });
  const [finalData, setFinalData] = useState(null);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setFinalData(formData);
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
      <div aria-label="result">{JSON.stringify(finalData)}</div>
    </Fragment>
  );
};

Editor.propTypes = {};

export default Editor;
