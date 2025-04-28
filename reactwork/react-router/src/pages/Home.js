import React from 'react';
import {Alert, Button} from "@mui/material";
import {NavLink, Routes, Route, useNavigate} from "react-router-dom";
import HomeSub from "./HomeSub";
import HomeSub2 from "./HomeSub2";
import HomeSub3 from "./HomeSub3";

const Home = () => {
    const navi = useNavigate();
    return (
        <div>
            <Alert severity={'success'} style={{fontSize:'20px'}}>Home Components</Alert>
            <Button color={'success'} onClick={()=>navi("/food")}>Food로 이동</Button>
            <Button color={'success'} onClick={()=>navi("/food/5")}>Food#2로 이동</Button>
            <Button color={'success'} onClick={()=>navi("/food/2/12")}>Food#3로 이동</Button>
            <Button color={'success'} onClick={()=>navi("/about")}>About으로 이동</Button>
            <div style={{marginTop:'30px'}}>
                <NavLink to={"/home/sub1"}>경치1</NavLink>
                &nbsp;&nbsp;&nbsp;
                <NavLink to={"/home/sub2"}>경치2</NavLink>
                &nbsp;&nbsp;&nbsp;
                <NavLink to={"/home/sub3"}>경치3</NavLink>
            </div>
            <Routes>
                <Route path={'sub1'} element={<HomeSub/>}/>
                <Route path={'sub2'} element={<HomeSub2/>}/>
                <Route path={'sub3'} element={<HomeSub3/>}/>
            </Routes>
        </div>
    );
};

export default Home;