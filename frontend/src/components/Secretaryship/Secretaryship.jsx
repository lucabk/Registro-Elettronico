import { useEffect, useState } from "react"
import Footer from "../Footer"
import TopScetion from "../TopSection"
import { toast } from "react-toastify"
import * as segreterieService from "../../service/secretaryships"
import SingleSegreteria from "./SingleSecretaryship"
import AddSegreteria from "./SecretaryshipForm"

const Segreterie = ({ school }) => {
    const [segreterie, setSegreterie] = useState([])

    useEffect(()=>{
        if(school){
            segreterieService.getSegreterie(school.id)
                .then(res => setSegreterie(res))
                .catch(e => {
                    toast.error("Errore recupero delle segretire")
                    console.error("Errore segreterie: ", e)
                })
        }
    }, [])


    const renderContend = () => {
        if(segreterie.length >= 1){
            return (
                segreterie.map(
                    s => <SingleSegreteria 
                        key={s.id} 
                        segreteria={s} 
                        setSegreterie={setSegreterie}
                        segreterie={segreterie}/>
                )
            )
        } else {
            return(
                <p>Nessuna segreteria associata disponibile</p>
            )
        }
    }

    return(
        <>
            <TopScetion text={"Segreterie disponibili"}/>
            { school && (
                <div className="container-fluid p-5 bg-light">
                    <h2 className="fs-2 text-center">Segreterie per la scuola <strong>{school.nome}</strong></h2> 
                    {
                        renderContend()
                    }
                </div>
            )}
            <AddSegreteria school={school} setSegreterie={setSegreterie}/>
            <Footer />
        </>
    )
}

export default Segreterie