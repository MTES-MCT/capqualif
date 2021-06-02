import React from 'react';
import PropTypes from 'prop-types';

import commonStyles from '../common.module.scss';

const UploadButton = ({ label, onChange }) => {
  return (
    <input
      type="file"
      className={`${commonStyles['cq-button']} ${commonStyles['fr-btn']}`}
      onChange={(e) => onChange(e)}
    >
      {label}
    </input>
  );
};

UploadButton.propTypes = {};

export default UploadButton;
