import { Link } from "react-router-dom"

const SingleStudent = ({ student }) => {
    return(
        <>
             <td className="text-center">{student.nome}</td>
             <td className="text-center">{student.cognome}</td>
             <td className="text-center">{student.email}</td>
             <td className="text-center">{student.numero}</td>
             <td className="text-center">{student.codiceFiscale}</td>
             <td className="text-center">{student.indirizzo}</td>
             <td className="text-center">{student.citta}</td>
             <td className="text-center">{student.provincia}</td>
             <td className="text-center">{student.cap}</td>
            <td className="text-center">
                <Link to={`${student.id}`}>
                    <button type="button" className="btn btn-outline-secondary">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="white" className="bi bi-info-circle-fill" viewBox="0 0 16 16">
                            <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2"></path>
                        </svg>
                    <span className="visually-hidden">Info</span>
                    </button>
                </Link>
            </td>
        </>
    )
}

export default SingleStudent