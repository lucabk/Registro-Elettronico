import { useState } from "react"
import { toast } from "react-toastify"
import * as materiaService from "../../service/subject"

const UpdateSubject = ({ materia, setMaterie, setFormVisible }) => {
    const [newProgram, setNewProgram] = useState(materia.programma)

    const handleNewProgramOnChange = (event) => {
        setNewProgram(event.target.value)
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        const update = {
            nome : materia.nome,
            codice : materia.codice,
            programma : newProgram
        } 
        try{
            const updatedMateria = await materiaService.updateMateria(update, materia.id)
            setMaterie(prev => prev.map(m => m.id === materia.id ? updatedMateria : m))
            toast.success("Programma didattico aggiornato correttamente")
            setFormVisible(prev => !prev)
        }catch(e){
            toast.error("Errore aggiornamento materia")
            console.error("Errore aggiornamento materia: ", e)
        }
    }

    return(
        <>
            <form onSubmit={handleSubmit} className="row needs-validation m-4">
                <textarea
                    className="form-control"
                    id="programma"
                    name="programma"
                    value={newProgram}
                    onChange={handleNewProgramOnChange}
                    maxLength={65535}
                    required
                    rows={6}
                ></textarea>
                <label htmlFor="programma" className="form-label" >Programma</label>
                <button className="mt-3 btn btn-dark btn-lg">Aggiorna</button>
            </form>
        </>
    )
}

export default UpdateSubject