import React, {useState} from 'react';
import {Alert} from "@mui/material";

const ThreeApp = () => {
    //1.mycar array 를 해당 자동차 이미지가 나오도록 출력 (class 는 mycar 적용)
    //2.input 에 숫자 1~15를 입력 후 엔터를 누르면 해당 자동차번호가 배열에 추가되고, 이미지 형태로 출력이 되도록 한다 (1~15가 아니면 "해당 자동차는 존재하지않아요!" 출력)
    //3.해당 자동차를 더블 클릭하면 "해당 자동차를 삭제할까요?" 한 후 클릭하면 배열에서 삭제하기(filter)
    const [mycarArray,setMycarArray] = useState([1,5,10]);

    const addACarnoEvent=(e)=>{
        if(e.key==='Enter'){
            let carNo=Number(e.target.value);
            if(carNo<1 || carNo>15){
                alert('해당자동차는 존재하지 않는 자동차 입니다.');
                return
            }
            setMycarArray(mycarArray.concat(carNo));
            e.target.value="";
        }

    }

    const deleteCar=(i)=>{
        let a=window.confirm("해당 자동차를 삭제할까요?")
        if(!a)
            return;
        //해당 i번 삭제
        setMycarArray(mycarArray.filter((car,idx)=>i!==idx));
    }

    return (
        <div>
            <Alert severity='success'>ThreeApp</Alert>



            <input type="text" className='form-control' placeholder='1-15사이의 자동차 번호 입력' autoFocus onKeyUp={addACarnoEvent}/>
            <div style={{marginTop:'20px'}}>
                {
                    mycarArray.map((car,index) =>
                        <>
                            <img alt="" src={require(`../MyCar/mycar${car}.png`)} className='mycar' onDoubleClick={()=>deleteCar(index)}/>
                        </>)
                }
            </div>
        </div>
    );
};

export default ThreeApp;