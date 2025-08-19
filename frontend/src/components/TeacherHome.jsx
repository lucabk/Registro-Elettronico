import { Route, Routes, useMatch } from "react-router-dom"
import TeacherProfile from "./Teacher/TeacherProfile"
import { useUser } from "./context/userContext"
import { useEffect, useState } from "react"
import * as teacherService from "../service/teacher"
import { toast } from "react-toastify"
import TeacherSchool from "./Teacher/TeacherSchool"
import Compiti from "./Assignements/Compiti"
import Verifiche from "./Assignements/Verifiche"
import * as incaricoService from "../service/incarico"
import TeacherStudents from "./Teacher/TeacherStudents"
import ManageStudent from "./Teacher/ManageStudent"
import Assenza from "./Assenze/Assenza"

const TeacherHome = () => {
    const user = useUser()
    const [teacher, setTeacher] = useState(null)
    const [incarichi, setIncarichi] = useState(null)

    useEffect(()=>{
        teacherService.getTeacherByUsername(user.username)
            .then(res => setTeacher(res))
            .catch(e => {
                toast.error("Impossibile recuperare docente")
                console.error("Impossibile recuperare docente: ", e)
            })
    }, [])

    useEffect(()=>{
        if(teacher){
            incaricoService.getIncaricoByDocente(teacher.id)
                .then(res => setIncarichi(res))
                .catch(e => {
                    toast.error("Impossibile recuperare incarico docente")
                    console.error("Impossibile recuperare incarico docente: ", e)
                })
        }
    }, [teacher])

    const matchClasseId = useMatch('/docente/:idClasse/*')
    const classeId = matchClasseId 
        ? Number(matchClasseId.params.idClasse) 
        : null

    const matchStudentId = useMatch('/docente/:idClasse/studenti/:idStudente/*')
    const studentId = matchStudentId 
        ? Number(matchStudentId.params.idStudente)
        : null

    return(
        <>
            <Routes>
                <Route path="/" 
                    element = { teacher && <TeacherSchool incarichi={incarichi} setIncarichi={setIncarichi}/>} 
                />
                <Route path='/profile' 
                    element = { <TeacherProfile teacher={teacher} />} 
                />
                <Route path='/:idClasse/esercizi' 
                    element = { teacher && <Compiti incarichi={incarichi} classeId={classeId} teacher={teacher}/>} 
                />
                <Route path='/:idClasse/verifiche' 
                    element = { teacher && <Verifiche incarichi={incarichi} classeId={classeId} teacher={teacher}/>} 
                />
                <Route path='/:idClasse/studenti' 
                    element = { incarichi && <TeacherStudents incarichi={incarichi} classeId={classeId}/>} 
                />
                <Route path='/:idClasse/studenti/:idStudente' 
                    element = { incarichi && teacher && <ManageStudent classId={classeId} studentId={studentId} incarichi={incarichi} teacher={teacher}/>} 
                />
                <Route path='/:idClasse/studenti/:idStudente/profilo' 
                    element = { <Assenza studentId={studentId} />} 
                />
            </Routes>
        </>
    )
}

export default TeacherHome