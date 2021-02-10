import React from 'react';
import PropTypes from 'prop-types';
import Button from '../../../button/Button';

const CqItemAction = ({ action }) => {
  return (
    <div className="cq-item-action rf-p-1w">
      <Button
        label={action.label}
        labelSize={action.labelSize}
        route={action.route}
        actionType={action.actionType}
      />
    </div>
  );
};

CqItemAction.propTypes = {
  action: PropTypes.object.isRequired,
};

export default CqItemAction;
