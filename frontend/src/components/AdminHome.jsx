import Schools from "./School/Schools"
import { Routes, Route, useMatch } from 'react-router-dom'
import { useState, useEffect } from "react"
import * as schoolService from "../service/schools"
import SchoolInfo from "./School/SchoolInfo"
import SchoolForm from "./School/SchoolForm"
import UpdateSchool from "./School/updateSchool"
import { toast } from "react-toastify"
import Segreterie from "./Secretaryship/Secretaryship"
import ClassInfo from "./Class/ClassInfo"

const AdminHome = () => {
    const [schools, setSchools] = useState([])
    const [filter, setFilter] = useState({ regione:"", provincia:"", citta:"" })
    
    useEffect(()=>{
        schoolService.getSchools(filter)
            .then(res =>  setSchools(res))
            .catch(error => {
                toast.error("Impossibile recuperare scuole")
                console.error("Error fetching schools:", error)
            })
    },[filter])

    const matchSchool = useMatch('/admin/schools/:idScuola/*')
    const school = matchSchool 
        ? schools.find(s => s.id === Number(matchSchool.params.idScuola)) 
        : null

    const matchClassId = useMatch('/admin/schools/:idScuola/:idClasse/*')
    const classId = matchClassId 
        ? Number(matchClassId.params.idClasse)
        : null


    return(
        <>  
            <Routes>
                <Route path='/' element={ 
                    <Schools filter={filter} schools={schools} setFilter={setFilter} /> } 
                />
                
                <Route path='/schools/:idScuola' element={ 
                    <SchoolInfo school={school} setSchools={setSchools} schools={schools} /> } 
                />
                
                <Route path='/addSchool' element= { 
                    <SchoolForm schools={schools} setSchools={setSchools} /> } 
                />
                
                <Route path='/schools/:idScuola/update' element = { 
                    <UpdateSchool schools={schools} setSchools={setSchools} /> }
                /> 
                
                <Route path='/schools/:idScuola/segreterie' element = { 
                    <Segreterie school={school} /> }
                />
                
                <Route path='/schools/:idScuola/:idClasse' element = { 
                    <ClassInfo classId={classId} /> }
                />
                
            </Routes>
        </>
    )
}

export default AdminHome