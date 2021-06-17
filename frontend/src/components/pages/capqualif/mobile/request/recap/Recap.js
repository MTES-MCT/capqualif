import React, { Fragment } from 'react';
import { useSelector } from 'react-redux';
import PropTypes from 'prop-types';

import styles from './Recap.module.scss';

import Step from '../../../../../capqualif/step/Step';
import {
  BUTTON_LABELS,
  DETAILS_TYPE,
  RESTRICTIONS,
  STATUS_TYPES,
  STEPS,
  VALIDITY,
  VARIOUS,
} from '../../../../../../dictionnary/demandeDeTitre';
import CqItemHeader from '../../../../../capqualif/cq-item/elements/cq-item-header/CqItemHeader';
import CqItemFlagged from '../../../../../capqualif/cq-item/elements/cq-item-flagged/CqItemFlagged';
import CqItemTitre from '../../../../../capqualif/cq-item/mobile/cq-item-titre/CqItemTitre';
import {
  BUTTON_WIDTH,
  FONT_SIZES,
} from '../../../../../../dictionnary/saas/variables';
import {
  CONFIRMATION_ROUTE,
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
} from '../../../../../../app/routesDictionnary';
import CqItemAction from '../../../../../capqualif/cq-item/elements/cq-item-action/CqItemAction';
import { convertToEuropeanFormat } from '../../../../../../app/utils';

const Recap = (props) => {
  // TO DO : CHANGE
  const titre = useSelector((state) => state.instructions.titres[0]);

  // TO DO : CHANGE
  const requestMock = {
    startDate: '2021/06/18',
  };

  const displayRestrictions = (restrictions) => {
    if (restrictions.length === 0) {
      return <p>{RESTRICTIONS.NO_RESTRICTION}</p>;
    }
    return (
      <p>
        Restrictions&nbsp;:{' '}
        {restrictions.map((restriction) => (
          <p>{restriction}</p>
        ))}
      </p>
    );
  };

  const computeEndDate = (startDate, duration) => {
    const start = new Date(startDate);
    const endDate = new Date(
      start.getFullYear() + parseInt(duration),
      start.getMonth(),
      start.getDate() - 1
    );
    return convertToEuropeanFormat(endDate);
  };

  return (
    <Fragment>
      <Step label={STEPS.CONFIRM} />
      <div className="fr-mt-2w fr-px-2w">
        <CqItemHeader
          subtitle={'Appui · Pont'}
          name={'Certificat de Matelot Pont'}
        />
        {displayRestrictions(titre.instruction.results.restrictions)}
        <div className={`${styles['spaced']} fr-grid-row fr-my-3w`}>
          <p>{VALIDITY.DURATION}</p>
          <CqItemFlagged label={`${titre.titre.validityDurationInYears} ans`} />
        </div>
        <div className={`${styles['spaced']} fr-grid-row fr-my-2w`}>
          <p>{VALIDITY.START_DATE}</p>
          <CqItemFlagged
            label={convertToEuropeanFormat(requestMock.startDate)}
          />
        </div>
        <div className={`${styles['spaced']} fr-grid-row fr-my-2w`}>
          <p>{VALIDITY.END_DATE}</p>
          <CqItemFlagged
            label={computeEndDate(
              requestMock.startDate,
              titre.titre.validityDurationInYears
            )}
          />
        </div>
        <p className="fr-mb-2w">{VARIOUS.DATES_WARNING}</p>
        <CqItemTitre
          subtitle={VARIOUS.RECAPITULATIF}
          name={displayRestrictions(titre.instruction.results.restrictions)}
          status={{
            type: STATUS_TYPES.DOSSIER,
            value: titre.instruction.dossierStatus,
          }}
          details={{
            type: DETAILS_TYPE.CONDITIONS,
            content: titre.instruction,
          }}
        />
        <CqItemAction
          action={{
            label: BUTTON_LABELS.CONFIRM,
            labelSize: FONT_SIZES.SMALL,
            width: BUTTON_WIDTH.FULL,
            route:
              '/' +
              MOBILE +
              '/' +
              NEW_TITRE_REQUEST_ROUTE +
              '/' +
              CONFIRMATION_ROUTE,
          }}
        />
      </div>
    </Fragment>
  );
};

Recap.propTypes = {};

export default Recap;
