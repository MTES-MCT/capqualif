import React from 'react';
import { useSelector } from 'react-redux';
import store from '../../../redux/store';

import SectionHead from '../../elements/section/section-head/SectionHead';
import SectionFooter from '../../elements/section/section-footer/SectionFooter';
import Header from '../../elements/header/Header';

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
  const user = store.getState().sailors.sailorBasicData.sailorCivilData;
    const username = user.firstName + ' ' + user.lastName;
    const userSailorNumber = user.sailorNumber;
  

  return (
    
    <div id="demander-un-titre" className="page">
      <Header serviceName={'CapQualif'} adminName={'Direction des affaires maritimes'} username={username} userSailorNumber={userSailorNumber}/>
      

      <header class="rf-header no-shadow">
        <div class="rf-container">
        </div>
      </header>

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
