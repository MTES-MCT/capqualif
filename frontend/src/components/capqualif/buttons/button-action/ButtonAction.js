import React from 'react';
import PropTypes from 'prop-types';

import commonStyles from '../common.module.scss';
import { BUTTON_WIDTH } from '../../../../dictionnary/saas/variables';

const ButtonAction = ({
  label,
  labelSize,
  width,
  isSecondary,
  marginsInRem,
  actionOnClick,
}) => {
  return (
    <button
      className={`${commonStyles['cq-button']} ${commonStyles['fr-btn']} ${
        width === BUTTON_WIDTH.FULL ? 'cq-helpers-full-width' : ''
      } ${isSecondary ? commonStyles['fr-btn--secondary'] : ''}`}
      style={{
        marginTop: `${marginsInRem ? `${marginsInRem.top}rem` : '0rem'}`,
        marginBottom: `${marginsInRem ? `${marginsInRem.bottom}rem` : '0rem'}`,
        fontSize: labelSize,
      }}
      onClick={() => actionOnClick()}
    >
      {label}
    </button>
  );
};

ButtonAction.propTypes = {
  label: PropTypes.string.isRequired,
  labelSize: PropTypes.string,
  width: PropTypes.string,
  isSecondary: PropTypes.bool,
  marginsInRem: PropTypes.object,
  actionOnClick: PropTypes.func,
};

export default ButtonAction;
