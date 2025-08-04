const SingleIncarico = ({ incarico }) => {
    return(
        <>
            <td className="text-center">{incarico?.classeDTO.grado}{incarico?.classeDTO.lettera}</td>
            <td className="text-center">{incarico?.materiaDTO.nome}</td>
            <td className="text-center">{incarico?.docenteDTO.cognome} {incarico?.docenteDTO.nome}</td>
            <td className="text-center">{incarico?.programma}</td>
            <td className="text-center">{incarico?.classeDTO.annoScolastico}</td>
        </>
    )
}

export default SingleIncarico