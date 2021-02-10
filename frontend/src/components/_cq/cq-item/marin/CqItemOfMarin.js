import React, { Fragment } from 'react';
import PropTypes from 'prop-types';

import CqItemDocument from '../elements/cq-item-document/CqItemDocument';

import CqItemStatus from '../elements/cq-item-status/CqItemStatus';
import CqItemTimeline from '../elements/cq-item-timeline/CqItemTimeline';
import CqItemBase from '../elements/CqItemBase';
import CqItemAction from '../elements/cq-item-action/CqItemAction';

const CqItemOfMarin = ({ name, subtitle, dates, status, action }) => {
  return (
    <CqItemBase
      subtitle={subtitle}
      name={name}
      infos={
        <Fragment>
          {dates && <CqItemTimeline dates={dates} />}
          <CqItemStatus status={status} />
          <CqItemDocument />
        </Fragment>
      }
      action={action && <CqItemAction action={action} />}
    />
  );
};

CqItemOfMarin.prototypes = {
  name: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
  dates: PropTypes.array.isRequired,
  status: PropTypes.string.isRequired,
  action: PropTypes.object.isRequired,
};

export default CqItemOfMarin;
