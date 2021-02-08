import React from 'react';
import { useSelector } from 'react-redux';

import SectionHead from '../../_cq/section/section-head/SectionHead';
import SectionFooter from '../../_cq/section/section-footer/SectionFooter';

const AddPiece = () => {
  const currentTitre = useSelector((state) => state.titresReducer.currentTitre);

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
        title={currentTitre.titreName}
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
