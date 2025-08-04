import axios from "./axiosConfig";

const BASE_API = "/api/incarico"

export const getIncarichiByClasse = async (idClasse) => {
    const res = await axios.get(`${BASE_API}/classe?idClasse=${encodeURIComponent(idClasse)}`)
    return res.data
}