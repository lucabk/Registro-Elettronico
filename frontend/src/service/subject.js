import axios from "../service/axiosConfig";

const API_MATERIA = "/api/materia"

export const getMaterie = async () => {
    const res = await axios.get(API_MATERIA)
    return res.data
} 

export const addMateria = async (newMateria) => {
    const res = await axios.post(API_MATERIA, newMateria)
    return res.data
}

export const deleteMateria = async (id) => {
    await axios.delete(`${API_MATERIA}/${id}`)
}