const SingleSegreteria = ({ segreteria }) => {

    return(
        <ul>
            <li>
                <strong>{segreteria.nome}</strong> (id = {segreteria.id})
            </li>
        </ul>
    )
}

export default SingleSegreteria