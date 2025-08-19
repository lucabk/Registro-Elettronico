import axios from "./axiosConfig";

const API_DOCENTI = "/api/docente"

export const getTeachers = async () => {
    const res = await axios.get(API_DOCENTI)
    return res.data
}

export const addTeacher = async (newTeacher) => {
    const res = await axios.post(API_DOCENTI, newTeacher)
    return res.data
}

export const deleteTeacher = async (id) => {
    await axios.delete(`${API_DOCENTI}/${id}`)
}

export const updateTeacher = async (id, update) => {
    const res = await axios.put(`${API_DOCENTI}/${id}`, update)
    return res.data
}

export const getTeacherByUsername = async (username) => {
    const res = await axios.get(`${API_DOCENTI}/utente/${username}`)
    return res.data
}

export const updatePassword = async (newPassword, id) => {
    const res = await axios.put(`${API_DOCENTI}/u${id}`, newPassword)
    return res.data
}