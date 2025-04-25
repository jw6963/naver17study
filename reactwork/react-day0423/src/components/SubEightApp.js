import React from 'react';

// 방법1
// const SubEightApp = (props) => {
//     return (
//         <div>
//             <div className={'border1'}>
//                 <h6>이름 : {props.name}</h6>
//                 <h6>나이 : {props.age}세</h6>
//                 <button type='button' className={'btn btn-sm btn-danger'} onClick={props.cntHandler}>방문</button>
//             </div>
//         </div>
//     );
// };

// 방법2
// const SubEightApp = (props) => {
//     const {name, age, cntHandler} = props;
//     return (
//         <div>
//             <div className={'border1'}>
//                 <h6>이름 : {name}</h6>
//                 <h6>나이 : {age}세</h6>
//                 <button type='button' className={'btn btn-sm btn-danger'} onClick={cntHandler}>방문</button>
//             </div>
//         </div>
//     );
// };

// 방법3
const SubEightApp = ({name, age, cntHandler, decreCnt}) => {
    return (
        <div>
            <div className={'border1'}>
                <h6>이름 : {name}</h6>
                <h6>나이 : {age}세</h6>
                <button type='button' className={'btn btn-sm btn-danger'} onClick={cntHandler}>방문</button>&nbsp;
                <button type='button' className={'btn btn-sm btn-danger'} onClick={()=>decreCnt(3)}>탈퇴</button>
            </div>
        </div>
    );
};

export default SubEightApp;