import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';

import { getAllTitles } from '../../../../core-logic/features/catalog/titles/titlesThunks';

import './NewTitleChoice.scss';

import TitleCard from '../../../elements/cards/title-card/TitleCard';

const NewTitleChoice = () => {
    
    const dispatch = useDispatch();
    const allTitles = useSelector(state => state.titles.allTitles);

    useEffect(() => {
        dispatch(getAllTitles());
      }, [dispatch]
    );

    return (
        <div id="new-title-choice">
            <h2>Quel titre souhaitez-vous demander ?</h2>
            <div id="suggested-titles">
                <h3>Titres suggérés</h3>
                <h4>Voici les titres que vous pouvez demander immédiatement.</h4>
                <div id="suggested-titles-container">
                    {/* {
                        allTitles.map(title => 
                            <Link to={`/new-title-application/details/`}>
                                <TitleCard key={title.id} title={title} titleType="fromCatalog" />
                            </Link>
                        )
                    } */}
        

                </div>
            </div>
            <div id="all-titles">
                <h3>Autres titres</h3>
                <h4>Et voici les titres pour lesquels vous devrez compléter votre dossier.</h4>
                <div id="other-titles-container">
                    <div className="card">
                        Lorem ipsum
                    </div>
                    <div className="card">
                        Lorem ipsum
                    </div>
                    <div className="card">
                        Lorem ipsum
                    </div>
                </div>
            </div>
        </div>
    );
};

export default NewTitleChoice;