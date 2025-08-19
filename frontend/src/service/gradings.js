import axios from "./axiosConfig";

const BASE_API = "/api/valutazione"

export const getValutazioneByStudente = async (idStudente) => {
    const res = await axios.get(`${BASE_API}?idStudente=${idStudente}`)
    return res.data
}

export const addValutazione = async (newValutazione) => {
    const res = await axios.post(BASE_API, newValutazione)
    return res.data
}

export const deleteValutazione = async (id) => {
    await axios.delete(`${BASE_API}/${id}`)
}