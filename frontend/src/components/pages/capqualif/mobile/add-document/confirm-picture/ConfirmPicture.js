import React from 'react';
import PropTypes from 'prop-types';
import Step from '../../../../../capqualif/step/Step';
import { STEPS } from '../../../../../../dictionnary/demandeDeTitre';
import { Fragment } from 'react';

const ConfirmPicture = (props) => {
  return (
    <Fragment>
      <Step label={STEPS.CONFIRM_PICTURE} />
      blabla
    </Fragment>
  );
};

ConfirmPicture.propTypes = {};

export default ConfirmPicture;
