import {
  CONDITION,
  STATUS_TITRE,
} from '../../../../../../dictionnary/demandeDeTitre';

export const checkIfRequestCanBeSent = (
  marinIdentityMarkers,
  conditionsGroups
) => {
  console.log(
    'checkIdentityMarkers',
    checkIdentityMarkers(marinIdentityMarkers)
  );
  console.log('checkConditions', checkConditions(conditionsGroups));
};

const checkIdentityMarkers = (marinIdentityMarkers) => {
  const photo =
    marinIdentityMarkers.photoStatus === CONDITION.STATUS.NOT_VALID
      ? false
      : true;
  const signature =
    marinIdentityMarkers.signature === CONDITION.STATUS.NOT_VALID
      ? false
      : true;
  const results = [];
  results.push(photo);
  results.push(signature);
  return results.includes(false) ? false : true;
};

const checkConditions = (conditionsGroups) => {
  const results = [];
  conditionsGroups.forEach((group) => {
    group.conditions.forEach((condition) => {
      const status =
        condition.status === CONDITION.STATUS.NOT_VALID ? false : true;
      results.push(status);
    });
  });
  return results.includes(false) ? false : true;
};
