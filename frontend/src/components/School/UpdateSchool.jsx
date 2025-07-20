import { useParams } from "react-router-dom"
import TopScetion from "../TopSection";
import Footer from "../Footer";
import * as schoolService from "../../service/schools"
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom"


const UpdateSchool = ({ setSchools, schools }) => {
    const { id } = useParams();
    const school = schools.find(s => s.id === Number(id));
    const navigate = useNavigate()

    const capitalize = (str) => {
        if (!str) return "";
        return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
    }

    const handleSubmit = async (formData) => {
        const newSchool = {
            nome: formData.get("nome"),
            tipo: formData.get("tipo"),
            indirizzo: formData.get("indirizzo"),
            citta: capitalize(formData.get("citta")),
            provincia: formData.get("provincia").toUpperCase(),
            cap: formData.get("cap"),
            regione: capitalize(formData.get("regione"))    
        }
        try {
            const updatedSchool = await schoolService.updateSchool(newSchool, school.id)
            const schoolsUpdated = schools.map(s => s.id === school.id ? updatedSchool : s)
            setSchools(schoolsUpdated)
            toast.success(`Scuola ${updatedSchool.nome} aggiornata correttamente`)
            console.log("scuola aggiornata")
        } catch(e){
            toast.error("Errore durante l'aggiornamento")
            console.error("Errore aggiornamento scuola: ", e)
        }
        navigate(`/admin/schools/${school.id}`)
    }

    return(
        <>  
            <TopScetion text={"Scuola update"} />
            { school && (
                <div className="container p-3 mb-5 mt-5 bg-light text-dark p-5">
                    <h2 className="text-center fs-2 mb-4">Aggiorna la scuola</h2>
                    <form action={handleSubmit} className="row needs-validation">
                        <div className="mt-3 col-6">
                            <label htmlFor="nome" className="form-label">Nome della scuola</label>
                            <input className="form-control" id="nome" type="text" name="nome" placeholder={school.nome} required maxLength={50}/>
                        </div>
                        <div className="mt-3 col-6">
                            <label htmlFor="tipo" className="form-label">Indirizzo di studi</label>
                            <input className="form-control" id="tipo" name="tipo" placeholder={school.tipo} required maxLength={50}></input>
                        </div>
                        <div className="mt-3 col-6">
                            <label htmlFor="indirizzo" className="form-lable">Indirizzo fisico della scuola</label> 
                            <input className="form-control" id="indirizzo" name="indirizzo" placeholder={school.indirizzo} required maxLength={100}></input>
                        </div>
                        <div className="mt-3 col-6">
                            <label htmlFor="citta" className="form-label">Città</label>
                            <input className="form-control" id="citta" type="text" name="citta" placeholder={school.citta} required maxLength={50}/>
                        </div>
                        <div className="mt-3 col-4">
                            <label htmlFor="provincia" className="form-label">Provincia</label>
                            <input className="form-control" id="provincia" type="text" name="provincia" placeholder={school.provincia} required minLength={2} maxLength={2}/>
                        </div>
                        <div className="mt-3 col-4">
                            <label htmlFor="cap" className="form-label">CAP</label>
                            <input className="form-control" id="cap" type="text" name="cap" placeholder={school.cap} required minLength={5} maxLength={5} inputMode="numeric"/>
                        </div>
                        <div className="mt-3 col-4">
                            <label htmlFor="regione" className="form-label">Regione</label>
                            <input className="form-control" id="regione" type="text" name="regione" placeholder={school.regione} required maxLength={50}/>
                        </div>
                        <button className="mt-5 btn btn-dark btn-lg">Aggiorna</button>
                    </form>
                </div>
            )}
            <Footer />
        </>
    ) 
}

export default UpdateSchool