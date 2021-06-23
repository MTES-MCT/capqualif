import React from 'react';
import { Fragment } from 'react';
import { useHistory } from 'react-router';
import { useDispatch, useSelector } from 'react-redux';
import PropTypes from 'prop-types';

import commonStyles from '../common.module.scss';

import Step from '../../../../../capqualif/step/Step';
import { deleteLastPicture } from '../../../../../../redux/capqualif/mobile/requests/currentRequest';
import {
  BUTTON_LABELS,
  STEPS,
} from '../../../../../../dictionnary/demandeDeTitre';
import {
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
  ADD_DOCUMENT_ROUTE,
} from '../../../../../../app/routesDictionnary';
import { BUTTON_WIDTH } from '../../../../../../dictionnary/saas/variables';
import ButtonAction from '../../../../../capqualif/buttons/button-action/ButtonAction';

const ConfirmPicture = (props) => {
  /**
   * Boilerplate
   */
  const dispatch = useDispatch();
  const history = useHistory();

  /**
   * Let's select data from global state (redux)
   */
  const currentCondition = useSelector(
    (state) => state.currentRequest.currentCondition
  );

  /**
   * Actions on click event
   */
  const confirm = () => {
    history.push(`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}`);
  };

  const deleteAndGoBack = () => {
    dispatch(deleteLastPicture());
    history.goBack();
  };

  /**
   *  ================ UI ================
   */
  return (
    <Fragment>
      <Step label={STEPS.CONFIRM_PICTURE} />
      <div className={`${commonStyles['container']}`}>
        <h3 className="fr-m-2w">{currentCondition?.name}</h3>
        <div
          className={`${commonStyles['capture-container']} fr-py-4w fr-px-2w`}
        >
          <img
            src={
              currentCondition?.pictures[currentCondition.pictures.length - 1]
            }
            alt="document ajouté"
          />
          <ButtonAction
            label={BUTTON_LABELS.RETAKE_PICTURE}
            width={BUTTON_WIDTH.FULL}
            isSecondary={true}
            marginsInRem={{ top: 1 }}
            actionOnClick={deleteAndGoBack}
          />
          <ButtonAction
            label={BUTTON_LABELS.CONFIRM_PICTURE}
            width={BUTTON_WIDTH.FULL}
            actionOnClick={confirm}
            marginsInRem={{ top: 1 }}
          />
        </div>
      </div>
    </Fragment>
  );
};

ConfirmPicture.propTypes = {};

export default ConfirmPicture;
