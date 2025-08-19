import Calendar from "react-calendar"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import { useEffect, useState } from "react"
import * as examService from "../../service/exams"
import { toast } from "react-toastify"
import AddExam from "./AddExam"

const Verifiche = ({ teacher, incarichi, classeId}) => {
    const [verifiche, setVerifiche] = useState([])
    const [selectedDate, setSelectedDate] = useState(null)
    let insegnamento

    useEffect(()=>{
        examService.getVerificheByClasse(classeId)
            .then(res => setVerifiche(res))
            .catch(e => {
                toast.error("Impossibile recuperare verifiche")
                console.error("Impossibile recuperare verifiche: ", e)
            })
    }, [])

    if(incarichi){
        insegnamento = incarichi.filter(i => i.classeDTO.id === classeId)
    }

    const tileContent = ({ date, view }) => {
        if (view == 'month' && verifiche){
            const foundExam = verifiche.find(v => v.dataVerifica === formatDate(date))
            if(foundExam){
                return(
                    <span className="m-2">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" className="bi bi-pencil-square" viewBox="0 0 16 16">
                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>
                            <path fillRule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"></path>
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

    const verficaDelGiorno = selectedDate && verifiche
        ? verifiche.filter(v => v.dataVerifica === formatDate(selectedDate))
        : []

    return(
        <>
            <TopScetion text={"Verifiche"}/>
            <div className="container bg-light p-5">
                <h2 className="mt-t mb-2 text-center fs-2">Calendario delle verifiche</h2>
                <Calendar
                    onChange={setSelectedDate}
                    value={selectedDate}
                    tileContent={tileContent}
                />
                {selectedDate && (
                    <div className="mt-4">
                        <h4>Verifiche per il {selectedDate.toLocaleDateString()}:</h4>
                        {verficaDelGiorno.length === 0 ? (
                            <p>Nessuna verifica per questo giorno.</p>
                        ) : (
                            <ul>
                                {verficaDelGiorno.map(v => (
                                    <li key={v.id}>
                                        <b>{v.incaricoDTO.materiaDTO.nome}</b>. Tipologia: <b>{v.tipo}</b>.<br/>
                                        Argomenti: <b>{v.argomenti}</b>.<br />
                                        Docente: <i>{v.incaricoDTO.docenteDTO.cognome} {v.incaricoDTO.docenteDTO.nome}</i>
                                    </li>
                                ))}
                            </ul>
                        )}
                    </div>
                )}
            </div>
            {insegnamento && <AddExam setVerifiche={setVerifiche} insegnamenti={insegnamento}/>}
            <Footer />
        </>
    )
}

export default Verifiche