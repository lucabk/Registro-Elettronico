import axios from "../service/axiosConfig";

const API_MATERIA = "/api/materia"

export const getMaterie = async () => {
    const res = await axios.get(API_MATERIA)
    return res.data
} 