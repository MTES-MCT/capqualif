import React from 'react';
import CqItemStatus from './CqItemStatus';
import '../../../../sass/main.scss';

export default {
  title: 'Cq Item Status',
  component: CqItemStatus,
};

const Template = (args) => <CqItemStatus {...args} />;

export const InProgress = Template.bind({});
InProgress.args = {
  status: 'en cours',
};
