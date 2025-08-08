import { useUser } from "../context/userContext"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import { Link } from "react-router-dom"

const TeacherProfile = ({ teacher }) => {

    const user = useUser()

    return(
        <>
            <TopScetion text={"Profilo docente"} />
            {
                teacher && (
                    <div className="container bg-light p-5">
                        <h2 className="mt-3 mb-3 text-center fs-2">Scheda informativa sul docente</h2>
                        <div className="container bg-light d-flex justify-content-center ">
                            <div className="card m-4 fs-5" style={{width: "18rem"}}>
                                <div className="card-header bg-dark text-white">
                                    {teacher.cognome} {teacher.nome}
                                </div>
                                <ul className="list-group list-group-flush ">
                                    <li className="list-group-item">Username: <strong>{user?.username}</strong></li>
                                    <li className="list-group-item">Email: <strong>{teacher.email}</strong></li>
                                    <li className="list-group-item">Numero: <strong>{teacher.numero}</strong></li>
                                    <li className="list-group-item">Codice Fiscale: <strong>{teacher.codiceFiscale}</strong></li>
                                    <li className="list-group-item">Istruzione: <strong>{teacher.istruzione}</strong></li>
                                </ul>
                                <div className="card-body">
                                    <div className="d-grid gap-3">
                                        <Link to='#'>
                                            <button type="button" className="btn btn-outline-primary" >
                                                Aggiorna informazioni 
                                            </button>
                                        </Link>
                                        <Link to='#'>
                                            <button type="button" className="btn btn-outline-primary" >
                                                Aggiorna password
                                            </button>
                                        </Link>
                                    </div>
                                </div>
                                <div className="card-footer text-body-secondary">
                                    {teacher.indirizzo}, {teacher.citta} ({teacher.provincia}) {teacher.cap}
                                </div>
                            </div>
                        </div>
                    </div>
                )
            }    
            <Footer />
        </>
    )
}

export default TeacherProfile