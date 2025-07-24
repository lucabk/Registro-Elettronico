import { toast } from "react-toastify"
import * as classService from "../../service/class"

const ClasseForm = ({ setClasses, schoolId }) => {

    const handleSubmit = async (formData) => {
        const newClass = {
            grado : formData.get("grado"),
            lettera : formData.get("sezione"),
            annoScolastico : formData.get("annoScolastico"),
            scuolaDTO : {
                id : schoolId
            }
        }
        try{
            const schoolAdded = await classService.addClasse(newClass)
            setClasses(prev => [...prev, schoolAdded])
            toast.success("Scuola aggiunta correttamente")
            console.log("scuola aggiunta: ", schoolAdded)
        }catch(e){
            toast.error("Errore salvataggio classe")
            console.error("Errore salvataggio classe: ", e)
        }
    }

    return(
        <>
         <div className="container p-3 mb-5 mt-3 bg-light text-dark p-5">
                <h2 className="text-center fs-2 mb-4">Aggiungi una classe</h2>
                <form action={handleSubmit} className="row needs-validation">
                    <div className="mt-3 col-4">
                        <label htmlFor="grado" className="form-label" >Grado</label>
                        <input className="form-control" id="grado" type="text" name="grado" placeholder="1" required></input>
                    </div>
                    <div className="mt-3 col-4">
                        <label htmlFor="sezione" className="form-label" >Sezione</label>
                        <input className="form-control" id="sezione" type="text" name="sezione" placeholder="A" maxLength={5} required></input>
                    </div>
                    <div className="mt-3 col-4">
                        <label htmlFor="annoScolastico" className="form-label" >Anno Scolastico</label>
                        <input className="form-control" id="annoScolastico" type="text" name="annoScolastico" placeholder="2025/2026" maxLength={10} required></input>
                    </div>
                    <button className="mt-5 btn btn-dark btn-lg">Aggiungi</button>
                </form>
            </div>
        </>
    )
}

export default ClasseForm