import axios from "./axiosConfig";

const API_SCUOLE = '/api/scuole'

export const getSchools = async ({ regione, provincia, citta }) =>{ // Axios costruirà automaticamente la query string solo con i parametri che non sono undefined o null
    const params = {}
    if (regione) params.regione = regione
    if (provincia) params.provincia = provincia
    if (citta) params.citta = citta
    const res = await axios.get(API_SCUOLE, { params })
    return res.data
}

export const addSchool = async (school) => {
    const res = await axios.post(API_SCUOLE, school)
    return res.data
}

export const deleteSchool = async (schoolId) => {
    await axios.delete(`${API_SCUOLE}/${schoolId}`)
}

export const updateSchool = async (newSchool, schoolId) => {
    const res = await axios.put(`${API_SCUOLE}/${schoolId}`, newSchool)
    return res.data
}