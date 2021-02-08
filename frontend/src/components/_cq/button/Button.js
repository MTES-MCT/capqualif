import React from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

import './Button.scss';

const Button = ({ label, labelSize, route, actionType }) => {
  return (
    <button className="cq-btn">
      <Link
        to={route}
        className={`rf-btn cq-btn__uppercase cq-helpers__no-linebreak cq-btn__action-${actionType}`}
        style={{ fontSize: labelSize }}
      >
        {label}
      </Link>
    </button>
  );
};

Button.propTypes = {
  label: PropTypes.string.isRequired,
  labelSize: PropTypes.string,
  actionType: PropTypes.string,
  backgroundColor: PropTypes.string,
  route: PropTypes.string.isRequired,
};

export default Button;
