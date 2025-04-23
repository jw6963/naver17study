import React, {useState} from 'react';
import {Alert} from "@mui/material";

const SevenApp = () => {
    const [starArray] = useState([{
        starName: '김우빈', starAge: '35세', starPhoto: '2.jpg', starAddress: '서울시 강남구', starPhone: '010-1111-4444'
    }, {
        starName: '설현', starAge: '29세', starPhoto: '15.jpg', starAddress: '서울시 영등포구', starPhone: '010-2222-5555'
    }, {
        starName: '신민아', starAge: '33세', starPhoto: '17.jpg', starAddress: '제주도 애월읍', starPhone: '010-5555-4444'
    }, {
        starName: '신세경', starAge: '32세', starPhoto: '18.jpg', starAddress: '부산시 해운대', starPhone: '010-4444-6666'
    }, {
        starName: '수지', starAge: '30세', starPhoto: '19.jpg', starAddress: '서울시 강동구', starPhone: '010-8888-3333'
    }]);

    return (<div>
        <Alert severity='success'>SevenApp - 배열 데이터 출력</Alert>
        <table className={'table table-bordered'} style={{width: '400px'}}>
            <tbody>
            {
                starArray.map((row, idx) => (
                    <>
                        <tr>
                            <td rowSpan={4} align='center'>
                                <img src={require(`../star/${row.starPhoto}`)} alt="" style={{width:'130px'}}/>
                            </td>
                            <td align='center' width='60' style={{backgroundColor:'lightcyan', fontWeight:'bold'}}>이름</td>
                            <td>{row.starName}</td>
                        </tr>
                        <tr>
                            <td align='center' style={{backgroundColor:'lightcyan', fontWeight:'bold'}}>나이</td>
                            <td>{row.starAge}</td>
                        </tr>
                        <tr>
                            <td align='center' style={{backgroundColor:'lightcyan', fontWeight:'bold'}}>주소</td>
                            <td>{row.starAddress}</td>
                        </tr>
                        <tr>
                            <td align='center' style={{backgroundColor:'lightcyan', fontWeight:'bold'}}>핸드폰</td>
                            <td>{row.starPhone}</td>
                        </tr>
                    </>
                ))
            }
    </tbody>
</table>
</div>)
    ;
};

export default SevenApp;