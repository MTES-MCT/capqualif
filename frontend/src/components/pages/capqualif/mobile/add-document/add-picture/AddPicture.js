import React, { useRef } from 'react';
import { useHistory, useParams } from 'react-router-dom';
import Webcam from 'react-webcam';
import PropTypes from 'prop-types';

import styles from './AddPicture.module.scss';
import Step from '../../../../../capqualif/step/Step';
import { PICTURE, STEPS } from '../../../../../../dictionnary/demandeDeTitre';
import {
  ADD_DOCUMENT_ROUTE,
  ADD_PICTURE_ROUTE,
  CONFIRMATION_ROUTE,
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../../app/routesDictionnary';

const AddPicture = (props) => {
  const history = useHistory();
  const { documentName } = useParams();

  const webcamRef = useRef(null);

  const videoConstraints = {
    width: 300,
    height: 400,
    facingMode: 'environment',
  };

  const capture = React.useCallback(() => {
    const imageSrc = webcamRef.current.getScreenshot();
    console.log(imageSrc);
    history.push(`${documentName}/${CONFIRMATION_ROUTE}`);
  }, [webcamRef]);

  return (
    <div className={`${styles['container']} ${styles['dark']}`}>
      <Step label={STEPS.TAKE_PICTURE} isDark={true} />
      <div className={`${styles['camera-container']} fr-p-1w fr-m-2w`}>
        <p className="fr-mb-2w">{documentName}</p>
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