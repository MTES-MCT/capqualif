import React from 'react';
import SideNav from './SideNav';
import '../../../../sass/main.scss';
import '../../../../app/App.scss';

export default {
  title: 'Side Nav',
  component: SideNav,
};

const Template = (args) => <SideNav {...args} />;

export const Test = Template.bind({});
Test.args = {};
