import SchoolForm from "./SchoolForm"
import Schools from "./Schools"


const AdminHome = () => {

    return(
        <>
            <h1>Home page dell'amministratore</h1>
            <Schools />
            <SchoolForm />
        </>
    )
}

export default AdminHome