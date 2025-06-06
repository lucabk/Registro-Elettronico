const SingleSchool = ({ school }) => {
    return(
        <>
            <p>nome scuola: {school.nome}</p>
            <p>tipo: {school.tipo}</p>
            <p>citta: {school.citta}</p>
            <br/>
        </>
    )
}

export default SingleSchool