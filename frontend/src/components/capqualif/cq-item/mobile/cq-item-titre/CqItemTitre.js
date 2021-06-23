import React, { useEffect, useState } from 'react';
import PropTypes from 'prop-types';

import CqItemBase from '../../elements/CqItemBase';
import CqItemStatus from '../../elements/cq-item-status/CqItemStatus';
import CqItemTitreDetails from './cq-item-titre-details/CqItemTitreDetails';
import CqItemTitreDate from './cq-item-titre-date/CqItemTitreDate';
import ButtonAction from '../../../buttons/button-action/ButtonAction';
import { useDispatch, useSelector } from 'react-redux';
import { setCanBeSent } from '../../../../../redux/capqualif/mobile/requests/requestsSlice';
import { checkIfRequestCanBeSent } from '../../../../pages/capqualif/mobile/request/recap/checker';
import { findIndex } from '../../../../../app/utils';

const CqItemTitre = ({
  id,
  name,
  subtitle,
  status,
  expirationDate,
  details,
  action,
}) => {
  /**
   * Boilerplate
   */
  const dispatch = useDispatch();

  /**
   * Let's select data from global state (redux)
   */
  const titres = useSelector((state) => state.instructions.possibleTitres);
  const possibleRequests = useSelector(
    (state) => state.requests.possibleRequests
  );
  const possibleTitres = useSelector(
    (state) => state.instructions.possibleTitres
  );

  /**
   * Let's find the titre that the marin is requesting in all possible titres
   * to display it in the UI!
   */

  const titre = titres[findIndex(titres, 'informations.id', '1')];

  /**
   * Let's check if the request can be sent
   */
  useEffect(() => {
    if (titre && !isPossibleRequestsEmpty(possibleRequests)) {
      const canBeSent = checkIfRequestCanBeSent(
        titre.instruction.marinIdentity.identityMarkers,
        titre.instruction.results.allConditionsGroups
      );
      console.log('canRequestBeSent', canBeSent);
      dispatch(
        setCanBeSent({
          titreId: id,
          canRequestBeSent: canBeSent,
        })
      );
    }
  }, [possibleTitres]);

  const isPossibleRequestsEmpty = (possibleRequests) => {
    return possibleRequests.length === 0 ? true : false;
  };

  return (
    <CqItemBase
      subtitle={subtitle}
      name={name}
      status={status && <CqItemStatus status={status} />}
      date={expirationDate && <CqItemTitreDate date={expirationDate} />}
      details={
        details && (
          <CqItemTitreDetails
            titreId={id}
            details={details}
            action={
              action && (
                <ButtonAction
                  label={action.label}
                  labelSize={action.labelSize}
                  width={action.width}
                  actionOnClick={action.onClick}
                  isDisabled={
                    !possibleRequests[
                      findIndex(possibleRequests, 'requestedTitreId', id)
                    ].canBeSent
                  }
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
