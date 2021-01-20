import React from 'react';
import { Link } from 'react-router-dom';

import './Button.scss';

const Button = ({ label, route, variantColor }) => {
  return (
    <button>
      <Link to={route} className={`rf-btn cq-upper ${variantColor}`}>
        {label}
      </Link>
    </button>
  );
};

export default Button;
