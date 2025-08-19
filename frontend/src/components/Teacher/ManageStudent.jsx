import { useEffect, useState } from "react"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import * as gradingService from "../../service/gradings"
import { toast } from "react-toastify"
import AddVoto from "../Gradings/AddVoto"

const ManageStudent = ({ studentId, incarichi, classId, teacher }) => {
    const [valutazioni, setValutazioni] = useState([])

    useEffect(()=>{
        gradingService.getValutazioneByStudente(studentId)
            .then(res => setValutazioni(res))
            .catch(e => {
                toast.error("Impossibile recuperare le valutazioni")
                console.error("Impossibile recuperare le valutazioni: ", e)
            })
    }, [])

    let insegnamentiClasse 
    if(incarichi){
        insegnamentiClasse = incarichi.filter(i => i.classeDTO.id === classId)
    }

    const valutazioniPerMateria = {};
    if (valutazioni) {
        valutazioni.forEach(v => {
            const materia = v.incaricoDTO.materiaDTO.nome;
            if (!valutazioniPerMateria[materia]) {
                valutazioniPerMateria[materia] = [];
            }
            valutazioniPerMateria[materia].push(v);
        });
    }

    const handleDelete = (val) => async (e) => {
        e.preventDefault()
        if(val.incaricoDTO.docenteDTO.id === teacher.id && window.confirm("Cancellare valutazione?")){
            try{
                await gradingService.deleteValutazione(val.id)
                setValutazioni(prev => prev.filter(v => v.id !== val.id))
                toast.success("Valutazione eliminata")
            }catch(e){
                toast.error("Impossibile eliminare la valutazione")
                console.error("Impossibile eliminare la valutazione: ", e)
            }
        }
    }

    return(
        <>
            <TopScetion text={"Valutazioni studente"} />
                <div className="container-fluid bg-light p-5">
                    { valutazioni && valutazioni.length > 0 ? (
                        <>
                            <h2 className="mt-2 text-center fs-2">{`Voti di ${valutazioni[0].studenteDTO.cognome} ${valutazioni[0].studenteDTO.nome}`}</h2>
                            <div className="row">
                                {
                                    Object.entries(valutazioniPerMateria).map(([materia, voti]) => (
                                        <div key={materia} className="col mt-5">
                                            <h4 className="fs-4">{materia}</h4>
                                            <ul>
                                            {voti.map(val => (
                                                <li key={val.id}>
                                                {val.tipo}: {val.voto}
                                                {teacher?.id === val.incaricoDTO.docenteDTO.id && (
                                                     <button type="button" onClick={handleDelete(val)} className="btn">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="26" height="24" fill="red" className="bi bi-x" viewBox="0 0 16 16">
                                                            <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"></path>
                                                        </svg>
                                                        <span className="visually-hidden">Delete grade</span>
                                                    </button>
                                                )}
                                                </li>
                                            ))}
                                            </ul>
                                        </div>
                                    ))
                                }
                            </div>
                        </>
                    ) : (
                        <p>Nessuna valutazione disponibile.</p>
                    )}
                </div>
                < AddVoto studentId={studentId} insegnamentiClasse={insegnamentiClasse} setValutazioni={setValutazioni} />
            <Footer />
        </>
    )
}

export default ManageStudent