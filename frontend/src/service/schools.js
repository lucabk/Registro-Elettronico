import axios from "axios";

const baseUrl = 'http://localhost:8080/api/scuole'

export const getSchools = async () =>{
    const res = await axios.get(baseUrl)
    return res.data
}