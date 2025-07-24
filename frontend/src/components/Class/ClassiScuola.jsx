import { useState, useEffect } from "react"
import * as classService from "../../service/class"
import SingleClass from "./SingleClass"
import { toast } from "react-toastify"
import ClasseForm from "./ClasseForm"

const ClassiScuola = ({ schoolId }) => {
    const [classes, setClasses] = useState([])

    useEffect(()=>{
        classService.getClasses(schoolId)
            .then(res => setClasses(res))
            .catch(error => {
                toast.error("Errore nel fetch delle classi")
                console.error("Errore nel recupero delle classi associate alla scuola: ", error)})
    },[])

    console.log("classi della scuola:", classes)

    return (
        <div className="container-fluid bg-light p-5">
            <h3 className="mt-5 text-center fs-3">Classi disponibili nella scuola</h3>
            <table className="container table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                <caption>Tabella Classi</caption>
                <thead className="table-light">
                    <tr>
                        <th className="text-center">Grado</th>
                        <th className="text-center">Lettera</th>
                        <th className="text-center">Anno Scolasitco</th>
                        <th className="text-center">Info</th>
                        <th className="text-center">Aggiorna</th>
                        <th className="text-center">Cancella</th>
                    </tr>
                </thead>
                <tbody className="table-group-divider">
                {classes
                    .slice() // shallow copy per non mutare lo stato
                    .sort((a, b) => {
                        if (a.grado !== b.grado) return a.grado - b.grado;
                        return a.lettera.localeCompare(b.lettera);
                    })
                    .map(c => 
                        <tr key={c.id}>
                            <SingleClass singleClass={c} setClasses={setClasses} classes={classes}/>
                        </tr>
                )}
                </tbody>
            </table>
            <ClasseForm setClasses={setClasses} schoolId={schoolId}/>
        </div>
    )
} 

export default ClassiScuola