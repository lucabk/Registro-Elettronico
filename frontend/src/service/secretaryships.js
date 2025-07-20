import axios from "./axiosConfig";

const API_SEGRETERIE = '/api/segreterie'

export const getSegreterie = async (idScuola) => {
    const res = await axios.get(`${API_SEGRETERIE}?idScuola=${encodeURIComponent(idScuola)}`)
    return res.data
}

export const addSegreteria = async (newS) => {
    const res = await axios.post(API_SEGRETERIE, newS)
    return res.data
}