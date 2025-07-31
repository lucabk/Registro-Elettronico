import { useQuery } from "@tanstack/react-query"
import * as studentService from "../../service/student"
import TopScetion from "../TopSection"
import Footer from "../Footer"
import { toast } from "react-toastify"
import SingleStudent from "./SingleStudent"

const Students = ({ classId }) => {

    const { isPending, isError, data, _error } = useQuery({
        queryKey : ['studenti'],
        queryFn : () => studentService.getStudentsByClasse(classId)
    })

    console.log(data);

    return(
        <>
            <TopScetion text={`Studenti ${data[0]?.classeDTO?.grado}${data[0]?.classeDTO?.lettera}`}/>
            {isPending && <span>Carimanto degli studenti in corso...</span>}
            {isError && toast.error("Errore caricamento studenti")}

            <div className="container-fluid bg-light p-5">
                <h3 className="mt-5 text-center fs-3">Studenti disponibili</h3>
                <table className="container table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                    <caption>Tabella Studenti</caption>
                    <thead className="table-light">
                        <tr>
                            <th className="text-center">Nome</th>
                            <th className="text-center">Cognome</th>
                            <th className="text-center">Email</th>
                            <th className="text-center">Numero</th>
                            <th className="text-center">Codice Fiscale</th>
                            <th className="text-center">Indirizzo</th>
                            <th className="text-center">Città</th>
                            <th className="text-center">Provincia</th>
                            <th className="text-center">CAP</th>
                        </tr>
                    </thead>
                    <tbody className="table-group-divider">
                    {data
                        .slice() // shallow copy per non mutare lo stato
                        .sort((a, b) => {
                            if (a.cognome !== b.cognome) return a.cognome - b.cognome;
                            return a.cognome.localeCompare(b.cognome);
                        })
                        .map(s => 
                            <tr key={s.id}>
                                <SingleStudent student={s} />
                            </tr>
                    )}
                    </tbody>
                </table>
            </div>

            <Footer />
        </>
    )
}  

export default Students