import { useEffect, useState } from "react"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import * as assignmentsService from "../../service/assignements"
import { toast } from "react-toastify"

const Compiti = ({ classeId, incarichi }) => {
    const [compiti, setCompiti] = useState(null)
    let insegnamento

    useEffect(()=>{
        assignmentsService.getCompitiByClasse(classeId)
            .then(res => setCompiti(res))
            .catch(e => {
                toast.error("Impossibile recuperare compiti")
                console.error("Impossibile recuperare compiti: ", e)
            })
    }, [])
    
    if(incarichi){
        insegnamento = incarichi.filter(i => i.classeDTO.id === classeId)
    }

    console.log("compiti: ", compiti)
    console.log("incarichi: ", incarichi)
    console.log("insegnamento: ", insegnamento)

    return(
        <>
            <TopScetion text={"Esercizi per casa"} />
                <div className="container bg-light p-5">
                    { insegnamento && (
                        <h2 className="mt-3 mb-3 text-center fs-2">Compiti per la classe</h2>
                        
                    )}
                </div >
            <Footer />
        </>
    )
}

export default Compiti