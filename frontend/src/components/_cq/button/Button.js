import React from 'react';
import { Link } from 'react-router-dom';

const Button = ({ label, route }) => {
  return (
    <button>
      <Link to={route} className="rf-btn cq-upper">
        {label}
      </Link>
    </button>
  );
};

export default Button;
