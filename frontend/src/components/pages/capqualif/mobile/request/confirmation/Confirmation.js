import React from 'react';
import PropTypes from 'prop-types';

import styles from './Confirmation.module.scss';
import {
  BUTTON_LABELS,
  REQUEST,
} from '../../../../../../dictionnary/demandeDeTitre';
import CqItemAction from '../../../../../capqualif/cq-item/elements/cq-item-action/CqItemAction';
import {
  DASHBOARD_ROUTE,
  MOBILE,
} from '../../../../../../app/routesDictionnary';
import { BUTTON_WIDTH } from '../../../../../../dictionnary/saas/variables';
import ButtonLink from '../../../../../capqualif/buttons/ButtonLink';

const Confirmation = (props) => {
  return (
    <div className={`${styles['page']} fr-container`}>
      <div className={`${styles['message-container']} fr-container fr-pb-1w`}>
        <h2 className={`${styles['header']} fr-p-2w`}>
          {`${REQUEST.STATUS_REQUEST.SENT.SHORT} !`}
        </h2>
        <p className="fr-p-2w">
          {REQUEST.STATUS_REQUEST.SENT.DETAILED.PART_1}{' '}
          <span className={`${styles['titre']}`}>
            Certificat de Matelot Pont
          </span>{' '}
          {REQUEST.STATUS_REQUEST.SENT.DETAILED.PART_2}
        </p>
        <ButtonLink
          label={BUTTON_LABELS.GO_BACK_HOME}
          width={BUTTON_WIDTH.FULL}
          route={`/${MOBILE}/${DASHBOARD_ROUTE}`}
        />
      </div>
    </div>
  );
};

Confirmation.propTypes = {};

export default Confirmation;
