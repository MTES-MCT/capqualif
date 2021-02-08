import React from 'react';
import Button from './Button';
import '../../../sass/main.scss';

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
