import Schools from "./Schools"
import { Routes, Route, useMatch } from 'react-router-dom'
import { useState, useEffect } from "react"
import * as schoolService from "../service/schools"
import SchoolInfo from "./SchoolInfo"
import SchoolForm from "./SchoolForm"

const AdminHome = () => {
    const [schools, setSchools] = useState([])
    const [filter, setFilter] = useState({ regione:"", provincia:"", citta:"" })
    
    useEffect(()=>{
    schoolService.getSchools(filter)
        .then(res =>  setSchools(res))
        .catch(error => console.error("Error fetching schools:", error))
    },[filter])

    const match = useMatch('/schools/:id')
    const school = match 
        ? schools.find( s => s.id === Number(match.params.id)) 
        : null

    return(
        <>  
            <Routes>
                <Route path='/' element={ 
                    <Schools 
                        filter={filter} 
                        schools={schools} 
                        setFilter={setFilter}
                    /> } 
                />
                <Route path='/schools/:id' element={ <SchoolInfo school={school}/>} />
                <Route path='/addSchool' element= { <SchoolForm />} />
            </Routes>
        </>
    )
}

export default AdminHome