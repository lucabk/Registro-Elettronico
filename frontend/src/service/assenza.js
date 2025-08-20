import axios from "./axiosConfig";

const BASE_API = "/api/assenza" 

export const getAssenzeByStudente = async (id) => {
    const res = await axios.get(`${BASE_API}/${id}`)
    return res.data
}

export const giustificaAssenza = async (id, payload) => {
    const res = await axios.put(`${BASE_API}/${id}`, payload)
    return res.data
}

export const segnaAssenza = async (payload) => {
    const res = await axios.post(BASE_API, payload)
    return res.data
}

export const deleteAssenza = async (id) => {
    await axios.delete(`${BASE_API}/${id}`)
}