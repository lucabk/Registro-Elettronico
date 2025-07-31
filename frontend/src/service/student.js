import axios from "./axiosConfig";

const API_STUDENTI = "/api/studente"

export const getStudentsByClasse = async (idClasse) => {
    const res = await axios.get(`${API_STUDENTI}/byClasse?idClasse=${idClasse}`)
    return res.data
}

export const getStudentById = async (idStudent) => {
    const res = await axios.get(`${API_STUDENTI}/${idStudent}`)
    return res.data
}
