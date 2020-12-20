import React from 'react';
import { useSelector } from 'react-redux';
import store from '../../../redux/store';


const CQItem = ({level,type,itemName,timeline,startDate,endDate,status}) => {

    const topTitle = () => {
        console.log(level);
        if(!level || level === ""){
            return (type);
        } else {
            console.log("hello");
            return (level+" • "+type);
        }
    }

    const timelineElement = () => {
        if(timeline){
            return (
                <div class="cq-item__timeline">
                    <div class="start-date">{startDate}</div>
                    <div class="timeline-graphic">
                        <div class="line"></div>
                        <div class="cursor" ></div>
                    </div>
                    <div class="end-date">{endDate}</div>
                </div>
            );

        } else {
            return ('');
        }      
    }
    return (
        <div class="cq-item cq-title cq-item--default">
        <div class="cq-item__header">

        <div class="cq-item__name-container">
            <div class="cq-item__main-attributes">
            {topTitle()}
            </div>
            <div class="cq-item__name">
            {itemName}
            </div>
        </div>
        <div class="cq-item__right-header">

            {timelineElement()}

            <div class="cq-item__status cq-item__status--valid">
            {status}
            </div>
            
            <div class="cq-item__document-links">
            <div class="cq-item__document--title">
                <span class="rf-fi-file-line"></span>
            </div>
            </div>

            <div class="cq-item__extend">
            <span class="rf-fi-arrow-down-s-line"></span>
            </div>

        </div>
        </div>

        <div class="cq-item__content">
        </div>

    </div>
        
    );
};

export default CQItem;
