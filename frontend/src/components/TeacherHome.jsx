import { Route, Routes, useMatch } from "react-router-dom"
import TeacherProfile from "./Teacher/TeacherProfile"
import { useUser } from "./context/userContext"
import { useEffect, useState } from "react"
import * as teacherService from "../service/teacher"
import { toast } from "react-toastify"
import TeacherSchool from "./Teacher/TeacherSchool"
import Compiti from "./Teacher/Compiti"
import Verifiche from "./Teacher/Verifiche"
import * as incaricoService from "../service/incarico"

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

    return(
        <>
            <Routes>
                <Route path="/" 
                    element = { teacher && <TeacherSchool 
                        teacherId={teacher?.id} incarichi={incarichi} setIncarichi={setIncarichi}/>} 
                />
                <Route path='/profile' 
                    element = { <TeacherProfile teacher={teacher} />} 
                />
                <Route path='/:idClasse/esercizi' 
                    element = { teacher && <Compiti incarichi={incarichi} classeId={classeId} />} 
                />
                <Route path='/:idClasse/verifiche' 
                    element = { teacher && <Verifiche  incarichi={incarichi} classeId={classeId} />} 
                />
            </Routes>
        </>
    )
}

export default TeacherHome