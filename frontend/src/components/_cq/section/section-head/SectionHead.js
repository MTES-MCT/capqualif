import React, { Fragment } from 'react';

const SectionHead = ({ title, subtitle }) => {
    return (
        <Fragment>
            <h3>{ subtitle }</h3>
            <h1>{ title }</h1>
        </Fragment>
    );
};

export default SectionHead;