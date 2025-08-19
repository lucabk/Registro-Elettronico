import { toast } from "react-toastify"
import { useUser } from "../context/userContext"
import { useState } from "react"
import * as teacherService from "../../service/teacher"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import { Link } from "react-router-dom"

const TeacherProfile = ({ teacher }) => {
    const [showModal, setShowModal] = useState(false);

    const user = useUser()

    const updatePassword = async (formData) => {
        const password = formData.get("password")
        const newPassword = formData.get("npassword")
        const username = formData.get("username")
        if(password.localeCompare(newPassword) === 0){
            const newObj = {
                username,
                password
            } 
            try{
                await teacherService.updatePassword(newObj, teacher.id)
                toast.success("Password aggiornata")
            }catch(e){
                toast.error("Impossibile aggiornare password")
                console.error("Impossibile aggiornare password: ", e)
            }finally{
                setShowModal(false)
            }
        }else{
            toast.warning("Le password non corrispondono")
        }
    }

    return(
        <>
            <TopScetion text={"Profilo docente"} />
            {
                teacher && (
                    <div className="container bg-light p-5">
                        <h2 className="mt-3 mb-3 text-center fs-2">Scheda informativa sul docente</h2>
                        <div className="container bg-light d-flex justify-content-center ">
                            <div className="card m-4 fs-5" style={{width: "18rem"}}>
                                <div className="card-header bg-dark text-white">
                                    {teacher.cognome} {teacher.nome}
                                </div>
                                <ul className="list-group list-group-flush ">
                                    <li className="list-group-item">Username: <strong>{user?.username}</strong></li>
                                    <li className="list-group-item">Email: <strong>{teacher.email}</strong></li>
                                    <li className="list-group-item">Numero: <strong>{teacher.numero}</strong></li>
                                    <li className="list-group-item">Codice Fiscale: <strong>{teacher.codiceFiscale}</strong></li>
                                    <li className="list-group-item">Istruzione: <strong>{teacher.istruzione}</strong></li>
                                </ul>
                                <div className="card-body">
                                    <div className="d-grid gap-3">
                                        <Link to='#'>
                                            <button type="button" className="btn btn-outline-primary" onClick={()=>toast.warning("Rivolgersi alla segreteria")}>
                                                Aggiorna informazioni 
                                            </button>
                                        </Link>
                                        <Link to='#'>
                                            <button type="button" className="btn btn-outline-primary" onClick={()=>setShowModal(true)}>
                                                Aggiorna password
                                            </button>
                                        </Link>
                                    </div>
                                </div>
                                <div className="card-footer text-body-secondary">
                                    {teacher.indirizzo}, {teacher.citta} ({teacher.provincia}) {teacher.cap}
                                </div>
                            </div>
                        </div>
                        { showModal && (
                             <div className="modal show d-block" tabIndex="-1">
                                <div className="modal-dialog modal-dialog-centered">
                                    <div className="modal-content">
                                        <div className="modal-header">
                                            <h1 className="modal-title fs-5">Aggiorna Password</h1>
                                            <button 
                                                type="button" className="btn-close" onClick={() => setShowModal(false)}>
                                            </button>
                                        </div>
                                        <div className="modal-body">
                                            <form action={updatePassword}>
                                                <div className="row">
                                                    <div className="mt-3 col-4">
                                                        <label htmlFor="username" className="form-label" >Username</label>
                                                        <input className="form-control" id="username" type="text" name="username" placeholder="D102" required></input>
                                                    </div>
                                                    <div className="mt-3 col-4">
                                                        <label htmlFor="password" className="form-label" >Nuova Password</label>
                                                        <input className="form-control" id="password" type="password" name="password" placeholder="new password" required></input>
                                                    </div>
                                                    <div className="mt-3 col-4">
                                                        <label htmlFor="npassword" className="form-label" >Ripeti Password</label>
                                                        <input className="form-control" id="npassword" type="password" name="npassword" placeholder="new password" required></input>
                                                    </div>
                                                    <button className="mt-5 btn btn-dark btn-lg">Salva</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                    </div>
                        )}
                    </div>
                )
            }    
            <Footer />
        </>
    )
}

export default TeacherProfile