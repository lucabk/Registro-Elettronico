export const getRedirectPath = (role) => {
    switch (role){
        case "ROLE_GES": return "/admin"
        case "ROLE_SEG": return "/segreteria"
        case "ROLE_DOC": return "/docente"
        case "ROLE_STU": return "/studente"
        default: return "/login"
    }
}
