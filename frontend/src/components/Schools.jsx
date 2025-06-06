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
        <div className="container-fluid sezione-scuole p-5 m-0">
            <section>
                <h2 className="titolo mt-5">Scuole disponibili nel database</h2>
                <table className="table p-3 mt-5 table-dark table-striped">
                    <caption>scuole</caption>
                    <thead>
                        <tr>
                            <th>Nome istituto</th>
                            <th>Tipologia</th>
                            <th>Indirizzo</th>
                            <th>Città</th>
                            <th>Provincia</th>
                            <th>CAP</th>
                            <th>Regione</th>
                        </tr>
                    </thead>
                    <tbody>
                    {schools.map(s => 
                        <tr key={s.id}>
                            <SingleSchool school={s} />
                        </tr>
                    )}
                    </tbody>
                </table>
            </section>
        </div>
    )
}

export default Schools