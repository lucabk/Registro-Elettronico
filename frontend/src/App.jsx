import './index.css'
import AdminHome from "./components/adminHome"
import Login from './components/Auth/Login'
import UserContext from './components/context/userContext'
import { useContext, useEffect } from 'react'
import { toast } from 'react-toastify'

const App = () => {
  const [user, userDispatcher] = useContext(UserContext)

  //fetch browser local storage: ripopola il contesto globale (userToken) con il token salvato nella memoria del browser al refresh
  useEffect(() => {
    const token = window.localStorage.getItem("token")
    if (token) {
        const tokenPayload = JSON.parse(atob(token.split(".")[1]))
        if (Math.floor(Date.now()/1000) < tokenPayload.exp){
          userDispatcher({ type : "SAVE_USER", payload : token })
        } else {                                                    //token expired
          toast.error("JWT Token expired, please Login")
          window.localStorage.removeItem("token")
          userDispatcher({ type : "DELETE_USER" })
        }
    }
  }, [])

  console.log("user:", user)

  if (user === null) return <Login />
  
  return(
    <>
      { user.role === "ROLE_GES" && <AdminHome /> }
    </>
  ) 
} 

export default App