import Footer from "../Footer"
import TopScetion from "../TopSection"
import { useQuery } from "@tanstack/react-query"
import * as assenzaService from "../../service/assenza"

const SingleStudentAssenza = ({ studentId }) => {

    const assenze = useQuery({
        queryKey : ['assenze'],
        queryFn : () => assenzaService.getAssenzeByStudente(studentId)
    })

    return(
        <>  
            <TopScetion text={"Assenze"} />
            <div className="container-fluid bg-light p-5">
                <h2 className="text-center fs-2">Tabella delle assenze</h2>
                <table className="container table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                    <caption>Tabella assenze</caption>
                    <thead className="table-light">
                        <tr>
                            <th className="text-center">Data assenza</th>
                            <th className="text-center">Tipo</th>
                            <th className="text-center">Giustificata</th>
                        </tr>
                    </thead>
                    <tbody className="table-group-divider">
                        {assenze.data && assenze.data.map( a => (
                            <tr key={a.id}>
                                <td className="text-center">{a.dataInserimento?.split("T")[0]}</td>
                                <td className="text-center">{a.tipo}</td>
                                <td className="text-center">{a.giustificata ? "Sì" : "No"}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <Footer />
        </>
    )
}

export default SingleStudentAssenza