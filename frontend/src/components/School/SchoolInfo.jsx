import Footer from "../Footer"
import TopScetion from "../TopSection"
import { useNavigate } from "react-router-dom"

const SchoolInfo = ({ school }) => {
    const navigate = useNavigate()

    const handleDelete = async (e) => {
        e.preventDefault()
        if (window.confirm(`Cancella scuola ${school.nome}?`)){
            try{
                //API call + state modification
                console.log("cancellata scuola con id: ", school.id)
            } catch(e){
                console.error("Errore eliminazione scoola: " ,e)
            }
            navigate('/')
        }
    }

    return(
        <>
            <TopScetion text={"Scuola info"} />
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
            <Footer />
        </>
    ) 
}

export default SchoolInfo