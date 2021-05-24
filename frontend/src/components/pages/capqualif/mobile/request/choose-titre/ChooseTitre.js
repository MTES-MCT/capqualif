import React from 'react';
import PropTypes from 'prop-types';
import { Fragment } from 'react';

import styles from './ChooseTitre.module.scss';

const ChooseTitre = (props) => {
  return (
    <Fragment>
      <div>
        <h2 className={styles['cq-choose-titre-h2']}>
          Demander un nouveau titre
        </h2>
        x
      </div>
      <div>
        <h3>Choix du titre</h3>
        <div>Case titre</div>
        <div>Case titre</div>
        <p>CapQualif bêta ne propose que ces deux titres pour le moment.</p>
      </div>
    </Fragment>
  );
};

ChooseTitre.propTypes = {};

export default ChooseTitre;
