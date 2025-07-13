import axios from "axios";

const API_BASE = "http://localhost:8080/login"

export const login = async (credenziali) => {
    const res = await axios.post(API_BASE, credenziali)
    return res.data
}