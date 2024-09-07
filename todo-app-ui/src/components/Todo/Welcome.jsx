import { useParams, Link } from 'react-router-dom';
import axios from 'axios';
import { useState } from 'react';

function Welcome(){

    const {username} = useParams()

    const [message, setMessage] = useState(null)

    function callTodoApp(){

        axios.get(`http://localhost:8081/users/${username}/listTodos`)
        .then( (response) => successfulResponse(response) )
        .catch ( (error) => errorResponse(error) )
        .finally ( () => console.log('cleanup') )
    }
    
    function successfulResponse(response) {
    console.log(response)
    setMessage(response.data)
    //setMessage(response.data.message)
    }
    
    function errorResponse(error) {
    console.log(error)
    }

    return(
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>
                Manage your Todos- <Link to="/todos"> Go here</Link>
            </div>
            <div className='text info'> {message}</div>
        </div>
    )
}

export default Welcome