import React from 'react';


const TitleCard = ({ title, titleType }) => {
    return (
        <div className="card">
            <p className="title">{title.titleName}</p>
            {titleType !== 'fromCatalog' &&
                <p>Expire le {title.expirationDate}</p>
            }
        </div>
    );
};

export default TitleCard;