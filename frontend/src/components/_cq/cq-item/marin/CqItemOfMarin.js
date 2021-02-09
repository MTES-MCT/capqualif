import React, { Fragment } from 'react';
import PropTypes from 'prop-types';

import CqItemDocument from '../elements/cq-item-document/CqItemDocument';

import CqItemStatus from '../elements/cq-item-status/CqItemStatus';
import CqItemTimeline from '../elements/cq-item-timeline/CqItemTimeline';
import CqItemBase from '../elements/CqItemBase';

const CqItemOfMarin = ({ name, subtitle, dates, status, children }) => {
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

      // {dates && <CqItemTimeline dates={dates} />}
      // <CqItemStatus status={status} />
      // {/* {children} */}
      // <CqItemDocument />
      // {/* <CqItemDetails /> */}
      // </CqItemBase>
    />
  );
};

CqItemOfMarin.prototypes = {
  name: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
  dates: PropTypes.array.isRequired,
  status: PropTypes.string.isRequired,
};

export default CqItemOfMarin;
