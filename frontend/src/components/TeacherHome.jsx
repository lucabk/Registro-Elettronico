import { Route, Routes } from "react-router-dom"
import TeacherProfile from "./Teacher/TeacherProfile"
import { useUser } from "./context/userContext"
import { useEffect, useState } from "react"
import * as teacherService from "../service/teacher"
import { toast } from "react-toastify"

const TeacherHome = () => {
    const user = useUser()
    const [teacher, setTeacher] = useState(null)

    useEffect(()=>{
        teacherService.getTeacherByUsername(user.username)
            .then(res => setTeacher(res))
            .catch(e => {
                toast.error("Impossibile recuperare docente")
                console.error("Impossibile recuperare docente: ", e)
            })
    }, [])

    return(
        <>
            <Routes>
                <Route path='/' element = 
                { <TeacherProfile teacher={teacher} />}
                />
            </Routes>
        </>
    )
}

export default TeacherHome