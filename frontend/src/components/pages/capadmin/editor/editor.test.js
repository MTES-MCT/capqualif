import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

import '@testing-library/jest-dom/extend-expect';
import { render, screen, fireEvent, cleanup } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import { shallow } from 'enzyme';
import Editor from './Editor';

import { generateConditions } from './logic';
import conditionsMatelotPont from './testConditionsMatelotPont.json';

const titreName = 'Certificat de Matelot Pont';

const conditionsWithRightName = {
  name: titreName,
};

configure({ adapter: new Adapter() });

describe('Conditions generation', () => {
  it('should return the right final conditions', () => {
    expect(generateConditions(titreName)).toStrictEqual(conditionsMatelotPont);
  });

  it('should return the right name', () => {
    render(<Editor />);

    userEvent.type(screen.getByLabelText('name-input'), titreName);
    expect(screen.getByLabelText('name-input')).toHaveValue(titreName);
  });

  it('should return the right name bis', () => {
    // const wrapper = shallow(<Editor />);
    // const resultDisplayer = wrapper.find('ResultDisplayer');
    // const input = wrapper.find('[name="name"]');
    const input = render(<Editor />).getByLabelText('name-input');
    fireEvent.change(input, { target: { value: titreName } });
    expect(input.value).toBe(titreName);
  });

  it('should change result well', () => {
    // const wrapper = shallow(<Editor />);
    // const resultDisplayer = wrapper.find('ResultDisplayer');
    // const input = wrapper.find('[name="name"]');
    render(<Editor />);
    const input = screen.getByLabelText('name-input');
    fireEvent.change(input, { target: { value: titreName } });
    const submit = screen.getByTestId('submit-input');
    fireEvent.click(submit);
    const result = screen.getByLabelText('result');
    expect(result).toHaveTextContent(`"name":"${titreName}","conditions":""`);
  });
});
