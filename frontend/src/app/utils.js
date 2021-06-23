var nestedProperty = require('nested-property');

export const findInArray = (array, property, value) => {
  return array.find((condition) => condition[property] === value);
};

export const findIndex = (array, property, value) => {
  if (property instanceof Array) {
    console.log(resolve('informations.id'));
  }
  return array.findIndex(
    (element) => nestedProperty.get(element, property) === value
  );
};

function resolve(path, obj) {
  return path.split('.').reduce(function (prev, curr) {
    return prev ? prev[curr] : null;
  }, obj);
}

// ========= Convert date : start =======================

export const convertDateToEuropeanFormat = (dateSource) => {
  if (
    dateSource &&
    (dateSource instanceof String || dateSource instanceof Date)
  ) {
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

// ========= Convert date : end =======================
