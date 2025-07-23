import './index.css'
import AdminHome from "./components/AdminHome"
import Login from './components/Auth/Login'
import UserContext from './components/context/userContext'
import { useContext, useEffect } from 'react'
import { toast } from 'react-toastify'
import { axiosSetNavigate, axiosSetUserDispatcher } from './service/axiosConfig'
import { Routes, Route, Navigate } from 'react-router-dom'
import { useNavigate } from "react-router-dom"
import SegreteriaHome from './components/SegreteriaHome'
import { getRedirectPath } from './util/getPath'

const App = () => {
  const [user, userDispatcher] = useContext(UserContext)
  const navigate = useNavigate()

  //fetch browser local storage: ripopola il contesto globale (userToken) con il token salvato nella memoria del browser al refresh
  useEffect(() => {
    axiosSetUserDispatcher(userDispatcher) //userDispatcher per axios interceptor
    axiosSetNavigate(navigate)  // useNavigate per axios interceptor
    const token = window.localStorage.getItem("token")
    if (token) {
        const tokenPayload = JSON.parse(atob(token.split(".")[1]))
        if (Math.floor(Date.now()/1000) < tokenPayload.exp){
          userDispatcher({ type : "SAVE_USER", payload : token })
        } else {                                                    //token expired
          toast.error("Sessione scaduta. Si prega di effettuare il login")
          window.localStorage.removeItem("token")
          userDispatcher({ type : "DELETE_USER" })
          navigate("/")
        }
    }
  }, [])

  console.log("user:", user)

  return (
    <>
      <Routes>
        <Route path='/' element={ 
          user === null ? 
          <Login /> : 
          <Navigate replace to = {getRedirectPath(user.role)} /> 
        } />
        <Route path='/admin/*' element={
          user?.role === "ROLE_GES" ?
          <AdminHome /> :
          <Login /> 
        } />
        <Route path='/segreteria/*' element={
          user?.role === "ROLE_SEG" ?
          <SegreteriaHome /> :
          <Login />
        } />
      </Routes>
    </>
  )
} 

export default App