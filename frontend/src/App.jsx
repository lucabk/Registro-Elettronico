import './index.css'
import AdminHome from "./components/adminHome"
import { ToastContainer } from 'react-toastify'
import Login from './components/Auth/Login'
import UserContext from './components/context/userContext'
import { useContext } from 'react'

const App = () => {
  const [user, _userDispatcher] = useContext(UserContext)
  
  return(
    <>
      <ToastContainer />
      { user === null ? (

        <Login />

      ) : (

        <AdminHome />
        
      )
      }
    </>
  ) 
} 

export default App