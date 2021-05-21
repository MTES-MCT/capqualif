export const findInArray = (array, property, value) => {
  return array.find((condition) => condition[property] === value);
};
