import { useEffect, useState } from "react"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import * as assignmentsService from "../../service/assignements"
import { toast } from "react-toastify"
import Calendar from 'react-calendar';
import AddAssignement from "./AddAssignement"

const Compiti = ({ classeId, incarichi }) => {
    const [compiti, setCompiti] = useState([])
    const [selectedDate, setSelectedDate] = useState(null)
    let insegnamento

    useEffect(()=>{
        assignmentsService.getCompitiByClasse(classeId)
            .then(res => setCompiti(res))
            .catch(e => {
                toast.error("Impossibile recuperare compiti")
                console.error("Impossibile recuperare compiti: ", e)
            })
    }, [])
    
    if(incarichi){
        insegnamento = incarichi.filter(i => i.classeDTO.id === classeId)
    }

    const tileContent = ({ date, view }) => {
        if (view === 'month' && compiti) {
            const found = compiti.find(c => c.dataConsegna === formatDate(date))
            if (found) {
                return (
                    <span className="m-2">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="blue" className="bi bi-book" viewBox="0 0 16 16">
                            <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783"></path>
                        </svg>
                    </span>   
                )
            }
            const day = new Date()
            if (
                date.getDate() === day.getDate() &&
                date.getMonth() === day.getMonth() &&
                date.getFullYear() === day.getFullYear()
            ) {
                return (
                    <span className="m-2 text-success"><strong>Oggi</strong></span>
                )
            }
        }
        return null
    }

    const formatDate = date =>
        date.toLocaleDateString('en-CA', { year: 'numeric', month: '2-digit', day: '2-digit' });

    const compitiDelGiorno = selectedDate && compiti
        ? compiti.filter(c => c.dataConsegna === formatDate(selectedDate))
        : []

    //console.log("compiti: ", compiti)

    return(
        <>
            <TopScetion text={"Esercizi per casa"} />
                <div className="container bg-light p-5">
                    <h2 className="mt-3 mb-3 text-center fs-2">Calendario dei compiti</h2>
                    <Calendar 
                        onChange={setSelectedDate}
                        value={selectedDate}
                        tileContent={tileContent}
                    />
                    {selectedDate && (
                        <div className="mt-4">
                            <h4>Compiti per il {selectedDate.toLocaleDateString()}:</h4>
                            {compitiDelGiorno.length === 0 ? (
                                <p>Nessun compito per questo giorno.</p>
                            ) : (
                                <ul>
                                    {compitiDelGiorno.map(c => (
                                        <li key={c.id}>
                                            <b>{c.incaricoDTO.materiaDTO.nome}.</b> {c.esercizi} <br />
                                            Docente: <i>{c.incaricoDTO.docenteDTO.cognome} {c.incaricoDTO.docenteDTO.nome}</i>
                                        </li>
                                    ))}
                                </ul>
                            )}
                        </div>    
                    )}
                </div >
                {insegnamento && <AddAssignement setCompiti={setCompiti} insegnamenti={insegnamento}/>}
            <Footer />
        </>
    )
}

export default Compiti