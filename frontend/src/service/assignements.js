import axios from "./axiosConfig";

const BASE_API = "/api/compiti"

export const getCompitiByDocente = async (idDocente) => {
    const res = await axios.get(`${BASE_API}/docente?idDocente=${idDocente}`)
    return res.data
}

export const getCompitiByClasse = async (classeId) => {
    const res = await axios.get(`${BASE_API}/classe?idClasse=${classeId}`)
    return res.data
}

export const addCompiti = async (obj) => {
    const res = await axios.post(BASE_API, obj)
    return res.data
}