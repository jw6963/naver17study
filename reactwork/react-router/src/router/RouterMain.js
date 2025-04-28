import React from 'react';
import Menu from '../components/Menu';
import {Routes, Route} from "react-router-dom";
import Home from '../pages/Home';
import Food from "../pages/Food";
import About from "../pages/About";
import errorimg from '../image/s10.JPG';

const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <hr style={{clear:'both', marginTop:'100px'}}/>
            <Routes>
                <Route path={'/'} element={<Home/>}/>
                <Route path={'/home/*'} element={<Home/>}/>
                {/*<Route path={'/about'} element={<About/>}/>*/}
                <Route path={'/about'} element={<About/>}>
                    <Route path={':emp'} element={<About/>}/>
                </Route>
                <Route path={'/food/'} element={<Food/>}>
                    <Route path=':food1' element={<Food/>}/>
                    <Route path=':food1/:food2' element={<Food/>}/>
                </Route>

                <Route path={'/login/*'} element={
                    <div>
                        <h2>로그인 페이지는 작업중입니다</h2>
                        <About/>
                        <Food/>
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