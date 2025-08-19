import axios from "./axiosConfig";

const BASE_API = "/api/verifica"

export const getVerificheByClasse = async (idClasse) => {
    const res = await axios.get(`${BASE_API}?idClasse=${idClasse}`)
    return res.data
}