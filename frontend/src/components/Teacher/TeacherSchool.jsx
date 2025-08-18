import { useEffect, useState } from "react"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import * as incaricoService from "../../service/incarico"
import { toast } from "react-toastify"
import SingleIncarico from "../Insegnamenti/SingleIncarico"

const TeacherSchool = ({ teacherId }) => {
    const [incarico, setIncarico] = useState(null)

    useEffect(()=>{
        incaricoService.getIncaricoByDocente(teacherId)
            .then(res => setIncarico(res))
            .catch(e => {
                toast.error("Impossibile recuperare incarico docente")
                console.error("Impossibile recuperare incarico docente: ", e)
            })
    }, [])

    console.log("incarico: ", incarico)

    return(
        <>
            <TopScetion text={"Home Page"} />
            {incarico && (
                <div className="container bg-light p-5">
                    <h2 className="mt-3 mb-3 text-center fs-2">Sedi scolastiche ed insegnamenti</h2>
                    <div className="container bg-light d-flex justify-content-center ">
                        <table className="container table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                            <caption>Tabella Insegnamenti</caption>
                            <thead className="table-light">
                                <tr>
                                    <th className="text-center">Scuola</th>
                                    <th className="text-center">Città</th>
                                    <th className="text-center">Classe</th>
                                    <th className="text-center">Materia</th>
                                    <th className="text-center">Docente</th>
                                    <th className="text-center">Programma</th>
                                    <th className="text-center">Anno Scolastico</th>
                                    <th className="text-center">Aggiorna Programma</th>
                                    <th className="text-center">Elimina Insegnamento</th>
                                </tr>
                            </thead>
                            <tbody className="table-group-divider">
                            {incarico
                                .map(i => 
                                    <tr key={i.id}>
                                        <td>{i.scuolaDTO.nome}</td>
                                        <td>{i.scuolaDTO.citta}</td>
                                        <SingleIncarico incarico={i} setIncarichi={setIncarico} />
                                    </tr>
                            )}
                            </tbody>
                        </table>
                    </div>
                </div>
                )
            }
            <Footer />
        </>
    )
}

export default TeacherSchool