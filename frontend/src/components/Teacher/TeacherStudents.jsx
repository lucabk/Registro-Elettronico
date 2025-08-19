import { useQuery } from "@tanstack/react-query"
import * as studentService from "../../service/student"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import SingleStudentTeacher from "./SingleStudentTeacher"

const TeacherStudents = ({ classeId }) => {
    let insegnamentiClasse
    
    const { isPending, data } = useQuery({
        queryKey : ['students'],
        queryFn : () => studentService.getStudentsByClasse(classeId)
    })

    return(
        <>
         <TopScetion text={`Studenti ${data && data[0]?.classeDTO?.grado}${data && data[0]?.classeDTO?.lettera}`}/>
            {isPending && <span>Caricamento degli studenti in corso...</span>}

            {/* Tabella stduenti della classe */}
            <div className="container-fluid bg-light p-5">
                <h2 className="mt-5 text-center fs-2">Studenti disponibili</h2>
                <table className="container table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                    <caption>Tabella Studenti</caption>
                    <thead className="table-light">
                        <tr>
                            <th className="text-center">Cognome</th>
                            <th className="text-center">Nome</th>
                            <th className="text-center">Voti</th>
                            <th className="text-center">Profilo</th>
                        </tr>
                    </thead>
                    <tbody className="table-group-divider">
                    {data && data
                        .slice() // shallow copy per non mutare lo stato
                        .sort((a, b) => {
                            if (a.cognome !== b.cognome) return a.cognome - b.cognome;
                            return a.cognome.localeCompare(b.cognome);
                        })
                        .map(s => 
                            <tr key={s.id}>
                                <SingleStudentTeacher 
                                    studente={s} 
                                    insegnamentiClasse={insegnamentiClasse}
                                />
                            </tr>
                    )}
                    </tbody>
                </table>
            </div>
            <Footer />
        </>
    )
}

export default TeacherStudents