import { useEffect, useState } from "react"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import * as materiaService from "../../service/subject"
import { toast } from "react-toastify"
import SingleMateria from "./SingleMateria"
import AddSubjectForm from "./AddSubjectForm"

const GetSubjects = () => {
    const [materie, setMaterie] = useState([])

    useEffect(()=>{
        materiaService.getMaterie()
            .then(res => setMaterie(res))
            .catch(e => {
                toast.error("Errore recupero materie")
                console.error("Errore recupero materie: ", e)
            })
    }, [])

    return(
        <>
            <TopScetion text={"Materie"} />
            <div className="container-fluid p-3 bg-light text-dark p-5">
                <h2 className="text-center fs-2 mb-4">Insegnamenti disponibili nel database</h2>
                <table className="container table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                    <caption>Tabella Materie</caption>
                    <thead className="table-light">
                        <tr>
                            <th className="text-center">Identificativo</th>
                            <th className="text-center">Insegnamento</th>
                            <th className="text-center">Programma</th>
                            <th className="text-center">Aggiorna</th>
                            <th className="text-center">Elimina</th>
                        </tr>
                    </thead>
                    <tbody className="table-group-divider">
                        {
                            materie && (
                                materie
                                    .slice()
                                    .sort((a, b) => a.codice.localeCompare(b.codice))
                                    .map( m => 
                                        <tr key={m.id}>
                                            <SingleMateria materia={m} />
                                        </tr>
                                    )
                            )
                        }
                    </tbody>
                </table>
            </div>

            <AddSubjectForm setMaterie={ setMaterie }/>

            <Footer />
        </>
    )
}

export default GetSubjects