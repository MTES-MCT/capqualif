import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';

<<<<<<< HEAD:frontend/src/components/pages/new-title-application/title-details/TitleDetails.js
import { getTitle } from '../../../../core-logic/features/catalog/titles/titlesThunks';
=======
import { getTitle } from '../../../../redux/features/titlesCatalog/titlesSlice';
>>>>>>> front-dev:frontend/src/components/pages/new-title-application/title-details/TitleDetails.js

import './TitleDetails.scss';

import { NEW_TITLE_APPLICATION_RECAP_PATH } from '../../../../app/pathes';

import SectionHead from '../../../elements/section/section-head/SectionHead';
import SectionFooter from '../../../elements/section/section-footer/SectionFooter';

const TitleDetails = () => {
  const dispatch = useDispatch();
  const currentTitle = useSelector((state) => state.titles.currentTitle);

  useEffect(() => {
    dispatch(getTitle('1'));
  }, []);

  const possibleActions = [
    {
      label: 'Continuer',
      nextPageLink: NEW_TITLE_APPLICATION_RECAP_PATH,
    },
  ];

  return (
    <div id="title-details">
      <SectionHead
        title={currentTitle.titleName}
        subtitle="Demande d'un nouveau titre"
      />
      <div>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
        veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
        commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
        velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
        occaecat cupidatat non proident, sunt in culpa qui officia deserunt
        mollit anim id est laborum.
      </div>
      <SectionFooter possibleActions={possibleActions} />
    </div>
  );
};

export default TitleDetails;
