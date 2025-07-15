import { Link } from "react-router-dom"

const SingleSchool = ({ school }) => {

   return(
        <>
            <td>
                <Link className='school-link' to={`/admin/schools/${school.id}`}>
                    {school.nome}
                </Link>
            </td>
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