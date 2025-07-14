import { useUserToken } from "./context/userContext"
import Logout from "./Auth/Logout"

const TopScetion = ({ text, bg = "grey" }) => {
    const userToken = useUserToken()

    let content
    let h1 = <h1 className="text-center fs-1 fw-bold">{text}</h1>
    
    switch (bg) {
        
        case "green":
            content = (
                <div className="container-fluid mt-0 p-5 bg-success ">
                    {h1}
                </div>
            )
            break

        default:
            content = (
                <div className="container-fluid mt-0 p-5 bg-secondary ">
                    {h1}
                </div>
            )
    }

    let logged = (
        <>
            <Logout color={bg}/>
            { content }
        </>
    )
    
    return userToken ? logged :  content
}

export default TopScetion