import LogoutButton from "./LogoutButton"

const Logout = ({ color }) => {
    let content 

    switch (color) {
        case "green":
            content = <div className="container-fluid p-0 m-0 bg-success d-flex justify-content-end">
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