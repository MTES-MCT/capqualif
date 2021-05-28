import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';

import './sass/style/core-sde.scss'; // design system
import './sass/style/utilities-sde.scss'; // design system
import './index.scss'; // CapQualif, css normalizations
import './sass/style/cq-helpers.scss'; // CapQualif

import App from './app/App';

ReactDOM.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>,
  document.getElementById('root')
);
