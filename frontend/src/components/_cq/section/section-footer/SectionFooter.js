import React from 'react';
import { Link, useHistory } from 'react-router-dom';

import './SectionFooter.scss';

const SectionFooter = ({ possibleActions }) => {
  let history = useHistory();

  return (
    <div id="section-footer">
      <button onClick={history.goBack}>&larr;&nbsp;Retour</button>
      <ul>
        <li>4 Pièces valides</li>
        <li>1 Pièce manquante à fournir</li>
      </ul>
      {possibleActions.map((action) => (
        <Link to={action.nextPageLink}>{action.label}</Link>
      ))}
    </div>
  );
};

export default SectionFooter;
