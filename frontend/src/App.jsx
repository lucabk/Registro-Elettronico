import './index.css'
import AdminHome from "./components/adminHome"
import { ToastContainer } from 'react-toastify'
import Login from './components/Auth/Login'
import UserContext from './components/context/userContext'
import { useContext, useEffect } from 'react'

const App = () => {
  const [userToken, userTokenDispatcher] = useContext(UserContext)

  //fetch browser local storage: ripopola il contesto globale (userToken) con il token salvato nella memoria del browser al refresh
  useEffect(() => {
    const token = window.localStorage.getItem("token")
    if (token){
      userTokenDispatcher({ type : "SAVE_USER", payload : token })
    } 
  }, [])

  //console.log("user token:", userToken)
  
  return(
    <>
      <ToastContainer />
      { userToken === null ? (
        <Login />
      ) : (
        <>
          <AdminHome />
        </>
      )}
    </>
  ) 
} 

export default App