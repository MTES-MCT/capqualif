import React from 'react';
import { useSelector } from 'react-redux';

import SectionHead from '../../elements/section/section-head/SectionHead';
import SectionFooter from '../../elements/section/section-footer/SectionFooter';

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
    <div>
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
