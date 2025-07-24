import { useUser } from "../context/userContext"
import LogoutButton from "./LogoutButton"

const Logout = () => {
    let content 
    const user = useUser()

    switch (user.role) {
        case "ROLE_STU":
            content = <div className="container-fluid p-0 m-0 bg-success d-flex justify-content-end">
                <LogoutButton />
            </div>
            break
        case "ROLE_SEG":
            content = <div className="container-fluid p-0 m-0 bg-info text-dark d-flex justify-content-end">
                <LogoutButton />
            </div>
            break
        default:
            content = <div className="container-fluid m-0 p-0 bg-secondary d-flex justify-content-end">
                <LogoutButton />
            </div>
    }

    return content 
}

export default Logout