import axios from "./axiosConfig";

const API_SEGRETERIE = '/api/segreterie'

export const getSegreterie = async (idScuola) => {
    const res = await axios.get(`${API_SEGRETERIE}?idScuola=${encodeURIComponent(idScuola)}`)
    return res.data
}