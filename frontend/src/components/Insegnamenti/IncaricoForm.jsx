import { useEffect, useState } from "react"
import * as teacherService from "../../service/teacher"
import { toast } from "react-toastify"
import * as subjectService from "../../service/subject"
import * as incaricoService from "../../service/incarico" 

const IncaricoForm = ({ schoolId, classId, setIncarichi }) => {
    const [teachers, setTeachers] = useState([])
    const [teacherSurname, setTeacherSurname] = useState('')
    const [matching, setMatching] = useState([])
    const [subjects, setSubjects] = useState([])
    const [selectedSubject, setSelectedSubject] = useState('')
    const [selectedTeacher, setSelectedTeacher] = useState('')
    const [selectedProgram, setSelectedProgram] = useState('')

    useEffect(()=>{
        teacherService.getTeachers()
            .then(res => setTeachers(res))
            .catch(e => {
                toast.error("Errore recupero docenti disponibili")
                console.error("Errore recupero docenti disponibili: ", e)
            })
    }, [])

    useEffect(()=>{
        subjectService.getMaterie()
            .then(res => setSubjects(res))
            .catch(e => {
                toast.error("Errore recupero materie disponibili")
                console.error("Errore recupero materie disponibili: ", e)
            })
    },[])

    useEffect(()=>{
        const newMatching = teachers.filter(t => 
            t.cognome.toLowerCase().includes(teacherSurname.toLowerCase()))
        setMatching(newMatching)
    },[teacherSurname])

    const handleSubmit = async (e) => {
        e.preventDefault()
        if(selectedTeacher == '' || selectedSubject == ''){
            toast.warning("Selezionare materia e docente")
            return
        }
        const newIncarico = {
            scuolaDTO: { id : schoolId},
            classeDTO : { id : classId },
            docenteDTO : { id : Number(selectedTeacher) },
            materiaDTO : { id : Number(selectedSubject) },
            programma : selectedProgram
        } 
        try{
            const res = await incaricoService.addIncarico(newIncarico)
            setIncarichi(prev => [...prev, res])
            toast.success("Incarico aggiunto correttamente")
        }catch(e){
            toast.error("Impossibile salvare incarico")
            console.error("Impossibile salvare incarico: ", e)
        }
        finally{
            setSelectedProgram('')
            setSelectedSubject('')
            setSelectedTeacher('')
            setTeacherSurname('')
        }
    }

    const formSelectTeacher = () => {
        if(matching.length === 0 && teacherSurname.length>=1){
            return <span>Nessun docente trovato</span> 
        } else if(matching.length < 5 && matching.length >= 1){
            return(
                <>
                    <select className="form-select mt-3" value={selectedTeacher} onChange={e=>setSelectedTeacher(e.target.value)} required aria-label="Default select example" name="docente">
                        <option >Seleziona Docente</option>
                        { matching.map(m => (
                            <option key={m.id} value={m.id}>{`${m.cognome} ${m.nome}  (${m.istruzione})`}</option>
                        ))}
                    </select>
                </>
            )
        } else {
            return(
                <div className="mt-2 text-danger">
                    <span>
                        Digitare nel filtro di ricerca finché non appare la possibilità di selezionare il docente
                    </span>
                </div>
            )
        }   
    } 

    //console.log("Matching: ", matching)
    //console.log("selectedTeacher: ", selectedTeacher)
    //console.log("selectedSubject: ", selectedSubject)

    return(
        <>
            <div className="container p-3 mb-5 mt-3 bg-light text-dark p-5">
                <h2 className="text-center fs-2 mb-4">Aggiungi un insegnamento alla classe</h2>
                <form onSubmit={handleSubmit} className="row needs-validation">
                    <div className="mt-4 col">
                        { subjects && (
                            <select className="form-select mt-3" value={selectedSubject} onChange={e => setSelectedSubject(e.target.value)} required aria-label="Default select example" name="materie">
                                <option >Seleziona Materia</option>
                                { subjects.map(m => (
                                    <option key={m.id} value={m.id}>{`${m.nome}`}</option>
                                ))}
                            </select>
                        )}
                    </div>
                    <div className="mt-4 col">
                        <label htmlFor="docenti" className="form-label">Cognome docente:</label>
                        <input className="form-control" value={teacherSurname} onChange={(e)=>setTeacherSurname(e.target.value)} id="docenti" name="docenti" type="text" placeholder="Rossi" maxLength={50}></input>
                        { formSelectTeacher() }
                    </div>
                    <div className="mt-3">
                        <label htmlFor="programma" className="form-label">Programma della materia</label> 
                        <textarea style={{height : 200}} value={selectedProgram} onChange={e=>setSelectedProgram(e.target.value)} className="form-control" id="programma" name="programma" type="text" placeholder="Dante, Virgilio, ..." required maxLength={65535}></textarea>
                    </div>
                    <button className="mt-5 btn btn-dark btn-lg">Aggiungi</button>
                </form>
            </div>
        </>
    )
}

export default IncaricoForm