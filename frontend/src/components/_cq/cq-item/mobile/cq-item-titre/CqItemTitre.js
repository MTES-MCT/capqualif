import React from 'react';
import PropTypes from 'prop-types';

import style from './CqItemTitre.module.scss';
import CqItemBase from '../../elements/CqItemBase';
import CqItemStatus from '../../elements/cq-item-status/CqItemStatus';
import CqItemAction from '../../elements/cq-item-action/CqItemAction';
import CqItemTitreDetails from './cq-item-titre-details/CqItemTitreDetails';

const CqItemTitre = ({ name, subtitle, status, action, details }) => {
  return (
    <CqItemBase
      subtitle={subtitle}
      name={name}
      status={<CqItemStatus status={status} />}
      details={
        <CqItemTitreDetails
          details={details}
          action={action && <CqItemAction action={action} />}
        />
      }
    />
  );
};

CqItemTitre.propTypes = {
  name: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
  status: PropTypes.string.isRequired,
  action: PropTypes.object.isRequired,
};

export default CqItemTitre;
