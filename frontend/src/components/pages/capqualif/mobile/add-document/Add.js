import React, { Fragment, useState, useRef } from 'react';
import { useParams } from 'react-router-dom';
import PropTypes from 'prop-types';

import styles from './Add.module.scss';
import commonStyles from './common.module.scss';

import Step from '../../../../capqualif/step/Step';
import ButtonLink from '../../../../capqualif/buttons/ButtonLink';
import {
  BUTTON_LABELS,
  STEPS,
  VARIOUS,
} from '../../../../../dictionnary/demandeDeTitre';
import ButtonUpload from '../../../../capqualif/buttons/button-upload/ButtonUpload';
import {
  ADD_DOCUMENT_ROUTE,
  ADD_PICTURE_ROUTE,
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../app/routesDictionnary';
import { BUTTON_WIDTH } from '../../../../../dictionnary/saas/variables';
import ButtonAction from '../../../../capqualif/buttons/button-action/ButtonAction';

const Add = (props) => {
  const [file, setFile] = useState();
  const { documentName } = useParams();

  const emptyMock = [];

  const documentsMock = [
    'data:image/jpeg;base64,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',
    'data:image/jpeg;base64,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',
  ];

  const handleFileUpload = (e) => {
    console.log(e.target.files[0]);
    setFile(e.target.files[0]);
    // TO DO : add document to request.documents state
  };

  const chooseWhatToDisplay = (documents) => {
    if (documents.length === 0) {
      return noDocsAddedYet();
    }
    return displayAddedDocs(documents);
  };

  const noDocsAddedYet = () => {
    return (
      <div className={`${styles.actions} fr-mt-1w fr-px-2w`}>
        <p className="fr-mb-4w">
          {VARIOUS.DOCUMENT_WARNING.PART_1}{' '}
          <span className={`${styles['highlighted']}`}>
            {VARIOUS.DOCUMENT_WARNING.PART_2}
          </span>{' '}
          {VARIOUS.DOCUMENT_WARNING.PART_3}{' '}
          <span className={`${styles['highlighted']}`}>
            {VARIOUS.DOCUMENT_WARNING.PART_4}
          </span>
          .
        </p>
        <ButtonUpload onChange={(e) => handleFileUpload(e)} />
        <p className="fr-my-1w">ou</p>
        <ButtonLink
          label={BUTTON_LABELS.TAKE_PICTURE}
          route={`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}/${ADD_PICTURE_ROUTE}/${documentName}`}
        />
      </div>
    );
  };

  const addDocumentsToDossier = () => {
    console.log('bip');
    // TO DO : add document to request.documents state
  };

  const displayAddedDocs = (documents) => {
    return (
      <Fragment>
        {documents.map((doc) => (
          <div
            className={`${commonStyles['capture-container']} fr-py-4w fr-mb-3w`}
          >
            <img src={doc} alt="document ajouté" />
          </div>
        ))}
        <ButtonLink
          label={BUTTON_LABELS.ADD_PAGE}
          isSecondary={true}
          marginInRem={1}
          width={BUTTON_WIDTH.FULL}
        />
        <div
          className={`${styles['add-container']} fr-py-2w fr-mt-1w fr-mb-2w`}
        >
          <ButtonAction
            label={BUTTON_LABELS.ADD_DOCUMENTS_TO_DOSSIER}
            width={BUTTON_WIDTH.FULL}
            actionOnClick={addDocumentsToDossier}
          />
        </div>
      </Fragment>
    );
  };

  return (
    <Fragment>
      <Step label={STEPS.ADD_DOCUMENT} />
      <div className={`${commonStyles['container']} fr-px-1w`}>
        <h3 className="fr-pt-2w fr-pb-1w">{documentName}</h3>
        {chooseWhatToDisplay(emptyMock)}
      </div>
    </Fragment>
  );
};

Add.propTypes = {};

export default Add;
