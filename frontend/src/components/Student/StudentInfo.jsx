import TopScetion from "../TopSection"
import Footer from "../Footer"
import * as studentService from "../../service/student"
import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query"
import { toast } from "react-toastify"
import { useState } from "react"
import UpdateStudentForm from "./UpdateStudentForm"
import { useEffect } from "react"

const StudentInfo = ({ studentId }) => {
    const [showForm, setShowForm] = useState(false)
    const queryClient = useQueryClient()

    const { data, isPending, _isError, error } = useQuery({
        queryKey : ['student'],
        queryFn : () => studentService.getStudentById(studentId)
    })

    const updateStudentMutation = useMutation({
        mutationFn : studentService.updateStudente,
        onSuccess : (studentUpdated) => {
            queryClient.setQueryData(['student'], studentUpdated)
            toast.success("Informazioni aggiornate correttamente")
        },
        onError : (e) => {
            toast.error("Errore aggiornamento studente")
            console.error("Errore aggiornamento studente: ", e)
        }
    })

    useEffect(() => {
        if (error) {
            toast.error("Errore caricamento studente")
        }
    }, [error])

    return(
        <>
        <TopScetion text={"Dettagli dello studente"} />
        {isPending && <span>Caricamento studente in corso...</span>}
        { data && (
            <div className="container bg-light d-flex justify-content-center p-3">
                <div className="card m-4 fs-5" style={{width: "18rem"}}>
                    <div className="card-header bg-dark text-white">
                        {data?.nome} {data?.cognome}
                    </div>
                    <ul className="list-group list-group-flush ">
                        <li className="list-group-item">Email: <strong>{data?.email}</strong></li>
                        <li className="list-group-item">Numero: <strong>{data?.numero}</strong></li>
                        <li className="list-group-item">Codice Fiscale: <strong>{data?.codiceFiscale}</strong></li>
                    </ul>
                    <div className="card-body">
                        {data?.indirizzo}, {data?.citta} ({data?.provincia}) {data?.cap}
                    </div>
                    <div className="card-footer text-body-secondary p-4">
                        <div className="d-grid gap-3">
                            <button onClick={()=>setShowForm(prev => !prev)} type="button" className="btn btn-outline-dark" >
                                {showForm ? "Nascondi" : "Aggiorna i dati dello studente" }
                            </button>
                        </div>
                    </div>
                </div>

                { showForm && (
                    < UpdateStudentForm 
                        updateStudentMutation={updateStudentMutation} 
                        student={data}
                        setShowForm={setShowForm}
                    />
                )}

            </div>
        )}
        <Footer />
        </>
    )
}

export default StudentInfo