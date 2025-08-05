import { useState } from "react";
import { toast } from "react-toastify";
import * as incaricoService from "../../service/incarico"

const UpdateIncarico = ({ setIncarichi, incarico, setShowForm }) => {
    const [programma, setProgramma] = useState(incarico?.programma)

    const handleSubmit = async (e) => {
        e.preventDefault()
        const newIncarico = {
            ...incarico, 
            programma 
        }
        try{
            const updated = await incaricoService.updateIncarico(incarico.id, newIncarico)
            setIncarichi(prev => prev.map(i => i.id === incarico.id ? updated : i))
            toast.success("Pogramma aggiornato correttamente")
        }catch(e){
            toast.error("Errore aggiornamento incarico")
            console.error("Errore aggiornamento incarico: ", e)
        }finally{
            setProgramma("")
            setShowForm(false)
        }
    }

    return(
        <form onSubmit={handleSubmit} className="row needs-validation">
            <div className="mt-3">
                <label htmlFor="programma" className="form-label">Aggiorna programma della materia</label> 
                <textarea style={{height : 200}} value={programma} onChange={e => setProgramma(e.target.value)} className="form-control" id="programma" name="programma" type="text" placeholder="Dante, Virgilio, ..." required maxLength={65535}></textarea>
            </div>
            <button className="mt-2 btn btn-dark btn-sm">Aggiorna</button>
        </form>
    )
}

export default UpdateIncarico