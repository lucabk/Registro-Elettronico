import { useState } from "react"
import * as assignementService from "../../service/assignements"
import { toast } from "react-toastify"

const AddAssignement = ({ setCompiti, insegnamenti }) => {
    const [selectIncarico, setSelectIncarico] = useState('')
    const [exercises, setExercises] = useState('')

    const handleSubmit = async (e) => {
        e.preventDefault()
        if(selectIncarico === ''){
            toast.warning("Seleziona la materia a cui aggiungere i compiti")
            return
        }
        const newAssignement = {
            incaricoDTO : { id : selectIncarico},
            esercizi : exercises,
            dataConsegna 
        }
        try{
            const saved = await assignementService.addCompiti(newAssignement)
            setCompiti(prev => [...prev, saved])
            toast.success("Compiti aggiunti :)")
        }catch(e){
            toast.error("Impossibile salvare i compiti")
            console.error("Impossibile salvare i compiti: ", e)
        }finally{
            setSelectIncarico('')
            setExercises('')
            setDataConsegna(minDate)
        }
    }

    const tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    const minDate = tomorrow.toISOString().split('T')[0];

    const [dataConsegna, setDataConsegna] = useState(minDate)

    return(
        <div className="container bg-light p-5">
            <h3 className="mt-3 mb-3 text-center fs-3">Assegna compiti</h3>
            <form onSubmit={handleSubmit}>
                <div className="mt-4 ">
                    <select value={selectIncarico} onChange={e => setSelectIncarico(e.target.value)} required name="incarico">
                        <option>Seleziona materia</option>
                        {insegnamenti.map(i => (
                            <option key={i.id} value={i.id}>{i.materiaDTO.nome}</option>
                        ))}
                    </select> 
                </div>
                <div className="mt-4 ">
                    <label htmlFor="esercizi" className="form-label">Esericizi per casa</label> 
                    <textarea style={{height : 200}} value={exercises} onChange={e => setExercises(e.target.value)} className="form-control" id="esercizi" name="esercizi" type="text" required maxLength={65535}></textarea>
                </div>
                <div className="mt-4 ">
                    <label htmlFor="dataConsegna">Data consegna</label>
                    <input id="dataConsegna" className="form-control" type="date" name="dataConsegna" min={minDate} value={dataConsegna} onChange={e => setDataConsegna(e.target.value)} required/>
                </div>
                <button className="mt-5 btn btn-dark btn-lg">Aggiungi Esercizi</button>
            </form>
        </div>
    )
}

export default AddAssignement