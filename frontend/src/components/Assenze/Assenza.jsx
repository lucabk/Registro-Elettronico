import Footer from "../Footer"
import TopScetion from "../TopSection"
import * as studentService from "../../service/student"
import * as assenzaService from "../../service/assenza"
import { useQuery } from "@tanstack/react-query"
import { toast } from "react-toastify"
import { useState } from "react"
import SingleAssenza from "./SingleAssenza"

const Assenza = ({ studentId }) => {
    const [showAssenze, setShowAssenze] = useState(false)

    const { data, isPending, error } = useQuery({
        queryKey : ['student'],
        queryFn : () => studentService.getStudentById(studentId)
    })

    const assenze = useQuery({
        queryKey : ['assenze'],
        queryFn : () => assenzaService.getAssenzeByStudente(studentId)
    })


    return(
        <>
            <TopScetion text={"Profilo studente"} />
            {isPending && <span>Caricamento studente in corso...</span>}
            {error && toast.error("Errore caricamento studente")}

            { data && (
                <div className="container bg-light d-flex justify-content-center p-3">
                    <div className="card m-4 fs-5" style={{width: "18rem"}}>
                        <div className="card-header bg-dark text-white">
                            {data?.nome} {data?.cognome}
                        </div>
                        <ul className="list-group list-group-flush ">
                            <li className="list-group-item">Email: <strong>{data?.email}</strong></li>
                            <li className="list-group-item">Numero: <strong>{data?.numero}</strong></li>
                            <li className="list-group-item">Codice Fiscale: <strong>{data?.codiceFiscale}</strong></li>
                        </ul>
                        <div className="card-body">
                            {data?.indirizzo}, {data?.citta} ({data?.provincia}) {data?.cap}
                        </div>
                        <div className="card-footer text-body-secondary p-4">
                            <div className="d-grid gap-3">
                                <button onClick={()=>setShowAssenze(prev => !prev)} type="button" className="btn btn-outline-dark" >
                                    {showAssenze ? "Nascondi assenze" : "Mostra assenze" }
                                </button>
                            </div>
                        </div>
                    </div>

                    { showAssenze && (
                        <div className="container-fluid bg-light p-5">
                            <h2 className="text-center fs-2 mt-5">Assenze</h2>
                            <table className="container table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                                <caption>Tabella assenze</caption>
                                <thead className="table-light">
                                    <tr>
                                        <th className="text-center">Data assenza</th>
                                        <th className="text-center">Tipo</th>
                                        <th className="text-center">Giustificata</th>
                                    </tr>
                                </thead>
                                <tbody className="table-group-divider">
                                    {assenze && assenze.data.map( a => (
                                        <tr key={a.id}>
                                            <SingleAssenza a={a}/>
                                        </tr>
                                    ))}
                                </tbody>
                            </table>
                        </div>
                    )}

                </div>
            )}

            <Footer />
        </>
    )
}

export default Assenza