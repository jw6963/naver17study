import React, {useState} from 'react';
import {Alert} from "@mui/material";
import noimage from "../image/noimage.png";
import axios from "axios";
import {useNavigate} from "react-router-dom";

const ShopForm = ({onSave}) => {
    const navi = useNavigate();
    const [sangpum, setSangpum] = useState('');
    const [color, setColor] = useState('#ccffcc');
    const [price, setPrice] = useState(0);
    const [sangguip, setSangguip] = useState('2025-01-01');
    // 업로드한 사진을 저장하기 위한 변수
    const [photo, setPhoto] = useState('');
    const [photoPreview, setPhotoPreview] = useState(null); // 미리보기용 URL
    // naver storage url
    const shoppath = "https://kr.object.ncloudstorage.com/bitcamp-semi/jpashop/";

    // 추가 버튼 이벤트
    const addShopEvent = () => {
        onSave({sangpum, color, price, sangguip});
        navi(`/five/list`);
    }

    // 파일 업로드 + 미리보기 이벤트
    const photoUploadEvent = (e) => {
        const uploadFile = e.target.files[0];

        // 미리보기
        if (uploadFile) {
            setPhotoPreview(URL.createObjectURL(uploadFile));
        }

        // 서버 전송
        const imgFile = new FormData();
        imgFile.append("upload", uploadFile);

        axios({
            method: "post",
            url: "/react/upload",
            data: imgFile
        }).then(res => setPhoto(res.data));
    };
    return (
        <div>
            <Alert severity='info'>상품등록</Alert>
            <table className="table table-bordered" style={{width: '600px', margin: '20px auto'}}>
                <tbody>
                <tr>
                    <td align="center" style={{verticalAlign: 'middle', padding: '20px'}}>
                        <div style={{width: '150px'}}>
                            {/* 미리보기 */}
                            <img src={photoPreview || (photo && `${shoppath}${photo}`) || noimage} alt=""
                                 style={{width: '120px', height: '120px', objectFit: 'cover',
                                     border: '1px solid #ccc', borderRadius: '8px'}}/>
                        </div>
                    </td>
                    <td style={{padding: '20px'}}>
                        <div style={{width: '100%'}}>
                            <div className="table-data">
                                <label>상품 이미지:</label>
                                <input type="file" className="form-control" onChange={photoUploadEvent}/>
                            </div>
                            <div className="table-data">
                                <label>상품명:</label>
                                <input type="text" className="form-control" placeholder="상품명" value={sangpum}
                                       onChange={(e) => setSangpum(e.target.value)}/>
                            </div>
                            <div className="table-data">
                                <label>색상:</label>
                                <input type="color" className="form-control form-control-color" value={color}
                                       onChange={(e) => setColor(e.target.value)}
                                       title="색상 선택"/>
                            </div>
                            <div className="table-data">
                                <label>단가:</label>
                                <input type="number" className="form-control" style={{width: '120px'}}
                                       placeholder="상품가격" value={price}
                                       onChange={(e) => setPrice(e.target.value)}/>
                            </div>
                            <div className="table-data">
                                <label>등록일:</label>
                                <input type="date" className="form-control" value={sangguip}
                                       onChange={(e) => setSangguip(e.target.value)}/>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} align="center" style={{padding: '20px'}}>
                        <button className="btn btn-success me-2" style={{minWidth: '100px'}}
                                onClick={addShopEvent}>등록하기</button>
                        <button className="btn btn-outline-primary me-2" style={{minWidth: '100px'}}
                                onClick={() => navi('/five/list')}>상품목록</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    );
};

export default ShopForm;