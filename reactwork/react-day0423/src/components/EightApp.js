import React, {useState} from 'react';
import {Alert} from "@mui/material";
import SubEightApp from "./SubEightApp";

/*
** 부모, 자식간의 통신 **
* 1. 부모 컴포넌트에서 자식 컴포넌트로 props를 통해서 값이나 이벤트를 전달할 수 있다
* 2. 자식 컴포넌트에서는 부모 컴포넌트의 값을 props로 받아서 출력은 가능하지만 직접적으로 변경은 불가능하다
* 3. 만약 변경하려면 부모의 이벤트를 props를 통해 호출을 하고 그 이벤트 함수에서 변경을 하면 된다
 */
const EightApp = () => {
    const [cnt, setCnt] = useState(10);
    const increCntEvent = () => {
        setCnt(cnt + 1);
    }
    const decreCntEvent=(num) => {
        setCnt(cnt-num);
    }
    return (
        <div>
            <Alert severity='success'>EightApp - 부모 자식 컴포넌트간 통신</Alert>
            <hr/>
            <h2>총 방문 횟수는 {cnt} 회 입니다</h2>
            <SubEightApp name={'박성진'} age={33} cntHandler={increCntEvent} decreCnt={decreCntEvent}/>
            <SubEightApp name={'강영현'} age={33} cntHandler={increCntEvent} decreCnt={decreCntEvent}/>
            <SubEightApp name={'김원필'} age={32} cntHandler={increCntEvent} decreCnt={decreCntEvent}/>
        </div>
    );
};

export default EightApp;