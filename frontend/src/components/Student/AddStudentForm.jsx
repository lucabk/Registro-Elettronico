const AddStudentForm = ({ addStudentMutation, classId, schoolId, setShowModal }) => {
    
    const handleSubmit = async (formData) => {
        const newStudent = {
            nome : formData.get("nome"),
            cognome : formData.get("cognome"),
            email : formData.get("email"),
            numero : formData.get("numero"),
            codiceFiscale : formData.get("codiceFiscale"),
            indirizzo : formData.get("indirizzo"),
            citta : formData.get("citta"),
            provincia : formData.get("provincia"),
            cap : formData.get("cap"),
            scuolaDTO : { id : schoolId },
            classeDTO : { id : classId },
            username : formData.get("username"),
            password : formData.get("password")
        }
        addStudentMutation.mutate(newStudent)
        setShowModal(false)
    }

    return(
        <>
            <form action={handleSubmit} className="row needs-validation">
                <div className="mt-3 col-4">
                    <label htmlFor="nome" className="form-label" >Nome</label>
                    <input className="form-control" id="nome" type="text" name="nome" placeholder="Mario" required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="cognome" className="form-label" >Cognome</label>
                    <input className="form-control" id="cognome" type="text" name="cognome" placeholder="Rossi" required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="email" className="form-label" >Email</label>
                    <input className="form-control" id="email" type="text" name="email" placeholder="example@email" required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="numero" className="form-label" >Numero</label>
                    <input className="form-control" id="numero" type="text" name="numero" placeholder="333XXXXXXXXXX" required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="codiceFiscale" className="form-label" >Codice Fiscale</label>
                    <input className="form-control" id="codiceFiscale" type="text" name="codiceFiscale" placeholder="DNTCRL65S67M126L" required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="indirizzo" className="form-label" >Indirizzo</label>
                    <input className="form-control" id="indirizzo" type="text" name="indirizzo" placeholder="Via Milano 1" required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="citta" className="form-label" >Città</label>
                    <input className="form-control" id="citta" type="text" name="citta" placeholder="Milano" required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="provincia" className="form-label" >Provincia</label>
                    <input className="form-control" id="provincia" type="text" name="provincia" placeholder="MI" required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="cap" className="form-label" >CAP</label>
                    <input className="form-control" id="cap" type="text" name="cap" placeholder="20100" required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="username" className="form-label" >Username</label>
                    <input className="form-control" id="username" type="text" name="username" placeholder="A100" required></input>
                </div>
                <div className="mt-3 col-4">
                    <label htmlFor="password" className="form-label" >Password</label>
                    <input className="form-control" id="password" type="password" name="password" placeholder="password" required></input>
                </div>
                <button className="mt-5 btn btn-dark btn-lg">Salva</button>
            </form>
        </>
    )
}

export default AddStudentForm