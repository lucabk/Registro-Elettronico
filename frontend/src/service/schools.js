import axios from "axios";

const API_BASE = 'http://localhost:8080/api/scuole'

// Axios costruirà automaticamente la query string solo con i parametri che non sono undefined o null
export const getSchools = async ({ regione, provincia, citta }) =>{
    const params = {}
    if (regione) params.regione = regione
    if (provincia) params.provincia = provincia
    if (citta) params.citta = citta
    const res = await axios.get(API_BASE, { params })
    return res.data
}

export const addSchool = async (school) => {
    const res = await axios.post(API_BASE, school)
    return res.data
}

export const deleteSchool = async (schoolId) => {
    await axios.delete(`${API_BASE}/${schoolId}`)
}