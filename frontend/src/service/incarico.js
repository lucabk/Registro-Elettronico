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