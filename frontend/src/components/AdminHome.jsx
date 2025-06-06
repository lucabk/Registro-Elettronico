import SchoolForm from "./SchoolForm"
import Schools from "./Schools"


const AdminHome = () => {

    return(
        <>  
            <div className="container-fluid p-5 sfondo-titolo">
                <h1 className="titolo">Home page</h1>
            </div>
            <Schools />
        </>
    )
}

export default AdminHome