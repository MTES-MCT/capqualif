import React from 'react';
import PropTypes from 'prop-types';
import Button from '../../../button/Button';
import {
  ACTION_TYPES,
  BUTTON_LABELS,
} from '../../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../../dictionnary/saas/variables';

const CqItemAction = ({ label, labelSize, route, actionType }) => {
  return (
    <div className="cq-item-action rf-p-1w">
      <Button
        label={label}
        labelSize={labelSize}
        route={route}
        actionType={actionType}
      />
    </div>
  );
};

CqItemAction.propTypes = {};

export default CqItemAction;
