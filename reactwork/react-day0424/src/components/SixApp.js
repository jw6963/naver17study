import {Alert} from '@mui/material';
import React, {useState} from 'react';
import SixShowState from "./SixShowState";
import SixAverage from "./SixAverage";

const SixApp = () => {
    const [num, setNum] = useState(0);
    const [txt, setTxt] = useState('');
    const increNum = () => {
        setNum(num + 1);
    }
    const decreNum=()=>{
        setNum(num-1);
    }
    const onChangeTxtHandler=(e) => {
        setTxt(e.target.value);
    }
    return (
        <div>
            <Alert severity='success'
                   style={{fontSize: '25px'}}>SixApp - useMemo(memorization : 렌더링을 최적화하기 위한 기능)</Alert>
            <button onClick={increNum}>+</button>
            &nbsp;&nbsp;
            <button onClick={decreNum}>-</button>
            <br/>
            <input type="text" placeholder={'Last name?'} onChange={onChangeTxtHandler}/>

        {/*  서브 컴포넌트 호출  */}
            <SixShowState number={num} text={txt}/>
            <SixAverage/>
        </div>
    );
};

export default SixApp;