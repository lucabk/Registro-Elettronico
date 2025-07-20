import { toast } from "react-toastify"
import * as segreteriaService from "../../service/secretaryships"

const AddSegreteria = ({ school, setSegreterie }) => {

    const handleSubmit = async (formData) => {
        const newSegreteria = {
            nome : formData.get("nome"),
            username : formData.get("username"),
            password : formData.get("password"),
            scuolaDTO : { id : school.id }
        }
        try{
            const res = await segreteriaService.addSegreteria(newSegreteria)
            const savedSeg = {
                id : res.idSegreteria,
                nome : res.nome,
                scuolaDTO : res.scuolaDTO
            }
            setSegreterie(prev => [...prev, savedSeg])
            toast.success("Segreteria salvata con successo!")
            console.log("Segreteria salvata: ", savedSeg)
        } catch (e) {
            if (e.response && e.response.status === 400) {
            toast.error(`Username "${formData.get("username")}" già presente`);
            } else {
            toast.error("Impossibile aggiungere segreteria");
            }
            console.error("impossibile aggiungere segreteria: ", e);
        }
    }

    return (
        <>
            {
                school && (

                <div className="container p-5 mb-5 mt-5 bg-light text-dark p-5">
                    <h3 className="text-center fs-3 mb-4">Aggiungi una nuova segreteria</h3>
                    <form action={handleSubmit} className="row needs-validation">
                        <div className="col-auto">
                            <label htmlFor="nome" className="form-label">Nome Segreteria</label>
                            <input className="form-control" id="nome" type="text" name="nome" placeholder="Segreteria" required maxLength={100} minLength={5}/>
                        </div>
                        <div className="col-auto">
                            <label htmlFor="username" className="form-label">Username</label>
                            <input className="form-control" id="username" type="text" name="username" placeholder="S100" required minLength={1} maxLength={50} />
                        </div>                    
                        <div className="col-auto">
                            <label htmlFor="password" className="form-label">Password</label>
                            <input className="form-control" id="password" type="password" name="password" required minLength={4} maxLength={50}/>
                        </div>
                         <div className="col-auto">
                            <button className="mt-5 btn btn-dark btn-lg">Aggiungi</button>
                         </div>
                    </form>
                </div>
                )
            }
        </>
    )
}

export default AddSegreteria