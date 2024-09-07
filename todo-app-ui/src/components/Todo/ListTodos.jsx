import { useEffect, useState } from 'react';
import { deleteTodoApi, retreiveTodosByUsernameApi } from './API/TodoServiceAPI';
import { useAuth } from './Security/Auth';
import { useNavigate } from 'react-router-dom';

function ListTodos() {

    const today = new Date()

    const targetDate = new Date(today.getFullYear()+12, 
                       today.getMonth(), today.getDay())

    const [todos,setTodos] = useState([]) 
    
    const [message, setMessage] = useState(null)

    const AuthContext = useAuth()

    const Navigate = useNavigate()

    const username = AuthContext.username

    // const todos = [
    //     { id: "1", description: "Learn Backend Development",
    //         done: false, targetDate: targetDate },
    //     { id: "2", description: "Learn Full Stack Development",
    //         done: false, targetDate: targetDate },
    //     { id: "3", description: "Learn DBMS",
    //         done: false, targetDate: targetDate }
    // ]

    useEffect( () => refreshTodos() )

    function refreshTodos() {

        retreiveTodosByUsernameApi(username)
            .then(response => {
                setTodos(response.data)
            }
        )
            .catch(error => console.log(error))
    }

    function deleteTodo(id) {

        deleteTodoApi(username, id)
            .then (
               () => {
                setMessage(`Delete of Todo with id= ${id} is successful`)
                refreshTodos()
               }
            )
            .catch(error => console.log(error))
    }

    function UpdateTodo(id) {
        Navigate(`/todo/${id}`)
    }

    function addNewTodo() {
        Navigate(`/todo/-1`)
    }

    return (
        <div className="container">
            <h1>Things you want to do!</h1>
            {message && <div className="alert alert-warning">{message}</div>}
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Is Done</th>
                            <th>Target Date</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(
                                todo => (
                                    <tr Key={todo.id}>
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        {/* <td>{todo.targetDate.toDateString()}</td> */}
                                        <td>{todo.targetDate.toString()}</td>
                                        <td><button className="btn btn-warning" 
                                        onClick={()=>deleteTodo(todo.id)}>Delete</button></td>
                                        <td><button className="btn btn-success" 
                                        onClick={()=>UpdateTodo(todo.id)}>Update</button></td>
                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            </div>
            <div className="btn btn-success m-5" onClick={addNewTodo}>Add New Todo</div>
        </div>
    )
}

export default ListTodos