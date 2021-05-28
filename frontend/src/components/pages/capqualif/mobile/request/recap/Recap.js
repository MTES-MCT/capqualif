import React, { Fragment } from 'react';
import PropTypes from 'prop-types';

import './Recap.module.scss';
import Step from '../../../../../capqualif/step/Step';
import { STEPS, VALIDITY } from '../../../../../../dictionnary/demandeDeTitre';
import CqItemHeader from '../../../../../capqualif/cq-item/elements/cq-item-header/CqItemHeader';

const Recap = (props) => {
  return (
    <Fragment>
      <Step label={STEPS.CONFIRM} />
      <div className="fr-mt-2w fr-px-2w">
        <CqItemHeader
          subtitle={'Appui · Pont'}
          name={'Certificat de Matelot Pont'}
        />
        <p>Aucune restriction</p>
        <div>
          <div>
            <p>{VALIDITY.DURATION}</p>
          </div>
          <div>{VALIDITY.START_DATE}</div>
          <div>{VALIDITY.END_DATE}</div>
          <div></div>
        </div>
      </div>
    </Fragment>
  );
};

Recap.propTypes = {};

export default Recap;
