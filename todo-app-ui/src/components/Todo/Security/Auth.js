import { createContext, useContext, useState } from "react"

import { JWTAuthService, apiClient} from "../API/TodoServiceAPI"

export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

export default function AuthProvider({children}){

    const [isAuthenticated, setAuthentication] = useState(false)

    const [username, setUsername] = useState(null)

    const [token, SetToken] = useState(null)

    // function login(username, password){
    //     if(username==='Pawan' && password==='Pass'){
    //         setAuthentication(true)
    //         setUsername(username)
    //         return true
    //     } else {
    //         setAuthentication(false)
    //         setUsername(null)
    //         return false
    //     }
    // }

    // async function login(username, password) {

    //     const baToken = 'Basic ' + window.btoa(username + ":" + password)

    //     try {
    //         const response = await basicAuthService(baToken)

    //         if (response.status == 200) {
    //             setAuthentication(true)
    //             setUsername(username)
    //             SetToken(baToken)

    //             apiClient.interceptors.request.use(
    //                 (config) => {
    //                     config.headers.Authorization = baToken
    //                     return config
    //                 }
    //             )

    //             return true
    //         } else {
    //             logout()
    //             return false
    //         }
    //     } catch (error) {
    //         logout()
    //         return false
    //     }
    // }

    async function login(username, password) {

        try {
            const response = await JWTAuthService(username, password)

            if (response.status == 200) {
                const jwtToken = 'Bearer ' + response.data.token
                setAuthentication(true)
                setUsername(username)
                SetToken(jwtToken)

                apiClient.interceptors.request.use(
                    (config) => {
                        config.headers.Authorization = jwtToken
                        return config
                    }
                )

                return true
            } else {
                logout()
                return false
            }
        } catch (error) {
            logout()
            return false
        }
    }

    function logout(){
        setAuthentication(false)
        setUsername(null)
        SetToken(null)
    }

    return(
        <AuthContext.Provider value ={ { isAuthenticated, login, logout, username, token} }>
        {children}
        </AuthContext.Provider>
    )
}