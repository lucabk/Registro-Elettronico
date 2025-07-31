const UpdateStudentForm = ({ updateStudentMutation, student, setShowForm }) => {
    const handleSubmit = async (formData) => {
        const studentUpdated = {
            ...student,
            email : formData.get('email'),
            numero : formData.get('numero'),
            indirizzo : formData.get("indirizzo"),
            citta : formData.get('citta'),
            provincia : formData.get('provincia'),
            cap : formData.get('cap')
        }
        updateStudentMutation.mutate(studentUpdated)
        setShowForm(prev => !prev)
    }

    return(
        <>
             <div className="container p-3 mb-5 mt-3 bg-light text-dark p-5">
                <h2 className="text-center fs-2 mb-4">Modifica Informazioni studente</h2>
                <form action={handleSubmit} className="row needs-validation">
                    <div className="mt-3 col-4">
                        <label htmlFor="email" className="form-label" >Email</label>
                        <input className="form-control" id="email" type="text" name="email" placeholder="example@email" required></input>
                    </div>
                    <div className="mt-3 col-4">
                        <label htmlFor="numero" className="form-label" >Numero</label>
                        <input className="form-control" id="numero" type="text" name="numero" placeholder="333XXXXXXXXXX" required></input>
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
                    <button className="mt-5 btn btn-dark btn-lg">Aggiorna</button>
                </form>
            </div>
        </>
    )
}

export default UpdateStudentForm