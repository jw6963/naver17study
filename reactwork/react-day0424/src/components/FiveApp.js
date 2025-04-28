import {Alert} from '@mui/material';
import React from 'react';
import {Routes, Route, useNavigate} from "react-router-dom";
import {ShopList, ShopForm, ShopDetail} from "../shopcomponents";
import UpdateForm from "../shopcomponents/UpdateForm";

const FiveApp = () => {
    const navi = useNavigate();
    return (
        <div>
            <Alert severity='success'
                   style={{fontSize: '25px'}}>FiveApp - shop 라우터 설정</Alert>
            <div style={{margin: "20px"}}>
                <button type={'button'} className={'btn btn-sm btn-outline-secondary'}
                        onClick={() => navi('/five/list')}>shop 목록
                </button>
                &nbsp;&nbsp;
                <button type={'button'} className={'btn btn-sm btn-outline-secondary'}
                        onClick={() => navi('/five/list')}>shop 추가
                </button>
                &nbsp;&nbsp;
                <br/><br/>
                <Routes>
                    <Route path={'/'} element={<ShopList/>}/>
                    <Route path={'list'} element={<ShopList/>}/>
                    <Route path={'form'} element={<ShopForm/>}/>
                    <Route path={'detail/:num'} element={<ShopDetail/>}/>
                    <Route path={'update/:num'} element={<UpdateForm/>}/>
                </Routes>
            </div>
        </div>
    );
};

export default FiveApp;