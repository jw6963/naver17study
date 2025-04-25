import React, {useState} from 'react';
import {Button} from "@mui/material";

const FourWriteShop = ({onSave}) => {
    const [sangpum, setSangpum] = useState('');
    const [color, setColor] = useState('#ccffcc');
    const [price, setPrice] = useState(0);
    const [sangguip, setSangguip] = useState('2025-01-01');

    // 추가 버튼 이벤트
    const addShopEvent=()=>{
        onSave({sangpum, color, price, sangguip});

        // 초기화
        setSangguip('2025-01-01');
        setPrice(0);
        setSangpum('');
    }
    return (
        <div style={{width: '700px'}}>
            <div style={{display:'flex', alignItems:'center'}}>
                <input type="text" placeholder={'상품명'} value={sangpum} onChange={(e) => setSangpum(e.target.value)}/>
                &nbsp;&nbsp;
                <input type="color" value={color} onChange={(e) => setColor(e.target.value)}/>
                &nbsp;&nbsp;
                <input type="number" style={{width:'100px'}} placeholder={'상품가격'} value={price} onChange={(e) => setPrice(e.target.value)}/>
                &nbsp;&nbsp;
                <input type="date" value={sangguip} onChange={(e) => setSangguip(e.target.value)}/>
                <Button color={'success'} variant={'contained'} style={{margin:'10px 30px'}} onClick={addShopEvent}>추가</Button>
            </div>
        </div>
    );
};

export default FourWriteShop;