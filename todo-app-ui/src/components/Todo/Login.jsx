import { useState } from 'react';
import {useNavigate } from 'react-router-dom';
import { useAuth } from './Security/Auth';
import './todo.css';

function Login(){

    const [username, setUsername] = useState('Pawan')

    const [password, setPassword] = useState('')

    const [errorMessage, setErrorMessage] = useState(false)

    const navigate = useNavigate();

    const authContext = useAuth()

    function handleUsername(event){
        setUsername(event.target.value)
    }

    function handlePassword(event){
        setPassword(event.target.value)
    }

    async function login(){
        if(await authContext.login(username, password)){
            navigate(`/welcome/${username}`)
        } else {
            setErrorMessage(true)
        }
    }

    function ErrorMessgeComponent(){
        if (errorMessage) {
            return <div className='ErrorMessage'>
                Authentication Failed. Please check your credentials.</div>
        } return null
    }

    return(
        <div className="Login">
            <h1>Login</h1>
            <div>
                <div>
                    <ErrorMessgeComponent/>
                    <label>User Name:</label>
                    <input type="text" name="Username" 
                    value={username} onChange={handleUsername}/>
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" name="Password" 
                    value={password} onChange={handlePassword}/>
                </div>
                <div>
                    <button type="button" name="login" onClick={login}>Login</button>
                </div>
            </div>
        </div>
    )
}

export default Login