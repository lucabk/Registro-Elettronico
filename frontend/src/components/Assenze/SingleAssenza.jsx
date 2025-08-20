import { useState } from "react"

const SingleAssenza = ({ a }) => {
    const [gestisci, setGestisci] = useState('')

    const handleGiustifica = (e) => {
        e.preventDefault()
        if(gestisci.localeCompare("Giustifica")){

        }
    }

    const handleCancella = (e) => {
        e.preventDefault()
        if(gestisci.localeCompare("Cancella")){

        }
    }

    return(
        <>
            <td className="text-center">{a.dataInserimento?.split("T")[0]}</td>
            <td className="text-center">{a.tipo}</td>
            <td className="text-center">{a.giustificata ? "Sì" : "No"}</td>
            <td className="text-center">
                <select value={gestisci} onChange={e => setGestisci(e.target.value)} required name="gestisci">
                    <option>Operazione</option>
                    <option>Giustifica</option>
                    <option>Cancella</option>
                </select>
                { gestisci.localeCompare("Giustifica") === 0 && !a.giustificata && (
                    <button className="mx-3 m-1 btn btn-primary" onClick={handleGiustifica}>
                        Giustifica
                    </button>
                )}
                { gestisci.localeCompare("Cancella") === 0 && (
                    <button className="mx-3 m-1 btn btn-danger" onClick={handleCancella}>
                        Cancella
                    </button>
                )}
            </td>
        </>
    )
}

export default SingleAssenza