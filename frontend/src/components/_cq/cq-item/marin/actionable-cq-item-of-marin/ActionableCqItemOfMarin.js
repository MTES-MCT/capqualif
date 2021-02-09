import React from 'react';
import PropTypes from 'prop-types';
import CqItemOfMarin from '../CqItemOfMarin';
import CqItemAction from '../../elements/cq-item-action/CqItemAction';
import {
  BUTTON_LABELS,
  ACTION_TYPES,
} from '../../../../../dictionnary/demandeDeTitre';

import { FONT_SIZES } from '../../../../../dictionnary/saas/variables';

const ActionableCqItemOfMarin = ({
  name,
  subtitle,
  dates,
  status,
  shouldShowAction,
}) => {
  return (
    <CqItemOfMarin
      name={name}
      subtitle={subtitle}
      dates={dates}
      status={status}
    >
      {shouldShowAction && (
        <CqItemAction
          label={BUTTON_LABELS.ADD_DOCUMENT}
          labelSize={FONT_SIZES.VERY_SMALL}
          route=""
          actionType={ACTION_TYPES.SECONDARY}
        />
      )}
    </CqItemOfMarin>
  );
};

ActionableCqItemOfMarin.propTypes = {
  name: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
  dates: PropTypes.array.isRequired,
  status: PropTypes.string.isRequired,
};

export default ActionableCqItemOfMarin;
