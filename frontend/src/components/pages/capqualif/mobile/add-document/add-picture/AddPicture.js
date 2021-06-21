import React, { useRef } from 'react';
import { useHistory } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import Webcam from 'react-webcam';
import PropTypes from 'prop-types';

import styles from './AddPicture.module.scss';
import { addPicture } from '../../../../../../redux/capqualif/mobile/requests/currentRequest';
import Step from '../../../../../capqualif/step/Step';
import { PICTURE, STEPS } from '../../../../../../dictionnary/demandeDeTitre';
import {
  ADD_PICTURE_ROUTE,
  CONFIRMATION_ROUTE,
} from '../../../../../../app/routesDictionnary';

const AddPicture = (props) => {
  const history = useHistory();
  const dispatch = useDispatch();
  const webcamRef = useRef(null);
  const pictureToAddName = useSelector(
    (state) => state.currentRequest.currentCondition.name
  );

  const videoConstraints = {
    width: 300,
    height: 400,
    facingMode: 'environment',
  };

  const capture = React.useCallback(() => {
    const imageSrc = webcamRef.current.getScreenshot();
    dispatch(addPicture(imageSrc));
    history.push(`${ADD_PICTURE_ROUTE}/${CONFIRMATION_ROUTE}`);
  }, [webcamRef]);

  return (
    <div className={`${styles['dark']}`}>
      <Step label={STEPS.TAKE_PICTURE} isDark={true} />
      <div className={`${styles['camera-container']} fr-p-1w fr-m-2w`}>
        <p className="fr-mb-2w">{pictureToAddName}</p>
        <Webcam
          ref={webcamRef}
          audio={false}
          screenshotFormat={'image/jpeg'}
          videoConstraints={videoConstraints}
        />
      </div>
      <div className={`${styles['button-container']} fr-py-2w`}>
        <button className={`${styles['button']} fr-p-1w`} onClick={capture}>
          {PICTURE.PRESS_HERE}
        </button>
      </div>
    </div>
  );
};

AddPicture.propTypes = {};

export default AddPicture;
