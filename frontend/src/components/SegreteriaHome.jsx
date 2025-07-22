import { Route, Routes } from "react-router-dom"
import SchoolHomePage from "./School/SchoolHomePage"
import { useEffect, useState } from "react"
import { getSchoolBySecr } from "../service/secretaryships"
import { useUser } from "./context/userContext"
import { toast } from "react-toastify"

const SegreteriaHome = () => {
    const [school, setSchool] = useState(null)
    const user = useUser()

    useEffect(()=> {
        getSchoolBySecr(user.username)
            .then(res => setSchool(res))
            .catch(err => {
                toast.error("Impossibile recuperare la scuola")
                console.error("Error fetching school:", err)
            })
    },[])

    return(
        <>
            <Routes>
                <Route path='/' element={ <SchoolHomePage 
                    school={school}  />} 
                />
            </Routes>
        </>
    )
}

export default SegreteriaHome