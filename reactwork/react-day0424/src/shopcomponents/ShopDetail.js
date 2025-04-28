import React, {useEffect, useState} from 'react';
import {Alert} from "@mui/material";
import {useNavigate, useParams} from "react-router-dom";
import axios from "axios";
import noimage from "../image/noimage.png";

const ShopDetail = () => {
    const navi = useNavigate();
    const shoppath = process.env.REACT_APP_PHOTO_URL;
    const {num} = useParams();
    const [selectData, setSelectData] = useState('');
    // num에 해당하는 데이터 가져오기
    const getSelectData = () => {
        axios.get("/react/detail?num=" + num)
            .then(res => {
                setSelectData(res.data)
            })
            .catch()
    }
    const shopDeleteEvent = (num) => {
        let a = window.confirm("해당 상품을 삭제할까요?")
        if (!a) {
            return;
        }
        axios.delete("/react/shopdelete?num=" + num)
            .then(res => navi("/five/list"))
    }
    // 처음 로딩시 함수 호출
    useEffect(() => {
        getSelectData();
    }, []);
    return (
        <div>
            <Alert severity={'info'}>상품 상세보기</Alert>
            <table className={'table table-bordered'} style={{width: '500px'}}>
            {
                selectData
                &&
                    <tr>
                        <td>
                            <img src={selectData.photo ? shoppath + selectData.photo : noimage} alt=""
                                 onError={(e) => e.target.src = noimage}
                                 style={{width: '140px', height: '160px', border: '3px solid gray'}}/>
                        </td>
                        <td style={{marginLeft: '10px'}} valign={"middle"}>
                            <h6>상품명 : {selectData.sangpum}
                            </h6>
                            <h6>색 상 : <span style={{backgroundColor: selectData.color}}>{selectData.color}</span></h6>
                            <h6>단 가 : {selectData.price}원</h6>
                            <h6>구입일 : {selectData.sangguip}</h6>
                            <h6>등록일 : {selectData.writeday}</h6>
                        </td>
                    </tr>
            }
            </table>
            <button type={'button'} className={"btn btn-sm btn-success"}
            onClick={()=>navi("/five/form")}>상품 추가</button>
            &nbsp;&nbsp;
            <button type={'button'} className={"btn btn-sm btn-warning"}
            onClick={()=>{navi("/five/list")}}>상품 목록</button>
            &nbsp;&nbsp;
            <button type={'button'} className={"btn btn-sm btn-info"}
            onClick={()=>{navi(`/five/update/${num}`)}}>상품 수정</button>
            &nbsp;&nbsp;
            <button type={'button'} className={"btn btn-sm btn-danger"}
            onClick={()=>shopDeleteEvent(selectData.num)}>상품 삭제</button>
        </div>
    );
};

export default ShopDetail;