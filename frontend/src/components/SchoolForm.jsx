import { useState } from "react"

const SchoolForm = () => {
    const [count, setCount] = useState(0);

    return(
         <div>
            counter: {count}
            <button onClick={()=>setCount(oldValue => oldValue+1)}>add 1</button>
        </div>
    )
}

export default SchoolForm