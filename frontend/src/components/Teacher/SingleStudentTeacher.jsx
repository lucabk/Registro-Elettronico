import { Link } from "react-router-dom"

const SingleStudentTeacher = ({ studente }) => {
    return(
        <>
            <td className="text-center">{studente.cognome}</td>
            <td className="text-center">{studente.nome}</td>
            <td className="text-center">
                <Link to={`${studente.id}`}>
                    <button type="button" className="btn btn-secondary">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" className="bi bi-bar-chart-fill" viewBox="0 0 16 16">
                            <path d="M1 11a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1zm5-4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1z"></path>
                        </svg>
                    </button>
                </Link>
            </td>
            <td className="text-center">
                <Link to={`${studente.id}/profilo`}>
                    <button type="button" className="btn btn-secondary">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" className="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"></path>
                        </svg>
                    </button>
                </Link>
            </td>
        </>
    )
}

export default SingleStudentTeacher