import React, { Fragment } from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

import commonStyles from './common.module.scss';
import { BUTTON_WIDTH } from '../../../dictionnary/saas/variables';

const Button = ({ label, labelSize, width, route }) => {
  return (
    <button
      className={`${commonStyles['cq-button']} ${commonStyles['fr-btn']} ${
        width === BUTTON_WIDTH.FULL ? 'cq-helpers-full-width' : ''
      }`}
    >
      {route ? (
        <Link to={route} style={{ fontSize: labelSize }}>
          {label}
        </Link>
      ) : (
        <Fragment>{label}</Fragment>
      )}
    </button>
    // <button className="cq-btn">
    //   <Link
    //     to={route}
    //     className={`fr-btn disabled cq-helpers-no-linebreak
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
  width: PropTypes.string,
  route: PropTypes.string,
};

export default Button;
