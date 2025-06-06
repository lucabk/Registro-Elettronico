const SingleSchool = ({ school }) => {
    return(
        <>
            <td>{school.nome}</td>
            <td>{school.tipo}</td>
            <td>{school.indirizzo}</td>
            <td>{school.citta}</td>
            <td>{school.provincia}</td>
            <td>{school.cap}</td>
            <td>{school.regione}</td>
        </>
    )
}

export default SingleSchool