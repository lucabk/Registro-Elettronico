import Schools from "./School/Schools"
import { Routes, Route, useMatch } from 'react-router-dom'
import { useState, useEffect } from "react"
import * as schoolService from "../service/schools"
import SchoolInfo from "./School/SchoolInfo"
import SchoolForm from "./School/SchoolForm"
import UpdateSchool from "./School/updateSchool"

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
        ? schools.find(s => s.id === Number(match.params.id)) 
        : null

    return(
        <>  
            <Routes>
                <Route path='/' element={ <Schools 
                    filter={filter} 
                    schools={schools} 
                    setFilter={setFilter} /> } 
                />
                <Route path='/schools/:id' element={ <SchoolInfo 
                    school={school} 
                    setSchools={setSchools}
                    schools={schools} /> } 
                />
                <Route path='/addSchool' element= { <SchoolForm 
                    schools={schools} 
                    setSchools={setSchools}
                    /> } 
                />
                <Route path='/schools/:id/update' element= { <UpdateSchool 
                    schools={schools}
                    setSchools={setSchools}
                    /> }
                /> 
            </Routes>
        </>
    )
}

export default AdminHome