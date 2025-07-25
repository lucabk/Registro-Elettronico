import { toast } from "react-toastify"
import { useNavigate } from "react-router-dom"
import { useContext } from "react"
import UserContext from "../context/userContext"

const LogoutButton = () => {
    const [user, userDispatcher] = useContext(UserContext)
    const navigate = useNavigate()

    const handleLogout = (event) => {
        event.preventDefault()
        window.localStorage.removeItem("token")
        userDispatcher({ type : "DELETE_USER" })
        toast.success(`Utente ${user?.username} disconnesso`)
        navigate("/")
    }

    return(
        <button onClick={handleLogout} type="button" className="btn  btn-lg">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-box-arrow-left" viewBox="0 0 16 16">
                <path fillRule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0z"></path>
                <path fillRule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708z"></path>
            </svg>Esci
            <span className="visually-hidden">Esci</span>
        </button>
    )
}

export default LogoutButton