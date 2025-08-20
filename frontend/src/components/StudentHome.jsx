import { Route, Routes } from "react-router-dom"
import MyHome from "./Student/MyHome"
import StudentInfo from "./Student/StudentInfo"
import { useUser } from "./context/userContext"
import { useEffect, useState } from "react"
import * as studenService from "../service/student"
import { toast } from "react-toastify"

const StudentHome = () => {
    const [studentId, setStudentId] = useState(null)
    const user = useUser()

    useEffect(()=>{
        studenService.getIdStudenteByUsername(user.username)
            .then(res => setStudentId(res.idStudente))
            .catch(e => {
                toast.error("Impossibile recuperare id Studente")
                console.error("Impossibile recuperare id Studente: ", e)
            })
    }, [])

    return(
        <>
            <Routes>
                <Route path='/' element = { <MyHome />} />
                <Route path='/profilo' element = { <StudentInfo studentId={studentId} />} />
            </Routes>
        </>
    )
}

export default StudentHome