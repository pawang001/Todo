import axios from "axios";

export const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8081'
    }
);

export const retreiveTodosByUsernameApi = 
     (username) => apiClient.get(`/users/${username}/listTodos`)

export const deleteTodoApi = 
     (username, id) => apiClient.delete(`/users/${username}/listTodos/${id}`)
     
export const retreiveTodoApi = 
     (username, id) => apiClient.get(`/users/${username}/listTodos/${id}`)

export const updateTodoApi = 
     (username, id, todo) => apiClient.put(`/users/${username}/listTodos/${id}`, todo)

export const createTodoApi = 
     (username, todo) => apiClient.post(`/users/${username}/listTodos`, todo)

export const basicAuthService =
     (token) => apiClient.get(`/basicauth`, {
          headers: {
               Authorization: token
          }
     })

export const JWTAuthService =
     (username, password) => apiClient.post(`/authenticate`, {username, password})