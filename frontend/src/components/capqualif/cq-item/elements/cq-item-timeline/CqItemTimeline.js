import React, { Fragment } from 'react';
import PropTypes from 'prop-types';

import './CqItemTimeline.scss';

const CqItemTimeline = ({ dates }) => {
  const alertText = '23 jours restants';

  return (
    <Fragment>
      {/* TO DO : add a check to display alert */}
      {/* <div className="rf-grid-row">
        <div className="cq-item__timeline-alert">{alertText}</div>
      </div> */}
      <div className="cq-item__timeline">
        <div>
          {dates.delivranceDate ||
            dates.debutApplicationDate ||
            dates.acquisitionDate}
        </div>
        <div className="timeline-graphic">
          <div className="line"></div>
          <div className="cursor"></div>
        </div>
        <div>{dates.expirationDate}</div>
      </div>
    </Fragment>
  );
};

CqItemTimeline.propTypes = {
  date: PropTypes.array.isRequired,
};

export default CqItemTimeline;
