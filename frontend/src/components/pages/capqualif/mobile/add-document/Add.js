import React, { Fragment, useState, useRef } from 'react';
import { useParams } from 'react-router-dom';
import PropTypes from 'prop-types';

import styles from './Add.module.scss';

import Step from '../../../../capqualif/step/Step';
import Button from '../../../../capqualif/button/Button';
import {
  BUTTON_LABELS,
  STEPS,
} from '../../../../../dictionnary/demandeDeTitre';
import UploadButton from '../../../../capqualif/button/upload-button/UploadButton';
import {
  ADD_DOCUMENT_ROUTE,
  ADD_PICTURE_ROUTE,
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../app/routesDictionnary';

const Add = (props) => {
  const [file, setFile] = useState();
  const { documentName } = useParams();

  const handleFileUpload = (e) => {
    console.log(e.target.files[0]);
    setFile(e.target.files[0]);
    // TO DO : add file to request object
  };

  return (
    <Fragment>
      <Step label={STEPS.ADD_DOCUMENT} />
      <h3 className="fr-p-2w">{documentName}</h3>
      <div className={`${styles.actions} fr-mt-1w fr-px-2w`}>
        <UploadButton onChange={(e) => handleFileUpload(e)} />
        <p className="fr-my-1w">ou</p>
        <Button
          label={BUTTON_LABELS.TAKE_PICTURE}
          route={`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}/${ADD_PICTURE_ROUTE}/${documentName}`}
        />
      </div>
    </Fragment>
  );
};

Add.propTypes = {};

export default Add;
