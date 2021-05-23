import React from 'react';

import './HeaderBrand.scss';
import './logo.scss';

const HeaderBrand = ({ administrationLabel }) => {
  return (
    <p id="header-brand" class="fr-logo">
      {administrationLabel}
    </p>
  );
};

export default HeaderBrand;
