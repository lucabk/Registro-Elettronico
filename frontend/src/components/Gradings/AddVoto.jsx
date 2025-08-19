import { useState } from "react"
import * as gradingService from "../../service/gradings"
import { toast } from "react-toastify"

const AddVoto = ({ studentId, insegnamentiClasse, setValutazioni }) => {
    const [voto, setVoto] = useState("1")
    const [tipologia, setTipologia] = useState('Orale')
    const [selectIncarico, setSelectIncarico] = useState('')

    const handleSubmit = async (e) => {
        e.preventDefault()
        if(selectIncarico === '' ){
            toast.warning("Seleziona la materia a cui assegnare la valutazione")
            return
        }
        const newValutazione = {
            voto : Number(voto),
            tipo : tipologia.toLowerCase(),
            studenteDTO : { id : studentId},
            incaricoDTO : { id : selectIncarico }
        }
        try{
            const saved = await gradingService.addValutazione(newValutazione)
            setValutazioni(prev => [...prev, saved])
            toast.success("Valutazione salvata")
        }catch(e){
            toast.error("Impossibile salvare valutazione")
            console.error("Impossibile salvare valutazione: ", e)
        }finally{
            setTipologia('Orale')
            setVoto("1")
            setSelectIncarico('')
        }
    }

    return(
        <div className="container bg-light p-5 mt-5">
            <h3 className="mt-3 mb-3 text-center fs-3">Aggiungi valutazione</h3>
            <form onSubmit={handleSubmit}>
                <div className="row">
                    <div className="mt-3 col">
                        <select value={selectIncarico} onChange={e => setSelectIncarico(e.target.value)} required name="incarico">
                            <option>Seleziona materia</option>
                            {insegnamentiClasse.map(i => (
                                <option key={i.id} value={i.id}>{i.materiaDTO.nome}</option>
                            ))}
                        </select>
                    </div>
                    <div className="mt-3 col">
                        <select value={tipologia} onChange={e => setTipologia(e.target.value)} required name="tipologia">
                            <option>Orale</option>
                            <option>Scritto</option>
                        </select>
                    </div>
                    <div className="mt-3 col">
                        <span>Valutazione: </span>
                        <select value={voto} onChange={e => setVoto(e.target.value)} required name="voto">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                        </select>
                    </div>
                    <div className="mt-2 col">
                        <button className="btn btn-dark">Valuta</button>
                    </div>
                </div>
            </form>
        </div>
    )
}

export default AddVoto