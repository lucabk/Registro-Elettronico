import { toast } from "react-toastify"
import * as materiaService from "../../service/subject"

const AddSubjectForm = ({ setMaterie }) => {

    const handleSubmit = async (formData) => {
        const newMateria = {
            nome : formData.get("nome"),
            codice : formData.get("codice"),
        }
        try{
            const saved = await materiaService.addMateria(newMateria)
            setMaterie(prev => [...prev, saved])
            toast.success("Materia salvata correttamente")
        }catch(e){
            toast.error("Errore salvataggio materia")
            console.error("Errore salvataggio materia: ", e)
        }
    }

    return(
        <>
            <div className="container mt-4 p-3 bg-light text-dark p-5">
                <h2 className="text-center fs-2 mb-4">Aggiungi materia</h2>
                 <form action={handleSubmit} className="row needs-validation">
                    <div className="mt-3 col-4">
                        <label htmlFor="codice" className="form-label" >Identificativo</label>
                        <input className="form-control" id="codice" type="text" name="codice" placeholder="ITA01" maxLength={10} required></input>
                    </div>
                    <div className="mt-3 col-4">
                        <label htmlFor="nome" className="form-label" >Insegnamento</label>
                        <input className="form-control" id="nome" type="text" name="nome" placeholder="Italiano" maxLength={50} required></input>
                    </div>
                    <button className="mt-5 btn btn-dark btn-lg">Aggiungi</button>
                </form>
            </div>
        </>
    )
}

export default AddSubjectForm