import { Route, Routes, useMatch } from "react-router-dom"
import SchoolHomePage from "./School/SchoolHomePage"
import { useEffect, useState } from "react"
import { getSchoolBySecr } from "../service/secretaryships"
import { useUser } from "./context/userContext"
import { toast } from "react-toastify"
import ClassiScuolaSegr from "./Class/ClassiScuolaSegr"
import ClassInfo from "./Class/ClassInfo"

const SegreteriaHome = () => {
    const [school, setSchool] = useState(null)
    const user = useUser()

    useEffect(()=> {
        getSchoolBySecr(user.username)
            .then(res => setSchool(res))
            .catch(err => {
                toast.error("Impossibile recuperare la scuola")
                console.error("Error fetching school:", err)
            })
    },[])

    const matchClassId = useMatch('/segreteria/classi/:idClasse/*')
    const classId = matchClassId 
        ? Number(matchClassId.params.idClasse)
        : null

    return(
        <>
            <Routes>
                <Route path='/' element={ 
                    <SchoolHomePage school={school} />
                } />
                <Route path='/classi' element={ 
                    <ClassiScuolaSegr  school={school} />
                } />
                <Route path='/classi/:idClasse' element={
                    <ClassInfo classId={classId} />
                } />
            </Routes>
        </>
    )
}

export default SegreteriaHome