'use client';
import { useStore } from "@/store/useStore";

export default function GrandChild(){

    const {count, increase, decrease, text, setText } = useStore();
    console.log(count);
    

    return (
        <div>
            <h2>{count}</h2>
            <button onClick={increase}>+1</button>
            <button onClick={decrease}>-1</button>

            <hr />

            <input
                value={text} 
                onChnage={ (e)=> setText(e.target.value)}
                />
                <p>{text}</p>
        </div>
    )
}

//===[람다식, 구조분해 사용 X]===
// import { useStore } from "@/store/useStore";

// export default function GrandChild() {
//     // 1. 구조 분해를 하지 않고 변수에 전체 스토어를 담습니다.
//     const store = useStore();
    
//     // 2. 개별 변수에 점 표기법(Dot Notation)으로 하나씩 할당합니다.
//     const count = store.count;
//     const increase = store.increase;
//     const decrease = store.decrease;
//     const text = store.text;
//     const setText = store.setText;

//     console.log(count);

//     // 3. 이벤트 핸들러도 일반 함수로 작성
//     function handleChange(e) {
//         setText(e.target.value);
//     }

//     return (
//         <div>
//             <h2>{count}</h2>
//             {/* 할당된 변수를 그대로 사용하거나 store.increase처럼 직접 써도 됩니다. */}
//             <button onClick={increase}>+1</button>
//             <button onClick={decrease}>-1</button>

//             <hr />

//             <input
//                 value={text}
//                 onChange={handleChange} 
//             />
//             <p>{text}</p>
//         </div>
//     );
// }