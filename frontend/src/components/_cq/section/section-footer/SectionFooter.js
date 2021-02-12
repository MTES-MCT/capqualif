import React from 'react';
import { Link, useHistory } from 'react-router-dom';
import { ACTION_TYPES } from '../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../dictionnary/saas/variables';
import Button from '../../button/Button';

import './SectionFooter.scss';

const SectionFooter = ({ possibleActions }) => {
  let history = useHistory();

  const currentTitle = 'Certificat de Matelot Pont';

  return (
    <div id="section-footer">
      <a className="rf-link" onClick={history.goBack}>
        <span class="rf-fi-arrow-left-s-line">Recommencer</span>
      </a>
      <p>
        Vous souhaitez demander un <br />
        <span className="cq-helpers__dynamic-text bold">{currentTitle}</span>
      </p>
      <div>
        {possibleActions.map((action) => (
          <div className="actions-wrapper rf-mx-1w">
            <Button
              route={action.nextPageLink}
              label={action.label}
              labelSize={FONT_SIZES.SMALL}
              actionType={ACTION_TYPES.SECONDARY}
              disabled={action.disabled}
            />
          </div>
        ))}
      </div>
    </div>
  );
};

export default SectionFooter;
