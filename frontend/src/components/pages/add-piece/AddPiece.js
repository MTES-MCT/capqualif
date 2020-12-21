import React from 'react';
import { useSelector } from 'react-redux';
import store from '../../../redux/store';

import SectionHead from '../../_cq/section/section-head/SectionHead';
import SectionFooter from '../../_cq/section/section-footer/SectionFooter';
import Header from '../../_rf/header/Header';

const AddPiece = () => {
  const currentTitle = useSelector((state) => state.titles.currentTitle);

  const possibleActions = [
    {
      label: 'Enregistrer le dossier',
      nextPageLink: '',
    },
    {
      label: 'Continuer',
      nextPageLink: '',
    },
  ];
    

  return (
    
    <div id="ajouter-piece" className="page">
     

      <SectionHead
        title={currentTitle.titleName}
        subtitle="Compléter votre dossier"
      />
      <div>
        Pour finaliser la demande du titre, il vous manque cette pièce : XXX.
      </div>
      <SectionFooter possibleActions={possibleActions} />


    </div>
  );
};

export default AddPiece;
