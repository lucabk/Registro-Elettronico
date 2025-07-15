import axios from "axios"
import { toast } from "react-toastify"

let userDispatcher = null // variabile per gestire lo userDispatcher
export const setUserDispatcher = (dispatcher) => {
    userDispatcher = dispatcher
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
            toast.error("Sessione scaduta o non autorizzata. Effettua di nuovo il login.")
            localStorage.removeItem("token")
            if (userDispatcher) {
                userDispatcher({ type: "DELETE_USER" })
            }
        }
        return Promise.reject(error)
    }
)

export default instance
