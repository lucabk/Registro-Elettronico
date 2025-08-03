import { useEffect, useState } from "react"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import * as teacherService from "../../service/teacher"
import { toast } from "react-toastify"
import SingleTeacher from "../Subject/SingleTeacher"
import AddTeacher from "./AddTeacher"

const GetTeachers = () => {

    const [teachers, setTeachers] = useState([])

    useEffect(()=>{
        teacherService.getTeachers()
            .then(t => setTeachers(t))
            .catch(e => {
                toast.error("Errore recupero docenti nel database")
                console.error("Errore recupero docenti nel database: ", e)
            })
    }, [])

    return(
        <>
            <TopScetion text={"Portale corpo docenti"} />
            <div className="container-fluid p-3 bg-light text-dark p-5">
                <h2 className="text-center fs-2 mb-4">Docenti disponibili nel database</h2>
                <table className="container-fluid table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                    <caption>Tabella Docenti</caption>
                    <thead className="table-light">
                        <tr>
                            <th className="text-center">Cognome</th>
                            <th className="text-center">Nome</th>
                            <th className="text-center">Email</th>
                            <th className="text-center">Numero</th>
                            <th className="text-center">Codice Fiscale</th>
                            <th className="text-center">Indirizzo</th>
                            <th className="text-center">Città</th>
                            <th className="text-center">Provincia</th>
                            <th className="text-center">CAP</th>
                            <th className="text-center">Istruzione</th>
                            <th className="text-center">Aggiorna</th>
                            <th className="text-center">Cancella</th>
                        </tr>
                    </thead>
                    <tbody className="table-group-divider">
                        {
                            teachers && (
                                teachers
                                    .slice()
                                    .sort((a, b) => a.cognome.localeCompare(b.cognome))
                                    .map( t => 
                                        <tr key={t.id}>
                                            <SingleTeacher teacher={t} setTeachers={setTeachers}/>
                                        </tr>
                                    )
                            )
                        }
                    </tbody>
                </table>
            </div>

            <AddTeacher setTeachers={setTeachers} />

            <Footer />
        </>
    )
}

export default GetTeachers