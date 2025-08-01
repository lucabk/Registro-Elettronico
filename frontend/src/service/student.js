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

export const updateStudente = async (newStudent) => {
    const res = await axios.put(`${API_STUDENTI}/${newStudent.id}`, newStudent)
    return res.data
}

export const addStudente = async (newStudent) => {
    const res = await axios.post(API_STUDENTI, newStudent)
    return res.data
}

export const deleteStudente = async (id) => {
   await axios.delete(`${API_STUDENTI}/${id}`)
}