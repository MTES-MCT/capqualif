import React, { useState } from 'react';
import { unwrapResult } from '@reduxjs/toolkit';
import { useDispatch } from 'react-redux';
import { useHistory } from 'react-router-dom';
import { MOBILE, DASHBOARD_ROUTE } from '../../../../../app/routesDictionnary';

import styles from './Login.module.scss';

import { ReactComponent as CapQualifLogo } from '../../../../../resources/img/logo/capqualif-logo.svg';
import HeaderBrand from '../../../../system-design-etat/header-brand/HeaderBrand';
import { getMarinBasicDataByNumeroDeMarin } from '../../../../../redux/capqualif/desktop/features/marinData/marinsSlice';
import { LOGIN } from '../../../../../dictionnary/demandeDeTitre';
import ButtonSubmit from '../../../../capqualif/buttons/button-submit/ButtonSubmit';

const Login = () => {
  const [numeroDeMarin, setNumeroDeMarin] = useState('0');
  const dispatch = useDispatch();
  const history = useHistory();

  const handleSubmit = (event) => {
    event.preventDefault();
    dispatch(getMarinBasicDataByNumeroDeMarin(numeroDeMarin))
      .then(unwrapResult)
      .then(() => {
        history.push(`${MOBILE}/${DASHBOARD_ROUTE}`);
      })
      .catch(() => {
        history.push('/error');
      });
  };

  const handleChange = (event) => {
    setNumeroDeMarin(event.target.value);
  };

  return (
    <div className={`${styles['login-page']} fr-m-2w`}>
      <HeaderBrand administrationLabel={'Ministère de la mer'} />
      <div className={`${styles['form-container']} fr-pt-3w`}>
        <CapQualifLogo />
        <div className={`${styles['welcome']} fr-mt-3w`}>
          {LOGIN.WELCOME_TEXT}
        </div>
        <form
          onSubmit={(event) => handleSubmit(event)}
          className={`${styles['form']} fr-mt-3w`}
        >
          <label className={`${styles['fr-label']}`} for="text-input-text">
            <span className={`${styles['mandatory-input']}`}>*</span> {LOGIN.ID}
          </label>
          <input
            className={`${styles['fr-input']} fr-mb-4w`}
            type="text"
            id="text-input-text"
            name="text-input-text"
            // name="sailor-id"
            placeholder="Exemple&nbsp;: 19780030"
            onChange={(event) => handleChange(event)}
          />
          <label className={`${styles['fr-label']}`} for="text-input-text">
            <span className={`${styles['mandatory-input']}`}>*</span>{' '}
            {LOGIN.PASSWORD}
          </label>
          <input
            className={`${styles['fr-input']} fr-mb-2w`}
            type="text"
            id="text-input-text"
            name="text-input-text"
            // name="sailor-id"
            placeholder="Exemple&nbsp;: 19780030"
            onChange={(event) => handleChange(event)}
          />
          <ButtonSubmit label={LOGIN.SIGN_IN} marginsInRem={{ top: 1 }} />
        </form>
      </div>
    </div>
    // <div id="sign-in" className="page rf-container">
    //   <div class="sign-in__container">
    //     <div class="sign-in__header">
    //       <div class="logo_gouvfr">
    //         <HeaderBrand
    //           administrationLabel1={'Ministère de la mer'}

    //         />
    //       </div>
    //     </div>
    //     <div class="sign-in__title">CapQualif</div>
    //     <div class="sign-in__welcome">
    //       <div class="welcome">
    //         Bienvenue sur CapQualif, notre nouvel espace pour faire vos demandes
    //         de titres.
    //       </div>
    //     </div>
    //     <div class="sign-in__form">
    //       <form onSubmit={(event) => handleSubmit(event)}>
    //         <label class="rf-label" for="text-input-text">
    //           Numéro d'identification
    //         </label>
    //         <input
    //           class="rf-input"
    //           type="text"
    //           name="sailor-id"
    //           placeholder="Exemple : 19780030"
    //           onChange={(event) => handleChange(event)}
    //         />

    //         <button type="submit" class="rf-btn" title="Se connecter">
    //           Se connecter
    //         </button>
    //       </form>
    //     </div>
    //   </div>
    // </div>
  );
};

export default Login;
