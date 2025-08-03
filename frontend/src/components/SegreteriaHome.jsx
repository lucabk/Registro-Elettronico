import { Route, Routes, useMatch } from "react-router-dom"
import SchoolHomePage from "./School/SchoolHomePage"
import { useEffect, useState } from "react"
import { getSchoolBySecr } from "../service/secretaryships"
import { useUser } from "./context/userContext"
import { toast } from "react-toastify"
import ClassiScuolaSegr from "./Class/ClassiScuolaSegr"
import ClassInfo from "./Class/ClassInfo"
import Students from "./Student/Students"
import StudentInfo from "./Student/StudentInfo"
import GetSubjects from "./Subject/GetSubjects"
import GetTeachers from "./Teacher/GetTeachers"

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

    const matchStudentId = useMatch('/segreteria/classi/:idClasse/students/:idStudent/*')    
    const studentId = matchStudentId
        ? Number(matchStudentId.params.idStudent)
        : null

    return(
        <>
            <Routes>

                <Route path='/' element =
                    { <SchoolHomePage school={school} /> } 
                />
                <Route path='/classi' element =
                    { <ClassiScuolaSegr  school={school} /> } 
                />
                <Route path='/classi/:idClasse' element =
                    { <ClassInfo classId={classId} /> } 
                />
                <Route path='/classi/:idClasse/students' element = 
                    { <Students classId={classId} schoolId={school?.id}/> }
                />    
                <Route path='/classi/:idClasse/students/:idStudent' element = 
                    { <StudentInfo studentId={studentId} /> }
                />    

                <Route path='/materie' element =
                    { <GetSubjects /> }
                />

                <Route path='/docenti' element =
                    { <GetTeachers /> }
                />

            </Routes>
        </>
    )
}

export default SegreteriaHome