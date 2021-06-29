import React from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

import commonStyles from './common.module.scss';
import { BUTTON_WIDTH } from '../../../dictionnary/saas/variables';

const ButtonLink = ({
  label,
  labelSize,
  width,
  isSecondary,
  marginsInRem,
  route,
}) => {
  return (
    <Link
      to={route}
      className={`${commonStyles['cq-button']} ${commonStyles['fr-btn']} ${
        width === BUTTON_WIDTH.FULL ? 'cq-helpers-full-width' : ''
      }
    ${isSecondary ? commonStyles['fr-btn--secondary'] : ''}`}
      style={{
        marginTop: `${marginsInRem ? `${marginsInRem.top}rem` : '0rem'}`,
        marginBottom: `${marginsInRem ? `${marginsInRem.bottom}rem` : '0rem'}`,
        fontSize: labelSize,
      }}
    >
      {label}
    </Link>
  );
};

ButtonLink.propTypes = {
  label: PropTypes.string.isRequired,
  labelSize: PropTypes.string,
  width: PropTypes.string,
  isSecondary: PropTypes.bool,
  marginsInRem: PropTypes.object,
  route: PropTypes.string,
};

export default ButtonLink;
