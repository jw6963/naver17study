import React from 'react';
import {Alert} from "@mui/material";
import "./mystyle.css";

const OneApp = () => {
    let colors = ["red", "green", "yellow", "orange", "white", "tomato", "cyan", "gold"];

    let snoopydata = [
        {"photo": "s1.JPG", "title": "영식이", "addr": "서울 강남구"},
        {"photo": "s2.JPG", "title": "동춘이", "addr": "울산 북구"},
        {"photo": "s3.JPG", "title": "김명이", "addr": "부산 사상구"},
        {"photo": "s4.JPG", "title": "초식이", "addr": "김천 고구려구"}
    ]
    return (
        <div>
            <Alert severity='success'>OneApp</Alert>

            {
                colors.map((color, idx) => <div key={idx} style={{backgroundColor: color}} className="box"></div>)
            }
            <br style={{clear: "both"}}/>

            <table className='table table-bordered' style={{width: '400px'}}>
                <thead>
                <tr>
                    <th>이름</th>
                    <th>사진</th>
                    <th>주소</th>
                </tr>
                </thead>
                <tbody>
                {
                    snoopydata.map((data,idx)=>
                    <tr key={idx}>
                        <td>{data.title}</td>
                        <td>
                            <img alt="" src={require(`../Snoopy/${data.photo}`)} style={{width:'50px'}}/>
                        </td>
                        <td>{data.addr}</td>

                    </tr>)
                }
                </tbody>

            </table>

        </div>
    );
};

export default OneApp;