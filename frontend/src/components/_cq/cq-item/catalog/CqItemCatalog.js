import React, { useState } from 'react';
import PropTypes from 'prop-types';

import CqItemBase from '../elements/CqItemBase';
import CqItemDetails from '../elements/cq-item-details/CqItemDetails';

const CqItemCatalog = ({ name, subtitle, details }) => {
  return (
    <div>
      <CqItemBase
        subtitle={subtitle}
        name={name}
        detailsComponent={<CqItemDetails details={details} />}
      />
    </div>
  );
};

CqItemCatalog.propTypes = {
  name: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
};

export default CqItemCatalog;
