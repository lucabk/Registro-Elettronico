import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query"
import * as studentService from "../../service/student"
import TopScetion from "../TopSection"
import Footer from "../Footer"
import SingleStudent from "./SingleStudent"
import { useState } from "react"
import AddStudentForm from "./AddStudentForm"
import { toast } from "react-toastify"

const Students = ({ classId, schoolId }) => {
    const [showModal, setShowModal] = useState(false);
    const queryClient = useQueryClient()

    const { isPending, data } = useQuery({
        queryKey : ['students'],
        queryFn : () => studentService.getStudentsByClasse(classId)
    })

    const addStudentMutation = useMutation({
        mutationFn : studentService.addStudente,
        onSuccess : (addedStudente) => {
            const students = queryClient.getQueryData(['students'])
            queryClient.setQueryData(['students'], students.concat(addedStudente))
            toast.success("Studente salvato correttamente")
        },
        onError : (e) => {
            toast.error("Errore salvataggio studente")
            console.error("Errore salvataggio studente: ", e)
            if(e.response.data){
                toast.error(e.response.data.message)
            }
        }
    })

    //console.log(data);

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
                            <th className="text-center">Nome</th>
                            <th className="text-center">Cognome</th>
                            <th className="text-center">Email</th>
                            <th className="text-center">Numero</th>
                            <th className="text-center">Codice Fiscale</th>
                            <th className="text-center">Indirizzo</th>
                            <th className="text-center">Città</th>
                            <th className="text-center">Provincia</th>
                            <th className="text-center">CAP</th>
                            <th className="text-center">Info</th>
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
                                <SingleStudent student={s} />
                            </tr>
                    )}
                    </tbody>
                </table>
            </div>
            
            {/* Button trigger modal */}
            <div className="container-fluid bg-light p-2">
                <div className="d-grid col-2 mx-auto">
                    <button type="button" className="mt-5 btn btn-dark btn-lg" onClick={() => setShowModal(true)}>
                        Aggiungi Studente
                    </button>
                </div>

                {/* Modal */}
                {showModal && (
                    <div className="modal show d-block" tabIndex="-1">
                        <div className="modal-dialog modal-dialog-centered">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <h1 className="modal-title fs-5">Nuovo Studente</h1>
                                    <button 
                                        type="button" className="btn-close" onClick={() => setShowModal(false)}>
                                    </button>
                                </div>
                                <div className="modal-body">
                                    <AddStudentForm 
                                        addStudentMutation={addStudentMutation}
                                        schoolId={schoolId}
                                        classId={classId}
                                        setShowModal={setShowModal}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                )}
            </div>

            <Footer />
        </>
    )
}  

export default Students