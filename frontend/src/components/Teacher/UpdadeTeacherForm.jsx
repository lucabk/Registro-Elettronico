import { toast } from "react-toastify"
import * as teacherService from "../../service/teacher"

const UpdadeTeacherForm = ({ setTeachers, teacher, setShowModal }) => {

    const handleSubmit = async (formData) => {
        const update = {
            nome : formData.get("nome"),
            cognome : formData.get("cognome"),
            email : formData.get("email"),
            numero : formData.get("numero"),
            codiceFiscale : formData.get("codiceFiscale"),
            indirizzo : formData.get("indirizzo"),
            citta : formData.get("citta"),
            provincia : formData.get("provincia"),
            cap : formData.get("cap"),
            istruzione : formData.get("istruzione")
        }
        try{
            const updatedTeacher = await teacherService.updateTeacher(teacher.id, update)
            setTeachers(prev => prev.map(t => t.id === teacher.id ? updatedTeacher : t))
            toast.success("Docente aggiornato correttamente")
            setShowModal(false)
        }catch(e){
            toast.error("Impossibile aggiornare docente")
            console.error("Impossibile aggiornare docente: ", e)
        }
    }

    return(
        <>
             <div className="container mt-4 p-3 bg-light text-dark p-5">
                <h2 className="text-center fs-2 mb-4">Aggiorna Docente</h2>
                 <form action={handleSubmit} className="row needs-validation">
                     <div className="mt-3 col-4">
                    <label htmlFor="nome" className="form-label" >Nome</label>
                    <input className="form-control" id="nome" type="text" name="nome" placeholder={teacher.nome} required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="cognome" className="form-label" >Cognome</label>
                    <input className="form-control" id="cognome" type="text" name="cognome" placeholder={teacher.cognome} required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="email" className="form-label" >Email</label>
                    <input className="form-control" id="email" type="text" name="email" placeholder={teacher.email} required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="numero" className="form-label" >Numero</label>
                    <input className="form-control" id="numero" type="text" name="numero" placeholder={teacher.numero} required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="codiceFiscale" className="form-label" >Codice Fiscale</label>
                    <input className="form-control" id="codiceFiscale" type="text" name="codiceFiscale" placeholder={teacher.codiceFiscale} required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="indirizzo" className="form-label" >Indirizzo</label>
                    <input className="form-control" id="indirizzo" type="text" name="indirizzo" placeholder={teacher.indirizzo} required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="citta" className="form-label" >Città</label>
                    <input className="form-control" id="citta" type="text" name="citta" placeholder={teacher.citta} required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="provincia" className="form-label" >Provincia</label>
                    <input className="form-control" id="provincia" type="text" name="provincia" placeholder={teacher.provincia} required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="cap" className="form-label" >CAP</label>
                    <input className="form-control" id="cap" type="text" name="cap" placeholder={teacher.cap} required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="istruzione" className="form-label" >Istruzione</label>
                    <input className="form-control" id="istruzione" type="text" name="istruzione" placeholder={teacher.istruzione} required></input>
                </div>
                    <button className="mt-5 btn btn-dark btn-lg">Aggiorna</button>
                </form>
            </div>
        </>
    )
}

export default UpdadeTeacherForm