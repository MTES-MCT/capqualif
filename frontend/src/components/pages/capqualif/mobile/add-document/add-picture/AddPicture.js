import React, { useRef } from 'react';
import Webcam from 'react-webcam';
import PropTypes from 'prop-types';

import styles from './AddPicture.module.scss';
import Step from '../../../../../capqualif/step/Step';
import { PICTURE, STEPS } from '../../../../../../dictionnary/demandeDeTitre';

const AddPicture = (props) => {
  const webcamRef = React.useRef(null);

  const videoConstraints = {
    width: 320,
    height: 400,
    // facingMode: "user"
  };

  const capture = React.useCallback(() => {
    const imageSrc = webcamRef.current.getScreenshot();
    console.log(imageSrc);
  }, [webcamRef]);

  return (
    <div className={`${styles['dark']}`}>
      <Step label={STEPS.TAKE_PICTURE} isDark={true} />
      <div className={`${styles['camera-container']} fr-p-2w fr-m-3w`}>
        <Webcam
          ref={webcamRef}
          audio={false}
          screenshotFormat={'image/jpeg'}
          videoConstraints={videoConstraints}
        />{' '}
        <button
          className={`${styles['button']} fr-mt-3w fr-p-1w`}
          onClick={capture}
        >
          {PICTURE.PRESS_HERE}
        </button>
      </div>
    </div>
  );
};

AddPicture.propTypes = {};

export default AddPicture;
