import React from 'react';
import PropTypes from 'prop-types';
import Button from '../../../button/Button';
import {
  ACTION_TYPE,
  BUTTON_LABELS,
} from '../../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../../dictionnary/saas/variables';

const CqItemAction = ({ label, labelSize, route, actionType }) => {
  return (
    <div className="cq-item-action rf-p-1w">
      <Button
        label={BUTTON_LABELS.ADD_DOCUMENT}
        labelSize={FONT_SIZES.VERY_SMALL}
        route=""
        actionType={ACTION_TYPE.SECONDARY}
      />
    </div>
  );
};

CqItemAction.propTypes = {};

export default CqItemAction;
