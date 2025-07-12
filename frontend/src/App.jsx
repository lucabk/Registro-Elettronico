import './index.css'
import AdminHome from "./components/adminHome"
import { ToastContainer } from 'react-toastify'
import Login from './components/Auth/Login'

const App = () => {
  
  return(
    <>
      <ToastContainer />
      <Login />
    </>
  ) 
} 

//<AdminHome />
export default App