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
                                            <Link to={`${i.classeDTO.id}/esercizi`}>
                                                Esercizi
                                            </Link>
                                        </td>
                                        <td className="text-center">
                                            <Link to={`${i.classeDTO.id}/verifiche`}>
                                                Verifiche
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