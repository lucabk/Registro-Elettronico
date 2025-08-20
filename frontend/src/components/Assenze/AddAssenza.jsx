import { useState } from "react"

const AddAssenza = ({ addAssenzaMutation, studentId }) => {
    const [tipo, setTipo] = useState('intera')

    const handleAddassenza = (e) => {
        e.preventDefault()
        const newAassenza = {
            tipo,
            studenteDTO : { id : studentId }
        }
        addAssenzaMutation.mutate(newAassenza)
        setTipo('intera')
    }

    return(
        <form onSubmit={handleAddassenza}>
            <select value={tipo} onChange={e => setTipo(e.target.value)} required name="tipo">
                <option>intera</option>
                <option>parziale</option>
            </select>
            <button className="btn btn-dark m-3">Aggiungi</button>
        </form>
    )
}

export default AddAssenza