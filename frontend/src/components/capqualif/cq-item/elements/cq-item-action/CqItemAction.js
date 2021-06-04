import React from 'react';
import PropTypes from 'prop-types';
import ButtonLink from '../../../buttons/ButtonLink';

const CqItemAction = ({ action }) => {
  return (
    <div className="cq-helpers-full-width cq-item-action fr-p-1w">
      <ButtonLink
        label={action.label}
        labelSize={action.labelSize}
        width={action.width}
        route={action.route}
      />
    </div>
  );
};

CqItemAction.propTypes = {
  action: PropTypes.object.isRequired,
};

export default CqItemAction;
