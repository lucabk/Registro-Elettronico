import { useEffect, useState } from "react"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import SingleIncarico from "./SingleIncarico"
import * as incaricoSerivce from "../../service/incarico"
import { toast } from "react-toastify"
import IncaricoForm from "./IncaricoForm"

const Incarichi = ({ classId, schoolId }) => {

    const [incarichi, setIncarichi] = useState([])

    useEffect(()=>{
        incaricoSerivce.getIncarichiByClasse(classId)
            .then(res => setIncarichi(res))
            .catch(e => {
                toast.error("Impossibile recuperare incarichi")
                console.error("Impossibile recuperare incarichi: ", e)
            })
    }, [])

    //console.log("incarichi: ", incarichi)

    return(
        <>
            <TopScetion text={"Insegnamenti"} />
             <div className="container-fluid p-3 bg-light text-dark p-5">
                <h2 className="text-center fs-2 mb-4">Insegnamenti per la classe</h2>
                <table className="container-fluid table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                    <caption>Tabella Insegnamenti</caption>
                    <thead className="table-light">
                        <tr>
                            <th className="text-center">Classe</th>
                            <th className="text-center">Materia</th>
                            <th className="text-center">Docente</th>
                            <th className="text-center">Programma</th>
                            <th className="text-center">Anno Scolastico</th>
                            <th className="text-center">Aggiorna Programma</th>
                            <th className="text-center">Elimina Insegnamento</th>
                        </tr>
                    </thead>
                    <tbody className="table-group-divider">
                        {
                            incarichi && (
                                incarichi
                                    .slice()
                                    .sort((a, b) => a.materiaDTO.nome.localeCompare(b.materiaDTO.nome))
                                    .map( i => 
                                        <tr key={i.id}>
                                            <SingleIncarico incarico={i} setIncarichi={setIncarichi}/>
                                        </tr>
                                    )
                            )
                        }
                    </tbody>
                </table>
            </div>

            <IncaricoForm 
                classId={classId}
                schoolId={schoolId}
                setIncarichi={setIncarichi}
            />

            <Footer />
        </>
    )
}

export default Incarichi