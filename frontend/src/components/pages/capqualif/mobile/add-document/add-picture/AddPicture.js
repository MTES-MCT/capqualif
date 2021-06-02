import React from 'react';
import PropTypes from 'prop-types';

import styles from './AddPicture.module.scss';
import Step from '../../../../../capqualif/step/Step';
import { STEPS } from '../../../../../../dictionnary/demandeDeTitre';

const AddPicture = (props) => {
  return <Step label={STEPS.TAKE_PICTURE} />;
};

AddPicture.propTypes = {};

export default AddPicture;
