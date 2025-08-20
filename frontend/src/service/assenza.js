import axios from "./axiosConfig";

const BASE_API = "/api/assenza" 

export const getAssenzeByStudente = async (id) => {
    const res = await axios.get(`${BASE_API}/${id}`)
    return res.data
}

export const giustificaAssenza = async (obj) => {
    const res = await axios.put(`${BASE_API}/${obj.id}`, { giustificata : true })
    return res.data
}

export const segnaAssenza = async (payload) => {
    const res = await axios.post(BASE_API, payload)
    return res.data
}

export const deleteAssenza = async (id) => {
    await axios.delete(`${BASE_API}/${id}`)
}