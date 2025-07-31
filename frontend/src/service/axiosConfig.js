import axios from "axios"
import { toast } from "react-toastify"


let userDispatcher = null // variabile per gestire lo userDispatcher
export const axiosSetUserDispatcher = (dispatcher) => {
    userDispatcher = dispatcher
}

let navigate = null // variabile per gester useNavigate
export const axiosSetNavigate = (nav) => {
    navigate = nav
}

const instance = axios.create({
    baseURL: "http://localhost:8080", 
})

// Interceptor richiesta → aggiunge token
instance.interceptors.request.use((req) => {
    const token = localStorage.getItem("token")
    if (token) {
        req.headers.Authorization = `Bearer ${token}`
    }
    return req
})

// Interceptor risposta → intercetta errori 
instance.interceptors.response.use(
    (response) => response,
    (error) => {
        if (error.response && (error.response.status === 401 || error.response.status === 403)) {
            toast.error("Si rieffettui nuovamente il Login")
            localStorage.removeItem("token")
            if (userDispatcher) {
                userDispatcher({ type: "DELETE_USER" })
            }
            if (navigate) {
                navigate("/")
            }
        }
        return Promise.reject(error)
    }
)

export default instance
