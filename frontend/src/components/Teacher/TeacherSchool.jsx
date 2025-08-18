import Footer from "../Footer"
import TopScetion from "../TopSection"
import SingleIncarico from "../Insegnamenti/SingleIncarico"
import { Link } from "react-router-dom"

const TeacherSchool = ({ teacherId, incarichi, setIncarichi }) => {

    return(
        <>
            <TopScetion text={"Home Page"} />
            {incarichi && (
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
                                    <th className="text-center">Esercizi</th>
                                    <th className="text-center">Verifiche</th>
                                </tr>
                            </thead>
                            <tbody className="table-group-divider">
                            {incarichi
                                .map(i => 
                                    <tr key={i.id}>
                                        <td className="text-center">{i.scuolaDTO.nome}</td>
                                        <td className="text-center">{i.scuolaDTO.citta}</td>
                                        <SingleIncarico incarico={i} setIncarichi={setIncarichi} />
                                        <td className="text-center">
                                            <Link to={`${i.classeDTO.id}/esercizi`} >
                                                <button type="button" className="btn btn-secondary">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" className="bi bi-journal" viewBox="0 0 16 16">
                                                        <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2"></path>
                                                        <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1z"></path>
                                                    </svg>
                                                    <span className="visually-hidden">Aggiungi esercizi</span>
                                                </button>
                                            </Link>
                                        </td>
                                        <td className="text-center">
                                            <Link to={`${i.classeDTO.id}/verifiche`} >
                                                <button type="button" className="btn btn-secondary">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" className="bi bi-journal-check" viewBox="0 0 16 16">
                                                        <path fillRule="evenodd" d="M10.854 6.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 8.793l2.646-2.647a.5.5 0 0 1 .708 0"></path>
                                                        <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2"></path>
                                                        <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1z"></path>
                                                    </svg>
                                                <span className="visually-hidden">Aggiungi verifiche</span>
                                                </button>
                                            </Link>
                                        </td>
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