import { Link } from "react-router-dom"
import { toast } from "react-toastify"
import * as classService from "../../service/class"
import { useState } from "react"
import UpateClass from "./UpdateClass"

const SingleClass = ({ singleClass, setClasses, classes }) => {
    const [formVisible, setFormVisible] = useState(false)

    const handleDelete = async (e) => {
        e.preventDefault()
        if(window.confirm(`Cancellare la classe ${singleClass.grado}${singleClass.lettera}?`)){
            try{
                await classService.deleteClass(singleClass.id)
                toast.success("Classe cancellata correttamente")
                setClasses( prev => prev.filter(c => c.id !== singleClass.id))
                console.log(`Classe ${singleClass.grado}${singleClass.lettera} cancellata`)
            } catch(e){
                toast.error("Impossibile cancellare la classe")
                console.error("Errore cancellazaione classe ", e)
            }
        }
    }

    return(
        <>
            <td className="text-center">{singleClass.grado}</td>
            <td className="text-center">{singleClass.lettera}</td>
            <td className="text-center">{singleClass.annoScolastico}</td>
            <td className="text-center">
                <Link to={`${singleClass.id}`}>
                    <button type="button" className="btn btn-outline-secondary">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="white" className="bi bi-info-circle-fill" viewBox="0 0 16 16">
                            <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2"></path>
                        </svg>
                    <span className="visually-hidden">Info</span>
                    </button>
                </Link>
            </td>
            <td className="text-center">
                { formVisible ? (
                    <>
                        <button type="button" className="mt-2 btn btn-outline-light" onClick={() => setFormVisible(prev => !prev)}>
                            Nascondi
                        </button>
                        <UpateClass setClasses={setClasses} singleClass={singleClass} classes={classes} /> 
                    </>
                    ) : (
                    <button type="button" className="btn btn-outline-secondary" onClick={() => setFormVisible(prev => !prev)}>
                        <svg xmlns="http://www.w3.org/2000/svg" width="26" height="24" fill="green" className="bi bi-arrow-clockwise" viewBox="0 0 16 16">
                            <path fillRule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2z"></path>
                            <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466"></path>
                        </svg>
                        <span className="visually-hidden">Update class</span>
                    </button>
                    )
                }
            </td>
            <td className="text-center">
                <button type="button" onClick={handleDelete} className="btn">
                    <svg xmlns="http://www.w3.org/2000/svg" width="26" height="24" fill="red" className="bi bi-x" viewBox="0 0 16 16">
                        <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"></path>
                    </svg>
                    <span className="visually-hidden">Delete class</span>
                </button>
            </td>

            
        </>
    )
}

export default SingleClass