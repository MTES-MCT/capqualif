import React from 'react';
import { Link } from 'react-router-dom';

import './Button.scss';

const Button = ({ label, labelSize, route, onClickAction }) => {
  return (
    <button>
      <Link
        to={route}
        className={`rf-btn cq-btn__uppercase cq-helpers__no-linebreak ${labelSize}`}
      >
        {label}
      </Link>
    </button>
  );
};

export default Button;
