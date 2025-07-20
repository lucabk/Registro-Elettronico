import { toast } from "react-toastify"
import * as segreteriaSerive from "../../service/secretaryships"

const SingleSegreteria = ({ segreteria, setSegreterie, segreterie }) => {

    const handleDelete = async (e) => {
        e.preventDefault()
        if(window.confirm("Cancellare segreteria?")){
            try{
                await segreteriaSerive.deleteSegreteria(segreteria.id)
                toast.success("Segreteria eliminata con successo")
                console.log("eliminata segreteria: ", segreteria)
                const segreterieAggiornate = segreterie.filter( s => s.id !== segreteria.id)
                setSegreterie(segreterieAggiornate) 
            }catch(e){
                toast("Errore eliminazione segreteria")
                console.error("Errore eliminazione: ", e)
            }
        }
    }

    return(
        <ul>
            <li>
                <strong>{segreteria.nome}</strong> (id = {segreteria.id})
                <span>
                   <button type="button" onClick={handleDelete} className="btn">
                        <svg xmlns="http://www.w3.org/2000/svg" width="19" height="22" fill="red" className="bi bi-x" viewBox="0 0 16 16">
                            <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"></path>
                        </svg>
                        <span className="visually-hidden">Delete Segreteria</span>
                    </button>
                </span>
            </li>
        </ul>
    )
}

export default SingleSegreteria