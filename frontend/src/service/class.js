import axios from "./axiosConfig"

const API_CLASSI = '/api/classi'

export const getClasses = async (schoolId) => { //getClassiByIdScuola
    const params = {}
    if (schoolId) params.idScuola = schoolId
    const res = await axios.get(API_CLASSI, { params })
    return res.data
}

export const getClassById = async (classId) => {
    const res = await axios.get(`${API_CLASSI}/${classId}`)
    return res.data
}

export const deleteClass = async (classId) => {
    await axios.delete(`${API_CLASSI}/${classId}`)
}

export const updateClass = async (classId, newClass) => {
    const res = await axios.put(`${API_CLASSI}/${classId}`, newClass)
    return res.data
}