import Footer from "../Footer"
import TopScetion from "../TopSection"
import { useNavigate } from "react-router-dom"
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

                <div className="container-fluid m-3 p-3">
                    <div className="container bg-light d-flex justify-content-center ">
                        <div className="card bg-dark text-white m-5 fs-5" style={{width: "18rem"}}>
                            <div className="card-header">
                                {school.nome}
                            </div>
                            <ul className="list-group list-group-flush ">
                                <li className="list-group-item">{school.tipo}</li>
                                <li className="list-group-item">{school.indirizzo}</li>
                                <li className="list-group-item">{school.citta}</li>
                                <li className="list-group-item">{school.provincia}</li>
                                <li className="list-group-item">{school.cap}</li>
                                <li className="list-group-item">{school.regione}</li>
                            </ul>
                        </div>
                    </div>
                        <div className="container-fluid p-3 mb-2 bg-light d-flex justify-content-center">
                            <button type="button" className="btn btn-outline-danger" onClick={handleDelete}>
                                Elimina scuola
                            </button>
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