import { createContext, useContext, useReducer } from "react";

const userReducer = (state, action) => {
    switch(action.type) {
        case 'SAVE_USER': {
            const token = action.payload
            const tokenPayload = JSON.parse(atob(token.split(".")[1]))
            return {
                token,
                username : tokenPayload.sub,
                role : tokenPayload.roles
            }
        }
        case 'DELETE_USER':
            return null
    }
}

const UserContext = createContext()

export const UserContextProvider = (props) => {
    const [user, userDispatcher] = useReducer(userReducer, null)

    return (
        <UserContext.Provider value={ [user, userDispatcher] }>
            {props.children}
        </UserContext.Provider>
    )
}

export const useUser = () => {
    const userAndDispatcher = useContext(UserContext)
    return userAndDispatcher[0]
}

export const useUserDispatcher = () => {
    const userAndDispatcher = useContext(UserContext)
    return userAndDispatcher[1]
}

export default UserContext