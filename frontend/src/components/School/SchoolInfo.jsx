import Footer from "../Footer"
import TopScetion from "../TopSection"
import { Link, useNavigate } from "react-router-dom"
import * as schoolService from "../../service/schools"
import { toast } from "react-toastify"


const SchoolInfo = ({ school, setSchools, schools }) => {
    const navigate = useNavigate()

    const handleDelete = async (e) => {
        e.preventDefault()
        if (window.confirm(`Cancella scuola ${school.nome}?`)){
            try{
                await schoolService.deleteSchool(school.id)
                toast.success(`Scuola ${school.nome} eliminata correttamente`)
                console.log("cancellata scuola con id: ", school.id)
            } catch(e){
                toast.error("Errore eliminazione scuola")
                console.error("Errore eliminazione scuola: ", e)
            }//tolgo la scuola anche se errore (probabilmente perché già è stata eliminata da db)
            const newSchools = schools.filter(s => s.id !== school.id) 
            setSchools(newSchools)
            navigate('/')
        }
    }

    return(
        <>
            <TopScetion text={"Scuola info"} />
            { school ? (
                <div className="container bg-light d-flex justify-content-center ">
                    <div className="card m-5 fs-5" style={{width: "18rem"}}>
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
                            <Link to='update'>
                                <button type="button" className="btn btn-outline-warning" >
                                    Aggiorna 
                                </button>
                            </Link>
                                <button type="button" className="btn btn-outline-danger" onClick={handleDelete}>
                                    Elimina
                                </button>
                            </div>
                        </div>
                        <div className="card-footer text-body-secondary">
                            {school.indirizzo}, {school.citta} ({school.provincia})
                        </div>
                    </div>
                </div>
            )  : (
               null
            )
                
            }
            <Footer />
        </>
    ) 
}

export default SchoolInfo