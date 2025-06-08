import * as schoolService from "../service/schools"
import SingleSchool from "./SingleSchool"
import { useQuery } from '@tanstack/react-query'

const Schools = () => {
    const { isPending, isError, data = [] } = useQuery({
        queryKey: ['shools'],
        queryFn: schoolService.getSchools
    })
    
    if(isPending){
        return <div>Loading schools...</div>
    }
    if(isError){
        return <div>Error loading schools!</div>
    }

    return(
        <div className="container-fluid p-5 m-0">
            <section>
                <h2 className="mt-5 text-center fs-3">Scuole disponibili nel database</h2>
                <table className="table p-3 mt-5 table-dark table-striped">
                    <caption>scuole</caption>
                    <thead>
                        <tr>
                            <th>Nome istituto</th>
                            <th>Tipologia</th>
                            <th>Indirizzo</th>
                            <th>Città</th>
                            <th>Provincia</th>
                            <th>CAP</th>
                            <th>Regione</th>
                        </tr>
                    </thead>
                    <tbody>
                    {data && data.map(s => 
                        <tr key={s.id}>
                            <SingleSchool school={s} />
                        </tr>
                    )}
                    </tbody>
                </table>
            </section>
        </div>
    )
}

export default Schools