import React, {useMemo, useState} from 'react';

const getAverager = (numbers) => {
    console.log("평균 값 계산중...");
    if (numbers.length === 0) {
        return 0;
    }
    const total = numbers.reduce((sum, n) => sum + n);
    const avg = total/numbers.length;
    return avg;
}

const SixAverage = () => {
    const [list, setList] = useState([]);
    const [num, setNum] = useState('');

    // 평균 값 구하는 함수를 최적화해보기
    const avg=useMemo(()=>getAverager(list),[list]);

    return (
        <div>
            <h5>숫자를 입력하면 입력한 숫자에 대한 평균 구하기</h5>
            <input type="text" value={num} onChange={(e) => setNum(e.target.value)}/>
            <button onClick={() => {
                setList(list.concat(Number(num)));
                setNum('');
            }}>등록
            </button>
            <br/><br/>
            <ul>
                {
                    list.map((num, idx) =>
                        <li key={idx}>{num}</li>
                    )
                }
            </ul>
            <div style={{fontSize:'2em', margin:'10px'}}>
                평균 : {avg}
            </div>
        </div>
    );
};

export default SixAverage;