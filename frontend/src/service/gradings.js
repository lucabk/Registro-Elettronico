import axios from "./axiosConfig";

const BASE_API = "/api/valutazione"

export const getValutazioneByStudente = async (idStudente) => {
    const res = await axios.get(`${BASE_API}?idStudente=${idStudente}`)
    return res.data
}