var nestedProperty = require('nested-property');

export const findInArray = (array, property, value) => {
  return array.find((condition) => condition[property] === value);
};

/**
 *
 * @param {*} array
 * @param {*} property
 * @param {*} value
 * @returns if one of the params is not ok, returning -1 means the index cannot be found
 */
export const findIndex = (array, property, value) => {
  return array && property && value
    ? array.findIndex(
        (element) => nestedProperty.get(element, property) === value
      )
    : -1;
};

/**
 * Source: https://stackoverflow.com/a/49427583
 */
export const isEmpty = (object) => {
  return !Object.values(object).some((x) => x !== null && x !== '');
};

// ========= Convert date : start =======================

export const convertDateToEuropeanFormat = (dateSource) => {
  console.log(typeof dateSource);
  console.log(dateSource instanceof String);
  console.log(dateSource instanceof Date);
  if (dateSource && (isString(dateSource) || dateSource instanceof Date)) {
    console.log('trig');
    const date =
      typeof dateSource === 'string' || dateSource instanceof String
        ? convertToDate(dateSource)
        : dateSource;
    const monthValue = date.getMonth() + 1;
    let month;
    month = monthValue < 10 ? '0' + monthValue : monthValue;
    return date.getDate() + '.' + month + '.' + date.getFullYear();
  }
};

const convertToDate = (dateString) => {
  return new Date(dateString);
};

const isString = (dateSource) => {
  return typeof dateSource === 'string' || dateSource instanceof String;
};

// ========= Convert date : end =======================
