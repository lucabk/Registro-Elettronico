import * as classService from "../../service/class"
import { toast } from "react-toastify"

const UpateClass = ({ singleClass, setClasses, classes }) => {

    const handleUpdate = async (formData) => {
        const newClass = {
            grado : formData.get("grado"),
            lettera : formData.get("sezione"),
            annoScolastico : formData.get("annoScolastico")
        }
        try{
            const classUp = await classService.updateClass(singleClass.id, newClass)
            const classesUpdated = classes.map( c => c.id !== singleClass.id ? c : classUp)
            setClasses(classesUpdated)
            toast.success("Classe aggiornata correttamente")
            console.log("Aggiornata classe ", singleClass.id)
        }catch(e) {
            toast.error("Errore aggiornamento della classe")
            console.error("Errore aggiornamento classe ", e)
        }
    }

    return(
        <>
            <div className="container p-3 mb-5 mt-3 bg-light text-dark p-5">
                <h2 className="text-center fs-2 mb-4">Aggiorna la classe</h2>
                <form action={handleUpdate} className="row needs-validation">
                    <div className="mt-3 col-4">
                        <label htmlFor="grado" className="form-label" >Grado</label>
                        <input className="form-control" id="grado" type="text" name="grado" placeholder={singleClass.grado} required></input>
                    </div>
                    <div className="mt-3 col-4">
                        <label htmlFor="sezione" className="form-label" >Sezione</label>
                        <input className="form-control" id="sezione" type="text" name="sezione" placeholder={singleClass.lettera} maxLength={5} required></input>
                    </div>
                    <div className="mt-3 col-4">
                        <label htmlFor="annoScolastico" className="form-label" >Anno Scolastico</label>
                        <input className="form-control" id="annoScolastico" type="text" name="annoScolastico" placeholder={singleClass.annoScolastico} maxLength={10} required></input>
                    </div>
                    <button className="mt-5 btn btn-dark btn-lg">Aggiorna</button>
                </form>
            </div>
        </>
    )
}

export default UpateClass