import axios from "./axiosConfig";

const API_DOCENTI = "/api/docente"

export const getTeachers = async () => {
    const res = await axios.get(API_DOCENTI)
    return res.data
}