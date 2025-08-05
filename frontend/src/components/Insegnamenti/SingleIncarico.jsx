import { useState } from "react"
import UpdateIncarico from "./UpdateIncarico"
import * as incaricoService from "../../service/incarico"
import { toast } from "react-toastify"


const SingleIncarico = ({ incarico, setIncarichi }) => {
    const [showForm, setShowForm] = useState(false)

    const handleDelete = async (e) => {
        e.preventDefault()
        if(window.confirm("Cancellare insegnamento?")){
            try{
                await incaricoService.deleteIncarico(incarico.id)
                setIncarichi(prev => prev.filter(i => i.id !== incarico.id))
                toast.success("Insegnamento eliminato correttamente")
            }catch(e){
                toast.error("Impossibile eliminare incarico")
                console.error("Impossibile eliminare incarico: ", e)
            }
        }
    }

    return(
        <>
            <td className="text-center">{incarico?.classeDTO.grado}{incarico?.classeDTO.lettera}</td>
            <td className="text-center">{incarico?.materiaDTO.nome}</td>
            <td className="text-center">{incarico?.docenteDTO.cognome} {incarico?.docenteDTO.nome}</td>
            <td className="text-center">
                {showForm ? (
                    <UpdateIncarico  
                        setIncarichi={setIncarichi}
                        incarico={incarico}
                        setShowForm={setShowForm}
                    />
                ) : (
                    incarico?.programma
                )}
            </td>
            <td className="text-center">{incarico?.classeDTO.annoScolastico}</td>
            <td className="text-center">
                {showForm ? (
                        <button className="btn btn-dark" onClick={()=>setShowForm(false)}>Nascondi</button>
                ) : (
                    <button type="button" className="btn btn-outline-secondary" onClick={()=>setShowForm(true)}>
                        <svg xmlns="http://www.w3.org/2000/svg" width="26" height="24" fill="green" className="bi bi-arrow-clockwise" viewBox="0 0 16 16">
                            <path fillRule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2z"></path>
                            <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466"></path>
                        </svg>
                        <span className="visually-hidden">Update Incarico</span>
                    </button>
                )}
            </td>
            <td className="text-center">
                <button type="button" onClick={handleDelete} className="btn">
                    <svg xmlns="http://www.w3.org/2000/svg" width="26" height="24" fill="red" className="bi bi-x" viewBox="0 0 16 16">
                        <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"></path>
                    </svg>
                    <span className="visually-hidden">Delete incarico</span>
                </button>
            </td>
        </>
    )
}

export default SingleIncarico