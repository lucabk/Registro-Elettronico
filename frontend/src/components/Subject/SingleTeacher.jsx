const SingleTeacher = ({ teacher, setTeacher }) => {
    return(
        <>
            <td className="text-center">{teacher.cognome}</td>
            <td className="text-center">{teacher.nome}</td>
            <td className="text-center">{teacher.email}</td>
            <td className="text-center">{teacher.numero}</td>
            <td className="text-center">{teacher.codiceFiscale}</td>
            <td className="text-center">{teacher.indirizzo}</td>
            <td className="text-center">{teacher.citta}</td>
            <td className="text-center">{teacher.provincia}</td>
            <td className="text-center">{teacher.cap}</td>
            <td className="text-center">{teacher.istruzione}</td> 
            <td className="text-center">
                <button type="button" className="btn btn-outline-secondary" >
                    <svg xmlns="http://www.w3.org/2000/svg" width="26" height="24" fill="green" className="bi bi-arrow-clockwise" viewBox="0 0 16 16">
                        <path fillRule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2z"></path>
                        <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466"></path>
                    </svg>
                    <span className="visually-hidden">Update Teacher</span>
                </button>
            </td> 
            <td className="text-center">
                 <button type="button" className="btn">
                    <svg xmlns="http://www.w3.org/2000/svg" width="26" height="24" fill="red" className="bi bi-x" viewBox="0 0 16 16">
                        <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"></path>
                    </svg>
                    <span className="visually-hidden">Delete teacher</span>
                </button>
            </td> 
        </>
    )
}

export default SingleTeacher