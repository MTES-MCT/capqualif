export const findInArray = (array, property, value) => {
  return array.find((condition) => condition[property] === value);
};

// ========= Convert date : start =======================

export const convertToEuropeanFormat = (dateSource) => {
  const date =
    typeof dateSource === 'string' || dateSource instanceof String
      ? convertToDate(dateSource)
      : dateSource;
  const monthValue = date.getMonth() + 1;
  let month;
  month = monthValue < 10 ? '0' + monthValue : monthValue;
  return date.getDate() + '.' + month + '.' + date.getFullYear();
};

const convertToDate = (dateString) => {
  return new Date(dateString);
};

// ========= Convert date : end =======================
