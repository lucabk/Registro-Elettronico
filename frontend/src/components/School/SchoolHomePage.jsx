import Footer from "../Footer"
import TopSection from "../TopSection"
import { Link } from "react-router-dom"

const SchoolHomePage = ({ school }) => {
    return(
        <>
            <TopSection text={"Home Page della scuola"} />
            <div className="container bg-light p-3">
                <h2 className="mt-5 text-center fs-2">Scheda informativa sulla scuola</h2>
            </div>
            { school && (
                <div className="container bg-light d-flex justify-content-center p-3">
                    <div className="card m-4 fs-5" style={{width: "18rem"}}>
                        <div className="card-header bg-dark text-white">
                            {school.nome}
                        </div>
                        <ul className="list-group list-group-flush ">
                            <li className="list-group-item">Indirizzo di studi: {school.tipo}</li>
                            <li className="list-group-item">CAP: {school.cap}</li>
                            <li className="list-group-item">Regione: {school.regione}</li>
                        </ul>
                        <div className="card-body">
                            <div className="d-grid gap-3">
                                <Link to='classi'>
                                    <button type="button" className="btn btn-outline-info" >
                                        Classi disponibili
                                    </button>
                                </Link>
                            </div>
                        </div>
                        <div className="card-footer text-body-secondary">
                            {school.indirizzo}, {school.citta} ({school.provincia})
                        </div>
                    </div>
                </div>
            )}
            <Footer/>
        </>
    )
}

export default SchoolHomePage