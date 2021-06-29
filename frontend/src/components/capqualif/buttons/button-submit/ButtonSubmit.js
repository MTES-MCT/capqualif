import React from 'react';
import PropTypes from 'prop-types';

import commonStyles from '../common.module.scss';
import { BUTTON_WIDTH } from '../../../../dictionnary/saas/variables';

const ButtonSubmit = ({ label, labelSize, width, marginsInRem }) => {
  return (
    <button
      type="submit"
      class="fr-btn"
      title={label}
      className={`${commonStyles['cq-button']} 
            ${commonStyles['fr-btn']} 
            ${width === BUTTON_WIDTH.FULL ? 'cq-helpers-full-width' : ''}`}
      style={{
        marginTop: `${marginsInRem ? `${marginsInRem.top}rem` : '0rem'}`,
        marginBottom: `${marginsInRem ? `${marginsInRem.bottom}rem` : '0rem'}`,
        fontSize: labelSize,
      }}
    >
      {label}
    </button>
  );
};

ButtonSubmit.propTypes = {
  label: PropTypes.string.isRequired,
  labelSize: PropTypes.string,
  width: PropTypes.string,
  marginsInRem: PropTypes.object,
};

export default ButtonSubmit;
