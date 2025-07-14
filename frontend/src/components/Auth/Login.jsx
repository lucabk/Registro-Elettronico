import Footer from "../Footer"
import TopScetion from "../TopSection"
import * as authService from "../../service/auth"
import { toast } from "react-toastify"
import { useUserTokenDispatcher } from "../context/userContext"

const Login = () => {
    const  userTokenDispatcher = useUserTokenDispatcher()

    const handleSubmit = async (formData) => {
        try{
            const credenziali = {
                username : formData.get("username"),
                password : formData.get("password")
            }
            const res = await authService.login(credenziali)
            userTokenDispatcher({ type : "SAVE_USER", payload : res.token }) //si salva il token nello stato userToken
            window.localStorage.setItem("token", res.token) //si salva il token nel local storage del browser
            toast.success("Login effettuato con successo!")
        } catch(e) {
            toast.error("Credenziali Errate!")
            console.error("POST Error: ", e)
        }
    }

    return(
        <>
            <TopScetion text={"Benvenuto sul portale myScuola"} bg={"green"}/>
            <div className="container p-3 mb-5 mt-5 bg-light text-dark p-5">
                <h2 className="text-center fs-2 mb-4">Effettua il login</h2>
                <form action={handleSubmit} className="row needs-validation">
                    <div className="mb-3">
                        <label htmlFor="username" className="form-label"></label>
                        <input type="text" className="form-control" id="username" name="username" placeholder="A100" required maxLength={50} aria-describedby="usernameHelp"></input>
                        <div id="usernameHelp" className="form-text">Prefisso "A" davanti al numero di matricola</div>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="password" className="form-laberl"></label>
                        <input type="password" className="form-control" id="password" name="password" required maxLength={50}></input>
                    </div>
                    <div className="mb-3"></div>
                    <button className="mt-5 btn btn-dark btn-lg">Accedi</button>
                </form>
            </div>
            <Footer bg={"green"}/>
        </>
    )
}

export default Login