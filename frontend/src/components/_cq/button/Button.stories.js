import React from 'react';
import { text } from '@storybook/addon-knobs';
import Button from './Button';
import '../../../sass/main.scss';
import '../../../app/App.scss';

export default {
  title: 'Button',
  component: Button,
};

const Template = (args) => <Button {...args} />;

export const Success = Template.bind({});
Success.args = {
  variantColor: 'cq-btn-success',
  label: 'Success',
};

export const Danger = Template.bind({});
Danger.args = {
  variantColor: 'cq-btn-danger',
  label: 'Danger',
};

// export const Success = () => <Button variantColor="cq-btn-success">Success</Button>;
// export const Danger = () => <Button variantColor="cq-btn-danger">Danger</Button>;

// export const Knobs = () => {
//   <Button>{text('Label', 'Bouton Label')}</Button>;
// };
