import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import { getTitle } from '../../../../features/titlesCatalog/titlesSlice';

import './TitleDetails.scss';

import SectionHead from '../../../elements/section-head/SectionHead';

const TitleDetails = () => {
  const dispatch = useDispatch();
  const currentTitle = useSelector((state) => state.titles.currentTitle);

  useEffect(() => {
    dispatch(getTitle('1'));
  }, []);

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

      {/* <h2>Brevet de Matelot Pont</h2> */}
      {/* <h2>Brevet de { currentTitle.titleName }</h2> */}
      {/* <div id="title" className="card">
                <div id="prerogatives" className="paragraph">
                    <p>Ce titre permet d'exercer les fonctions :</p>ls
                    <ul>
                        <li>Appui pont</li>
                        <li>Confection de banana split</li> */}
      {/* { currentTitle.prerogatives.map(prerogative => (
                            <li>{prerogative}</li>
                        )) 
                        } */}
      {/* </ul>
                </div>
                <div id="criteria">
                    <p>Pour l'obtenir, vous devez remplir les conditions suivantes :</p>
                    <ul>
                        <li>CFBS</li>
                        <li>Aptitude médicale</li> */}
      {/* { currentTitle.criteria.map(prerogative => (
                            <li>{prerogative}</li>
                        )) 
                        } */}
      {/* </ul>
                </div>
            </div> */}
    </div>
  );
};

export default TitleDetails;
