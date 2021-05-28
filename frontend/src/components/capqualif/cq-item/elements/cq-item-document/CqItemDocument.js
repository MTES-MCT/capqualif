import React from 'react';
import PropTypes from 'prop-types';

import './CqItemDocument.scss';
import { STATUS_TITRE } from '../../../../../dictionnary/demandeDeTitre';

const CqItemDocument = ({ icon, status }) => {
  // TO DO : finish when more inofs
  // const whichIconToShow = (icon, status) => {
  //     if(status = STATUS_TITRE.VALID) {
  //         switch(icon) {
  //             case 'titre'
  //         }

  //     }
  // }

  return (
    <div id="cq-item-document">
      <span class="rf-fi-file-download-line"></span>
    </div>
  );
};

CqItemDocument.propTypes = {
  icon: PropTypes.string,
  status: PropTypes.string,
};

export default CqItemDocument;
