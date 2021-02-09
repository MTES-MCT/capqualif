import React from 'react';
import PropTypes from 'prop-types';

import {
  ACTION_TYPES,
  BUTTON_LABELS,
  STATUS_APTITUDE_MEDICALE,
  STATUS_TITRE,
} from '../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../dictionnary/saas/variables';
import CqItemAction from '../elements/cq-item-action/CqItemAction';
import CqItemDocument from '../elements/cq-item-document/CqItemDocument';

import CqItemStatus from '../elements/cq-item-status/CqItemStatus';
import CqItemTimeline from '../elements/cq-item-timeline/CqItemTimeline';
import CqItemBase from '../elements/CqItemBase';

const CqItemOfMarin = ({ name, subtitle, dates, status, children }) => {
  return (
    <CqItemBase subtitle={subtitle} name={name}>
      {dates && <CqItemTimeline dates={dates} />}
      <CqItemStatus status={status} />
      {children}
      {/* {status !== STATUS_TITRE.VALID &&
        status !== STATUS_APTITUDE_MEDICALE.APTE && (
          <CqItemAction
            label={BUTTON_LABELS.ADD_DOCUMENT}
            labelSize={FONT_SIZES.VERY_SMALL}
            route=""
            actionType={ACTION_TYPES.SECONDARY}
          />
        )} */}
      <CqItemDocument />
      {/* <CqItemDetails /> */}
    </CqItemBase>
  );
};

CqItemOfMarin.prototypes = {
  name: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
  dates: PropTypes.array.isRequired,
  status: PropTypes.string.isRequired,
};

export default CqItemOfMarin;
