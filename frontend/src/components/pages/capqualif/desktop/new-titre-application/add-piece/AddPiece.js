import React from 'react';

import { ACTION_TYPES } from '../../../../../../dictionnary/demandeDeTitre';
import { FONT_SIZES } from '../../../../../../dictionnary/saas/variables';
import Button from '../../../../../capqualif/button/Button';
import './AddPiece.scss';

const AddPiece = () => {
  const id = '1';
  const slug = 'certificat-de-matelot-pont';

  return (
    <div id="modal-container">
      <h2>Importer mon document</h2>
      <div id="square">
        <div id="content-container">
          <p>
            <label for="bordered" class="btn">
              Importer depuis mon ordinateur
            </label>
            <input type="file" id="bordered" name="myfile" />
          </p>
          <p>ou</p>
          <p>Glisser le document ici</p>
        </div>
      </div>
      <div id="button-container">
        <Button
          label="Ajouter la pièce"
          labelSize={FONT_SIZES.NORMAL}
          route="/recap-success"
          actionType={ACTION_TYPES.PRIMARY}
        />
      </div>
    </div>
  );
};

export default AddPiece;
