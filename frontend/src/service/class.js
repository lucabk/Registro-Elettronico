import axios from "axios"

const API_BASE = 'http://localhost:8080/api/classi'

export const getClasses = async (schoolId) => {
    const params = {}
    if (schoolId) params.idScuola = schoolId
    const res = await axios.get(API_BASE, { params })
    return res.data
}