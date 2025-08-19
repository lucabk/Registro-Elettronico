const SingleAssenza = ({ a }) => {
    return(
        <>
            <td className="text-center">{a.dataInserimento.split("T")[0]}</td>
            <td className="text-center">{a.tipo}</td>
            <td className="text-center">{a.giustificata ? "Sì" : "No"}</td>
        </>
    )
}

export default SingleAssenza