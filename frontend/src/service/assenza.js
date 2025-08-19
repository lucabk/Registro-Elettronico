import axios from "./axiosConfig";

const BASE_API = "/api/assenza" 

export const getAssenzeByStudente = async (id) => {
    const res = await axios.get(`${BASE_API}/${id}`)
    return res.data
}