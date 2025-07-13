import { useState, useEffect } from "react"
import * as classService from "../../service/class"
import SingleClass from "./SingleClass"
import { toast } from "react-toastify"

const ClassiScuola = ({ schoolId }) => {
    const [classes, setClasses] = useState([])

    useEffect(()=>{
        classService.getClasses(schoolId)
            .then(res => setClasses(res))
            .catch(error => {
                toast.error("Errore nel fetch delle classi")
                console.error("Errore nel recupero delle classi associate alla scuola: ", error)})
    },[])

    //console.log(classes)

    return (
        <div>
            <h3 className="mt-5 text-center fs-3">Classi disponibili nella scuola</h3>
            <table className="container table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                <caption>Tabella Classi</caption>
                <thead className="table-light">
                    <tr>
                        <th>Grado</th>
                        <th>Lettera</th>
                        <th>Anno Scolasitco</th>
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
                            <SingleClass SingleClass={c} />
                        </tr>
                )}
                </tbody>
            </table>
        </div>
    )
} 

export default ClassiScuola