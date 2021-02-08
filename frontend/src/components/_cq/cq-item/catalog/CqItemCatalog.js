import React from 'react';
import PropTypes from 'prop-types';

import CqItemBase from '../elements/CqItemBase';

const CqItemCatalog = ({ name, subtitle }) => {
  return (
    <div>
      <CqItemBase subtitle={subtitle} name={name}></CqItemBase>
    </div>
  );
};

CqItemCatalog.propTypes = {};

export default CqItemCatalog;
