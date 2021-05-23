import React from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

import styles from './Button.module.scss';

const Button = ({ label, route }) => {
  return (
    <button className={styles['fr-btn']}>
      <Link to={route}>{label}</Link>
    </button>
    // <button className="cq-btn">
    //   <Link
    //     to={route}
    //     className={`fr-btn disabled cq-helpers__no-linebreak
    //       cq-btn__content-action-${actionType}`}
    //     style={{ fontSize: labelSize }}
    //     disabled={disabled}
    //   >
    //     {label}
    //   </Link>
    // </button>
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
