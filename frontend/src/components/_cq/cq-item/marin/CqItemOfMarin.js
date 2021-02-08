import React from 'react';
import CqItemAction from '../elements/cq-item-action/CqItemAction';
import CqItemDocument from '../elements/cq-item-document/CqItemDocument';

import CqItemStatus from '../elements/cq-item-status/CqItemStatus';
import CqItemTimeline from '../elements/cq-item-timeline/CqItemTimeline';
import CqItemBase from '../elements/CqItemBase';

const CqItemOfMarin = ({ name, subtitle, dates, status }) => {
  return (
    <CqItemBase subtitle={subtitle} itemName={name}>
      <CqItemTimeline dates={dates} />
      <CqItemStatus status={status} />
      <CqItemAction />
      <CqItemDocument />
    </CqItemBase>
  );
};

export default CqItemOfMarin;
