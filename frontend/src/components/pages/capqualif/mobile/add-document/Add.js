import React, { Fragment, useState } from 'react';
import { useParams } from 'react-router-dom';
import PropTypes from 'prop-types';

import styles from './Add.module.scss';

import Step from '../../../../capqualif/step/Step';
import Button from '../../../../capqualif/button/Button';
import {
  BUTTON_LABELS,
  STEPS,
} from '../../../../../dictionnary/demandeDeTitre';

const Add = (props) => {
  const [file, setFile] = useState();
  const { documentName } = useParams();

  const triggerAddFile = (e) => {
    console.log('bip');
    this.refs.fileInput.click();
  };

  const handleFileUpload = (e) => {
    console.log('bop');
    setFile(e.target.files[0]);
  };

  return (
    <Fragment>
      <Step label={STEPS.ADD_DOCUMENT} />
      <h3 className="fr-p-2w">{documentName}</h3>
      <div
        className={`${styles.actions} fr-mt-1w fr-px-2w fr-grid-row fr-grid-row--center`}
      >
        <input type="file" ref="fileInput" style={{ display: 'none' }} />
        <Button
          label={BUTTON_LABELS.UPLOAD_DOCUMENT}
          actionOnClick={triggerAddFile}
        />
        <p className="fr-my-1w">ou</p>
        <Button label={BUTTON_LABELS.TAKE_PICTURE} />
      </div>
    </Fragment>
  );
};

Add.propTypes = {};

export default Add;
