import React, { Fragment } from 'react';

import './SectionHead.scss';

const SectionHead = ({ title, subtitle, color }) => {
  return (
    <div id="section-head" className="rf-my-2w">
      <h3 style={{ color: color }}>{subtitle}</h3>
      <h1 style={{ color: color }}>{title}</h1>
    </div>
  );
};

export default SectionHead;
