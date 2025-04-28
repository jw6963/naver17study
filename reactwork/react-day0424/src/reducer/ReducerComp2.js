import React, {useReducer, useState} from 'react';
import Student from "./Student";

const initialState = {
    cnt: 1,
    students: [
        {
            id: new Date(),
            name: '이영자',
            isHere: false
        }
    ]
}

const reducer = (state, action) => {
    console.log((state, action));

    switch (action.type) {
        case 'add-student' :
            const name = action.payload.name;
            // 추가할 학생 정보
            const addStudent = {
                id: new Date(),
                // name: name, // 같을 경우는 한 번만 써도 됨
                name,
                isHere: false
            }

            const data = {
                cnt: state.cnt + 1,
                students: [
                    ...state.students,
                    addStudent
                ]
            }
            return data;
        case 'delete-student':
            return {
                cnt: state.cnt - 1,
                students: state.students.filter(s => s.id !== action.payload.id)
            }
        case 'mark-student':
            return {
                cnt: state.cnt,
                students: state.students.map(s => {
                    if (s.id === action.payload.id) {
                        return {...s, isHere: !s.isHere}
                    }
                    return s;
                })
            }
        default :
            return state;
    }
}

const ReducerComp2 = () => {
    const [name, setName] = useState('');
    const [studentInfo, dispatch] = useReducer(reducer, initialState);
    return (
        <div>
            <h5>useReducer 예제 #2</h5>
            <h2 className={'alert alert-success'}>학생 관리 Reducer</h2>
            <div className={'input-group'} style={{width: '200px'}}>
                <input type="text" className={'form-control'} value={name} onChange={(e) => setName(e.target.value)}/>
                &nbsp;&nbsp;
                <button type={'button'} className={'btn btn-sm btn-info'} onClick={() => {
                    dispatch({'type': 'add-student', payload: {name}});
                    setName('');
                }}>추가
                </button>
                <br/><br/>
                {
                    studentInfo.students.map((stu, idx) =>
                        <Student key={idx} stu={stu} dispatch={dispatch}/>
                    )
                }
            </div>
        </div>
    );
};

export default ReducerComp2;