import React, {useEffect, useState} from 'react';
import {Alert} from "@mui/material";
import axios from "axios";
import {InfoOutline} from "@mui/icons-material";
import noimg from '../image/noimage.png';
import {useNavigate} from "react-router-dom";

const ShopList = () => {
    const navi = useNavigate();
    const [shopList, setShopList] = useState([]);
    // 사진 출력할 url
    const photourl = process.env.REACT_APP_PHOTO_URL;
    // 출력 함수
    const list = () => {
        axios.get("/react/shoplist")
            .then(res => {
                setShopList(res.data)
            })
    }
    // 처음 로딩 시 list 함수 호출
    useEffect(() => {
        list();
    }, []);
    return (
        <div>
            <Alert severity={'info'}>총 {shopList.length} 개의 상품이 등록되었습니다</Alert>
            <table className={"table table-bordered"} style={{width: "400px"}}>
                <thead>
                <tr className={"table-danger"}>
                    <th width={"50"}>번호</th>
                    <th width={"150"}>상품명</th>
                    <th width={"100"}>가격</th>
                    <th>상세보기</th>
                </tr>
                </thead>
                <tbody>
                {
                    shopList
                    &&
                    shopList.map((row, idx) =>
                        <tr key={idx}>
                            <td align={'center'}>{row.num}</td>
                            <td>
                                <img src={row.photo ? photourl + row.photo : noimg} alt=""
                                     style={{width: '30px', height: '30px', border: '1px solid black'}}/>
                                &nbsp;{row.sangpum}
                            </td>
                            <td>{row.price}원</td>
                            <td align={'center'}>
                                <InfoOutline style={{cursor: "pointer", fontSize: '1.5em', color: 'blue'}}
                                             onClick={() => navi("/five/detail/" + row.num)}/>
                            </td>
                        </tr>
                    )
                }
                </tbody>
            </table>
        </div>
    );
};

export default ShopList;