import './index.css'
import AdminHome from "./components/adminHome"
import { ToastContainer } from 'react-toastify'
import Login from './components/Auth/Login'
import UserContext from './components/context/userContext'
import { useContext, useEffect } from 'react'

const App = () => {
  const [user, userDispatcher] = useContext(UserContext)

  //fetch browser local storage: ripopola il contesto globale (userToken) con il token salvato nella memoria del browser al refresh
  useEffect(() => {
    const token = window.localStorage.getItem("token")
    if (token){
      userDispatcher({ type : "SAVE_USER", payload : token })
    } 
  }, [])

  console.log("user:", user)
  
  return(
    <>
      <ToastContainer />
      { user === null ? (
        <Login />
      ) : (
        <>
          { user.role === "ROLE_GES" && <AdminHome /> }
        </>
      )}
    </>
  ) 
} 

export default App