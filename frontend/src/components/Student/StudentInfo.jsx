import TopScetion from "../TopSection"
import Footer from "../Footer"
import * as studentService from "../../service/student"
import { useQuery } from "@tanstack/react-query"
import { toast } from "react-toastify"
import { Link } from "react-router-dom"

const StudentInfo = ({ studentId }) => {

    const { data, isPending, isError, _error } = useQuery({
        queryKey : ['student'],
        queryFn : () => studentService.getStudentById(studentId)
    })

    return(
        <>
        <TopScetion text={"Dettagli dello studente"} />
        {isPending && <span>Caricamento studente in corso...</span>}
        {isError && toast.error("Errore caricamento studente")}

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
                            <Link to='#'>
                                <button type="button" className="btn btn-outline-dark" >
                                    Aggiorna i dati dello studente
                                </button>
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        )}
        <Footer />
        </>
    )
}

export default StudentInfo