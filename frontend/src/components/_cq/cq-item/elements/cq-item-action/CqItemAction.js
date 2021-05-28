import React from 'react';
import PropTypes from 'prop-types';
import Button from '../../../button/Button';

const CqItemAction = ({ action }) => {
  return (
    <div className="cq-helpers-full-width cq-item-action fr-p-1w">
      <Button
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
