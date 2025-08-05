import axios from "./axiosConfig";

const BASE_API = "/api/incarico"

export const getIncarichiByClasse = async (idClasse) => {
    const res = await axios.get(`${BASE_API}/classe?idClasse=${encodeURIComponent(idClasse)}`)
    return res.data
}

export const addIncarico = async (newIncarico) => {
    const res = await axios.post(BASE_API, newIncarico)
    return res.data
}

export const updateIncarico = async (id, newIncarico) => {
    const res = await axios.put(`${BASE_API}/${id}`, newIncarico)
    return res.data
}

export const deleteIncarico = async (id) => {
    await axios.delete(`${BASE_API}/${id}`)
}