import { useEffect, useState } from "react"
import * as schoolService from "../service/schools"
import SingleSchool from "./SingleSchool"

const Schools = () => {
    const [schools, setSchools] = useState([])

    useEffect(()=>{
        schoolService.getSchools()
            .then(res =>  setSchools(res))
            .catch(error => console.error("Error fetching schools:", error))
        },[])
        
        console.log("GET all schools result: ", schools)


    return(
        <div>
            <section>
            <h2>Sezione scuole nel database</h2>
            {schools.map(s => 
                <SingleSchool key={s.id} school={s} />
            )}
            </section>
        </div>
    )
}

export default Schools