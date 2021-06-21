import React from 'react';
import PropTypes from 'prop-types';

import style from './CqItemTitre.module.scss';
import CqItemBase from '../../elements/CqItemBase';
import CqItemStatus from '../../elements/cq-item-status/CqItemStatus';
import CqItemAction from '../../elements/cq-item-action/CqItemAction';
import CqItemTitreDetails from './cq-item-titre-details/CqItemTitreDetails';
import CqItemTitreDate from './cq-item-titre-date/CqItemTitreDate';
import ButtonAction from '../../../buttons/button-action/ButtonAction';

const CqItemTitre = ({
  id,
  name,
  subtitle,
  status,
  expirationDate,
  details,
  action,
}) => {
  return (
    <CqItemBase
      subtitle={subtitle}
      name={name}
      status={status && <CqItemStatus status={status} />}
      date={expirationDate && <CqItemTitreDate date={expirationDate} />}
      details={
        details && (
          <CqItemTitreDetails
            details={details}
            // action={action && <CqItemAction action={action} />}
            action={
              action && (
                <ButtonAction
                  label={action.label}
                  labelSize={action.labelSize}
                  width={action.width}
                  actionOnClick={action.onClick}
                />
              )
            }
          />
        )
      }
    />
  );
};

CqItemTitre.propTypes = {
  id: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
  status: PropTypes.string,
  expirationDate: PropTypes.string,
  details: PropTypes.string,
  action: PropTypes.object,
};

export default CqItemTitre;
