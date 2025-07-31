import Footer from "../Footer"
import TopScetion from "../TopSection"
import { useQuery } from "@tanstack/react-query"
import * as ClassService from "../../service/class"
import { toast } from "react-toastify"
import { Link } from "react-router-dom"

const ClassInfo = ({ classId }) => {

    const {isPending, isError, data, _error } = useQuery({
        queryKey: ['classi'],
        queryFn: () => ClassService.getClassById(classId)
    })
    

    return(
        <>
            <TopScetion text={`Informazioni sulla classe ${data?.grado}${data?.lettera}`}/>
            {isPending && <span>Carimanto classi in corso...</span>}
            {isError && toast.error("Errore caricamento della classe")}
                <div className="container bg-light d-flex justify-content-center p-3">
                    <div className="card m-4 fs-5" style={{width: "18rem"}}>
                        <div className="card-header bg-dark text-white">
                            {data?.scuolaDTO.nome}
                        </div>
                        <ul className="list-group list-group-flush ">
                            <li className="list-group-item">Grado: <strong>{data?.grado}</strong></li>
                            <li className="list-group-item">Sezione: <strong>{data?.lettera}</strong></li>
                            <li className="list-group-item">Anno Scolastico: <strong>{data?.annoScolastico}</strong></li>
                        </ul>
                        <div className="card-body">
                            <div className="d-grid gap-3">
                                <Link to='students'>
                                    <button type="button" className="btn btn-outline-success" >
                                        Alunni
                                    </button>
                                </Link>
                                <Link to='#'>
                                    <button type="button" className="btn btn-outline-primary" >
                                        Docenti
                                    </button>
                                </Link>
                            </div>
                        </div>
                        <div className="card-footer text-body-secondary">
                            {data?.scuolaDTO.indirizzo}, {data?.scuolaDTO.citta} ({data?.scuolaDTO.provincia})
                        </div>
                    </div>
                </div>
            <Footer />
        </>
    )
}

export default ClassInfo