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

export const deleteSegreteria = async (id) => {
    await axios.delete(`${API_SEGRETERIE}/${id}`)
}

export const getSchoolBySecr = async (username) => {
    const res = await axios.get(`${API_SEGRETERIE}/utente/${username}`)
    return res.data
}