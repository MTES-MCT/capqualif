import React, { Fragment } from 'react';

const Header = () => {
    return (
        <Fragment>
            <header className="rf-header">
                <div className="rf-container">
                    <div className="rf-header__body">
                        <div className="rf-header__brand">
                            <a className="rf-logo" href="#" title="République française">
                                <span className="rf-logo__title">République<br/>française</span>
                            </a>
                        </div>
                        <div className="rf-header__navbar">
                            <div className="rf-service">
                                <a className="rf-service__title" href="#" title="Nom du service">
                                    Nom du service
                                </a>
                                <p className="rf-service__tagline">baseline - précisions sur l‘organisation</p>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
        </Fragment>
    );
};

export default Header;

