import { Route, Routes } from "react-router-dom"
import ManageStudent from "./Teacher/ManageStudent"
import StudentInfo from "./Student/StudentInfo"
import { useUser } from "./context/userContext"
import { useEffect, useState } from "react"
import * as studenService from "../service/student"
import { toast } from "react-toastify"
import Compiti from "./Assignements/Compiti"
import Verifiche from "./Assignements/Verifiche"

const StudentHome = () => {
    const [studentInfo, setStudentInfo] = useState(null)
    const user = useUser()

    useEffect(()=>{
        studenService.getIdStudenteByUsername(user.username)
            .then(res => setStudentInfo(res))
            .catch(e => {
                toast.error("Impossibile recuperare id Studente")
                console.error("Impossibile recuperare id Studente: ", e)
            })
    }, [])

    return(
        <>
            <Routes>
                <Route path='/' element = {studentInfo && <ManageStudent studentId={studentInfo.idStudente} />}/>
                <Route path='/profilo' element = { <StudentInfo studentId={studentInfo?.idStudente} />} />
                <Route path='/compiti' element = { <Compiti classeId={studentInfo?.idClasse}/>} />
                <Route path='/verifiche' element = { <Verifiche classeId={studentInfo?.idClasse}/>} />
            </Routes>
        </>
    )
}

export default StudentHome