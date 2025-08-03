export const getRedirectPath = (role) => {
    switch (role){
        case "ROLE_GES": return "/admin"
        case "ROLE_SEG": return "/segreteria"
        case "ROLE_DOC": return "/docente"
        case "ROLE_STU": return "/studente"
        default: return "/login"
    }
}

export const getSubjectPath = (role) => {
    switch(role){
        case "ROLE_GES": return "/admin/materie"
        case "ROLE_SEG": return "/segreteria/materie"
        default: return "/login"
    }
}

export const getTeacherPath = (role) => {
    switch(role){
        case "ROLE_GES": return "/admin/docenti"
        case "ROLE_SEG": return "/segreteria/docenti"
        default: return "/login"
    }
}