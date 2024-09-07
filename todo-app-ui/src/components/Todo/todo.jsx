import { BrowserRouter, Route, Routes, Navigate}
    from 'react-router-dom';
import Login from './Login';
import ListTodos from './ListTodos';
import UpdateTodo from './UpdateTodo';
import Header from './Header';
import LogOut from './Logout';
import Welcome from './Welcome';
import Error from './Error';
import AuthProvider from './Security/Auth';
import { useAuth } from './Security/Auth';
import './todo.css';

function AuthenticatedRoute({children}){

    const authContext = useAuth()
    if(authContext.isAuthenticated)
        return children

    return <Navigate to="/"/>
}

export default function TodoApp(){
    return(
        <div>
            <div className="TodoApp"></div>
            <AuthProvider>
                <BrowserRouter>
                    <Header />
                    <Routes>
                        <Route path='/' element={<Login />}/>
                        <Route path='/login' element={<Login />}/>

                        <Route path='/welcome/:username' element={
                            <AuthenticatedRoute><Welcome /></AuthenticatedRoute>}/>

                        <Route path='/todos' element={
                            <AuthenticatedRoute><ListTodos /></AuthenticatedRoute>}/>

                        <Route path='/todo/:id' element={
                            <AuthenticatedRoute><UpdateTodo /></AuthenticatedRoute>} />

                        <Route path='/logout' element={
                            <AuthenticatedRoute><LogOut /></AuthenticatedRoute>}/>

                        <Route path='/*' element={<Error />}/>
                    </Routes>
                    {/* <Footer /> */}
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}