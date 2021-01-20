import { configure, addDecorator } from '@storybook/react';
import StoryRouter from 'storybook-react-router';
import { withKnobs } from '@storybook/addon-knobs';
// import '!style-loader!css-loader!sass-loader!./_gouvfr.scss';

addDecorator(StoryRouter());
addDecorator(withKnobs());

export const parameters = {
  actions: { argTypesRegex: '^on[A-Z].*' },
};
