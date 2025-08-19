import { useEffect, useState } from "react"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import * as gradingService from "../../service/gradings"
import { toast } from "react-toastify"

const ManageStudent = ({ studentId, incarichi, classId }) => {
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

    console.log("ManageStudent insegnamentiClasse: ", insegnamentiClasse)
    console.log("Valutazioni: ", valutazioni)

    return(
        <>
            <TopScetion text={"Valutazioni studente"} />
                <div className="container-fluid bg-light p-5">
                    { valutazioni && valutazioni.length > 0 ? (
                        <>
                            <h2 className="mt-2 text-center fs-2">{`${valutazioni[0].studenteDTO.cognome} ${valutazioni[0].studenteDTO.nome}`}</h2>
                            <div className="row">
                                {
                                    Object.entries(valutazioniPerMateria).map(([materia, voti]) => (
                                        <div key={materia} className="col mt-5">
                                            <h4 className="fs-4">{materia}</h4>
                                            <ul>
                                            {voti.map(val => (
                                                <li key={val.id}>
                                                {val.tipo}: {val.voto}
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
            <Footer />
        </>
    )
}

export default ManageStudent