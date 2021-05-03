import React from 'react';
import PropTypes from 'prop-types';

import './Editor.scss';

const Editor = () => {
  const generateJson = () => {
    return '';
  };

  return (
    <div>
      <button onClick={() => generateJson()}>Génerer</button>
    </div>
  );
};

Editor.propTypes = {};

export default Editor;
