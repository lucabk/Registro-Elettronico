import SingleSchool from "./SingleSchool"
import { useState } from "react"
import TopScetion from "../TopSection"
import Footer from "../Footer"
import { Link } from "react-router-dom"

const Schools = ({ schools, filter, setFilter }) => {
    const [regione, setRegione] = useState("")
    const [provincia, setProvincia] = useState("")
    const [citta, setCitta] = useState("")
        
    const handleSubmit = (e) => {
        e.preventDefault()
        setFilter({ regione, provincia, citta })
        setRegione('')
        setProvincia('')
        setCitta('')
    }
        
    console.log("GET all schools result: ", schools)
    console.log("filter: ", filter)
    
    return(
        <>
            <TopScetion text={"Home page"} />

            <div className="container-fluid p-5 m-0">
                <section>
                    <h2 className="mt-3 text-center fs-2">Scuole disponibili nel database</h2>
                    <div className="container mt-3 p-2 bg-light text-dark">
                        {(filter.regione || filter.provincia || filter.citta) && (
                            <>
                                <div className="row">
                                    <div className="col-2">
                                        <p className="text-secondary fw-semibold fst-italic">Filtro utilizzato:</p>   
                                    </div>
                                    {filter.regione && (
                                    <div className="col-2">
                                        {<ul><li>Regione: {filter.regione} </li></ul>}
                                    </div>)}
                                    {filter.provincia && (
                                    <div className="col-2">
                                        {<ul><li>Provincia: {filter.provincia} </li></ul>}
                                    </div>)}
                                    {filter.citta && (
                                    <div className="col">
                                        {<ul><li>Città: {filter.citta} </li></ul>}
                                    </div>)}
                                </div>
                            </>
                        )}
                    </div>

                    <div className="row">
                        <div className="col">
                            <table className="table p-3 mt-5 table-dark table-striped table-bordered bg-secondary">
                                <caption>Tabella Scuole</caption>
                                <thead className="table-light">
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
                                <tbody className="table-group-divider">
                                {schools.map(s => 
                                    <tr key={s.id}>
                                        <SingleSchool school={s} />
                                    </tr>
                                )}
                                </tbody>
                            </table>
                        </div>
                        <div className="col-3">
                            <section>
                                <div className="container mt-5 d-flex justify-content-center">
                                    <form onSubmit={handleSubmit}>
                                        <h4 className="mt-3 mb-4 text-center">Filtro scuole</h4>
                                        <label htmlFor="regione" className="form-label">Regione</label>
                                        <input className="m-3 form-control" id="regione" type="text" name="regione" value={regione} onChange={e => setRegione(e.target.value)} placeholder="Toscana" />
                                        <label htmlFor="provincia" className="form-label">Provincia</label>
                                        <input className="m-3 form-control" id="provincia" type="text" name="provincia" value={provincia} onChange={e => setProvincia(e.target.value)} placeholder="FI" />
                                        <label htmlFor="citta" className="form-label">Città</label>
                                        <input className="m-3 form-control" id="citta" type="text" name="citta" value={citta} onChange={e => setCitta(e.target.value)} placeholder="Firenze" />
                                            <div className="d-grid gap-2 p-3 m-3" >
                                                <button type="submit" className="btn btn-dark">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" fill="currentColor" className="bi bi-search" viewBox="0 0 16 16">
                                                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                                                    </svg>
                                                </button>
                                            </div>
                                    </form>
                                </div>
                            </section>
                        </div>
                    </div>    
                </section>

                <h2 className="mt-3 mb-4 text-center fs-2">Aggiungi scuola nel database</h2>
                <Link to='addSchool'>
                    <div className="d-grid col-2 mx-auto">
                        <button className="btn btn-dark p-3">
                            <h4 className='add-school'>Clicca qui</h4> 
                        </button>
                    </div>
                </Link>
            </div>
            <Footer />
        </>
    )
}

export default Schools