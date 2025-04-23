import React, {useState} from 'react';
import {Alert} from "@mui/material";
import EightApp from "./EightApp";
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import SevenApp from "./SevenApp";
import SixApp from "./SixApp";
import FiveApp from "./FiveApp";

const MainApp = () => {

    const [idx,setIdx] = useState(5);

    return (
        <div>
            <Alert severity='info'>2025-04-23 React Class MainApp</Alert>
            <hr/>

            <div style={{width:'400px'}} className='input-group'>
                <h5>App선택</h5>
                <select className="form-select" style={{margin:'20px'}} id="" defaultValue={7}
                        onChange={(e)=>setIdx(Number(e.target.value))}>
                    <option value={1}>OneApp</option>
                    <option value={2}>TwoApp</option>
                    <option value={3}>ThreeApp</option>
                    <option value={4}>FourApp</option>
                    <option value={5}>FiveApp</option>
                    <option value={6}>SixApp</option>
                    <option value={7}>SevenApp</option>
                    <option value={8}>EightApp</option>
                </select>
            </div>

            {
                idx===1?<OneApp/>:idx===2?<TwoApp/>:idx===3?<ThreeApp/>:idx===4?<FourApp/>:
                    idx===5?<FiveApp/>:idx===6?<SixApp/>:idx===7?<SevenApp/>:<EightApp/>
            }
        </div>
    );
};

export default MainApp;