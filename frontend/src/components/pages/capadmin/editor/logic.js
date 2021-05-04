import conditionsMatelotPont from './testConditionsMatelotPont.json';

export const generateConditions = (data) => {
  const conditions = {};
  conditions.name = data.name;
  return conditions;
};
