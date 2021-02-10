import React from 'react';
import PropTypes from 'prop-types';

import CqItemBase from '../elements/CqItemBase';
import CqItemDetails from '../elements/cq-item-details/CqItemDetails';
import CqItemAction from '../elements/cq-item-action/CqItemAction';

const CqItemCatalog = ({ name, subtitle, details, newTitreAction }) => {
  return (
    <div>
      <CqItemBase
        subtitle={subtitle}
        name={name}
        details={
          <CqItemDetails
            details={details}
            action={newTitreAction && <CqItemAction action={newTitreAction} />}
          />
        }
      />
    </div>
  );
};

CqItemCatalog.propTypes = {
  name: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
  newTitreAction: PropTypes.element.isRequired,
};

export default CqItemCatalog;
