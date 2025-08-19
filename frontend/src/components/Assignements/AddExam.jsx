import { useState } from "react"
import { toast } from "react-toastify"
import * as examServices from "../../service/exams"

const AddExam = ({ setVerifiche, insegnamenti }) => {
    const [selectIncarico, setSelectIncarico] = useState('')
    const [tipologia, setTipologia] = useState('Orale')
    const [argomenti, setArgomenti] = useState('')
    
    const handleSubmit = async (e) => {
        e.preventDefault()
        if(selectIncarico === '' ){
            toast.warning("Seleziona la materia a cui assegnare la verifica")
            return
        }
        const newVerifica = {
            tipo : tipologia.toLowerCase(),
            argomenti,
            dataVerifica : dataConsegna,
            incaricoDTO : { id : selectIncarico }
        }
        try{
            const saved = await examServices.addVerifica(newVerifica)
            setVerifiche(prev => [...prev, saved])
            toast.success("Verifica salvata :D")
        }catch(e){
            toast("Impossibile aggiungere verifica")
            console.error("Impossibile aggiungere verifica: ", e)
        }finally{
            setDataConsegna(minDate)
            setTipologia('Orale')
            setArgomenti('')
            setSelectIncarico('')
        }
    }

    const tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    const minDate = tomorrow.toISOString().split('T')[0];

    const [dataConsegna, setDataConsegna] = useState(minDate)

    return(
        <div className="container bg-light p-5">
            <h3 className="mt-3 mb-3 text-center fs-3">Aggiungi verifica</h3>
            <form onSubmit={handleSubmit}>
                <div className="m-2">
                    <div className="row">
                        <div className="mt-4 col-2">
                            <select value={selectIncarico} onChange={e => setSelectIncarico(e.target.value)} required name="incarico">
                                <option>Seleziona materia</option>
                                {insegnamenti.map(i => (
                                    <option key={i.id} value={i.id}>{i.materiaDTO.nome}</option>
                                ))}
                            </select>
                        </div>
                        <div className="mt-4 col">
                            <select value={tipologia} onChange={e => setTipologia(e.target.value)} required name="tipologia">
                                <option>Orale</option>
                                <option>Scritto</option>
                            </select>
                        </div>
                    </div>
                    <div className="mt-4 ">
                        <label htmlFor="argomenti" className="form-label" >Argomenti verifica</label>
                        <textarea style={{height : 200}} value={argomenti} onChange={e => setArgomenti(e.target.value)}  className="form-control" ud="argomenti" type="text" maxLength={65535} required name="argomenti" ></textarea>
                    </div>
                    <div className="mt-4 ">
                        <label htmlFor="dataConsegna">Data verifica</label>
                        <input id="dataConsegna" className="form-control" type="date" name="dataConsegna" min={minDate} value={dataConsegna} onChange={e => setDataConsegna(e.target.value)} required/>
                    </div>
                    <button className="mt-5 btn btn-dark btn-lg">Aggiungi Verifica</button>
                </div>
            </form>
        </div>
    )
}

export default AddExam