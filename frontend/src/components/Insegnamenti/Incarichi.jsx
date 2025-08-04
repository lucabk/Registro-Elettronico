import { useEffect, useState } from "react"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import SingleIncarico from "./SingleIncarico"
import * as incaricoSerivce from "../../service/incarico"
import { toast } from "react-toastify"

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
                                            <SingleIncarico incarico={i}/>
                                        </tr>
                                    )
                            )
                        }
                    </tbody>
                </table>
            </div>

            <Footer />
        </>
    )
}

export default Incarichi