import Footer from "../Footer"
import TopScetion from "../TopSection"
import { Link, useNavigate } from "react-router-dom"
import * as schoolService from "../../service/schools"
import { toast } from "react-toastify"
import { useState } from "react"
import ClassiScuola from "../Class/ClassiScuola"

const SchoolInfo = ({ school, setSchools, schools }) => {
    const [showClasses, setShowClasses] = useState(false)
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
                <>
                    <div className="container bg-light p-3">
                        <h2 className="mt-3 text-center fs-2">Scheda informativa sulla scuola</h2>
                    </div>
                    <div className="container bg-light d-flex justify-content-center ">
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
                    <div>
                        <div className="container bg-light d-flex justify-content-center p-3">
                            <button type="button" className="btn btn-dark my-2 btn-lg" onClick={()=>setShowClasses(prev => !prev)}>
                                {showClasses ? "Nascondi" : "Mostra"} classi
                            </button>
                        </div>
                        {showClasses && (
                            <ClassiScuola schoolId={school.id}/>
                        )}
                    </div>
                </>
            )  : (
               null
            )
                
            }
            <Footer />
        </>
    ) 
}

export default SchoolInfo