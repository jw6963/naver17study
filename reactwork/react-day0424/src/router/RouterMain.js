import React from 'react';
import {Routes, Route} from "react-router-dom";
import errorimg from '../image/noimage.png';
import {EightApp, SevenApp, OneApp, FiveApp, FourApp, TwoApp, ThreeApp, SixApp, MainApp, Menu}from '../components';

const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <hr style={{clear:'both'}}/>
            <Routes>
                <Route path={'/'} element={<MainApp/>}/>
                <Route path={'/home/*'} element={<MainApp/>}/>
                <Route path={'/one'} element={<OneApp/>}>
                </Route>
                <Route path={'/two'} element={<TwoApp/>}>
                </Route>
                <Route path={'/three'} element={<ThreeApp/>}>
                </Route>
                <Route path={'/four'} element={<FourApp/>}>
                </Route>
                <Route path={'/five/*'} element={<FiveApp/>}/>
                <Route path={'/six'} element={<SixApp/>}>
                </Route>
                <Route path={'/seven'} element={<SevenApp/>}>
                </Route>
                <Route path={'/eight/*'} element={<EightApp/>}>
                </Route>
                <Route path={'/login/*'} element={
                    <div>
                        <h2>로그인 페이지는 작업중입니다</h2>
                        <FiveApp/>
                        <TwoApp/>
                    </div>
                }/>
                <Route path={'*'} element={
                    <div>
                        <h1>잘못된 URL입니다</h1>
                        <img src={errorimg} alt=""/>
                    </div>
                }></Route>
            </Routes>
        </div>
    );
};

export default RouterMain;