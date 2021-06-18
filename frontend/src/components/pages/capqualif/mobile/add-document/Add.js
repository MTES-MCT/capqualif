import React, { Fragment, useState } from 'react';
import { useHistory, useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
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
  NEW_TITRE_REQUEST_RECAP_ROUTE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../app/routesDictionnary';
import { BUTTON_WIDTH } from '../../../../../dictionnary/saas/variables';
import ButtonAction from '../../../../capqualif/buttons/button-action/ButtonAction';
import { changeConditionStatus } from '../../../../../redux/capqualif/mobile/instructions/instructionsSlice';

const Add = (props) => {
  const [file, setFile] = useState();
  const { documentName } = useParams();
  const history = useHistory();
  const dispatch = useDispatch();

  const documents = useSelector((state) => state.requests.documents);
  const conditionToModify = useSelector((state) => state.currentCondition);

  const handleFileUpload = (e) => {
    console.log(e.target.files[0]);
    setFile(e.target.files[0]);
    // TO DO : add document to request.documents state
  };

  const setConditionStatusToDocumentAdded = () => {
    dispatch(changeConditionStatus(conditionToModify.id));
    history.push(
      `/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${NEW_TITRE_REQUEST_RECAP_ROUTE}`
    );
  };

  const chooseWhatToDisplay = (documents) => {
    if (findDocByCondition(documents, conditionToModify).length === 0) {
      return noDocsAddedYet();
    }
    return displayAddedDocs(documents);
  };

  const findDocByCondition = (documents, condition) => {
    return documents.filter((doc) => doc.conditionId === condition.id);
  };

  const noDocsAddedYet = () => {
    return (
      <div className={`${styles.actions} fr-mt-1w fr-px-2w`}>
        <h2>{conditionToModify.name}</h2>
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
          route={`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}/${ADD_PICTURE_ROUTE}`}
        />
      </div>
    );
  };

  const displayAddedDocs = (documents) => {
    return (
      <Fragment>
        {findDocByCondition(documents, conditionToModify).map((doc) => (
          <div
            className={`${commonStyles['capture-container']} fr-py-4w fr-mb-3w`}
          >
            <img src={doc.conditionDocument} alt="document ajouté" />
          </div>
        ))}
        <ButtonLink
          label={BUTTON_LABELS.ADD_PAGE}
          isSecondary={true}
          marginInRem={1}
          width={BUTTON_WIDTH.FULL}
          route={`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}/${ADD_PICTURE_ROUTE}`}
        />
        <div
          className={`${styles['add-container']} fr-py-2w fr-mt-1w fr-mb-2w`}
        >
          <ButtonAction
            label={BUTTON_LABELS.ADD_DOCUMENTS_TO_DOSSIER}
            width={BUTTON_WIDTH.FULL}
            actionOnClick={setConditionStatusToDocumentAdded}
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
        {chooseWhatToDisplay(documents)}
      </div>
    </Fragment>
  );
};

Add.propTypes = {};

export default Add;
