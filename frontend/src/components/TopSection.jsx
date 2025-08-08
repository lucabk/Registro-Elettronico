import { useUser } from "./context/userContext"
import Logout from "./Auth/Logout"
import { Link } from "react-router-dom"
import { getRedirectPath, getSubjectPath, getTeacherPath } from "../util/getPath"

const TopScetion = ({ text, hp=true }) => {
    const user = useUser()

    let content
    let h1 = <h1 className="text-center fs-1 fw-bold">{text}</h1>
    let homePage = (
        <div className="d-flex justify-content-center mt-4">
            <Link to={getRedirectPath(user?.role)} className="d-flex flex-column align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="black" className="bi bi-house" viewBox="0 0 16 16">
                    <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z"></path>
                </svg>
                <span className="visually-hidden">Home Page link</span>
            </Link>
        </div>
    )

    const navbar = (
        <nav className="nav">
            <Link className="nav-link text-dark"  to={getRedirectPath(user?.role)}>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="black" className="bi bi-house" viewBox="0 0 16 16">
                    <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z"></path>
                </svg>
                <span className="visually-hidden">Home Page link</span>
            </Link>
            <Link className="nav-link text-dark" to={getSubjectPath(user?.role)}>Materie</Link>
            <Link className="nav-link text-dark" to={getTeacherPath(user?.role)}>Docenti</Link>
        </nav>
    )
    
    switch (user?.role) {
        
        case "ROLE_STU":
            content = (
                <div className="container-fluid mt-0 p-5 bg-success ">
                    {h1}
                    {hp && homePage}
                </div>
            )
            break

        case "ROLE_SEG":
            content = (
                <div className="container-fluid mt-0 p-5 bg-info text-dark">
                    {h1}
                    {hp && navbar}
                </div>
            )
            break

        case "ROLE_DOC":
            content = (
                <div className="container-fluid mt-0 p-5 bg-primary text-dark">
                    {h1}
                </div>
            )
            break

        case "ROLE_GES":
            content = (
                <div className="container-fluid mt-0 p-5 bg-secondary ">
                    {h1}
                    {navbar}
                </div>
            )
            break

        default:
            content = (
                <div className="container-fluid mt-0 p-5 bg-success ">
                    {h1}
                    {hp && homePage}
                </div>
            )
    }

    let logged = (
        <>
            <Logout />
            { content }
        </>
    )
    
    return user ? logged :  content
}

export default TopScetion