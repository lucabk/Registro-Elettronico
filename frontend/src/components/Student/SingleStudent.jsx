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
        </>
    )
}

export default SingleStudent