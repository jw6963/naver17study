import React, {useRef, useState} from 'react';
import {Alert, Button} from "@mui/material";

const FourApp = () => {

    const [count, setCount] = useState(1);
    const numberRef=useRef(1); // 변경이 되어도 랜더링이 발생 x
    const countIncreEvent=()=>{
        console.log("count 변수값 증가"+count);
        setCount(count+1);
    }
    const numberIncreEvent=()=>{
        numberRef.current=numberRef.current+1;
        console.log("numberRef 증가:" +numberRef.current);
    }
    return (
        <div>
            <Alert severity='success'>FourApp - State 변수와 ref 변수의 차이점 </Alert>

            <Button variant='contained' color='secondary' onClick={countIncreEvent}>Count 변수 증가</Button>
            <b style={{fontSize:'3em', marginLeft:'20px'}}>{count}</b>
            <Button variant='contained' color='info' onClick={numberIncreEvent}>numberRef 변수 증가</Button>
            <b style={{fontSize:'3em', marginLeft:'20px'}}>{numberRef.current}</b>
        </div>
    );
};

export default FourApp;