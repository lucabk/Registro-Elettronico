import axios from "./axiosConfig";

const BASE_API = "/api/verifica"

export const getVerificheByClasse = async (idClasse) => {
    const res = await axios.get(`${BASE_API}?idClasse=${idClasse}`)
    return res.data
}

export const addVerifica = async (newVerifica) => {
    const res = await axios.post(BASE_API, newVerifica)
    return res.data
}

export const deleteVerifica = async (idVerifica) => {
    await axios.delete(`${BASE_API}/${idVerifica}`)
}