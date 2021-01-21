import React from 'react';

import './Dashboard.scss';

import SideNav from '../../../components/_cq/navs/side-nav/SideNav';
import SubHeader from '../../_cq/subheader/SubHeader';
import HorizontalNav from '../../_cq/navs/horizontal-nav/HorizontalNav';
import DashboardContent from './dashboard-content/DashboardContent';

const Dashboard = () => {
  return (
    <div id="cq-dashboard">
      <SubHeader />
      <HorizontalNav />
      <div className="rf-container">
        <div className="rf-grid-row">
          <div className="rf-col-3">
            <SideNav />
          </div>
          <div className="rf-col-9 cq-right-col-9">
            <DashboardContent />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
