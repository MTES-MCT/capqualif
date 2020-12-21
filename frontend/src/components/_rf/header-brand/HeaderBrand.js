import React from 'react';
//import { Header} from '@gouvfr/header/src/scripts';

const HeaderBrand = ({administrationLabel1,administrationLabel2}) => {
  return (
    <div className="rf-header__brand">
    <a className="rf-logo" href="#" title="République française">
      <span className="rf-logo__title">
        {administrationLabel1} <br/> {administrationLabel2}
      </span>
    </a>
  </div>
  );
};

export default HeaderBrand;
