import { useParams, useNavigate } from "react-router-dom"
import { useAuth } from "./Security/Auth"
import { createTodoApi, retreiveTodoApi, updateTodoApi } from "./API/TodoServiceAPI"
import { useEffect, useState } from "react"
import { Formik, Form, Field, ErrorMessage } from "formik"
import moment from "moment"

export default function UpdateTodo() {

    const { id } = useParams()

    const [description, SetDescription] = useState('')
    const [targetDate, SetTargetDate] = useState('')

    const navigate = useNavigate()

    const AuthContext = useAuth()
    const username = AuthContext.username

    useEffect(
        () => retreiveTodos(), [id]
    )

    function retreiveTodos() {

        if (id != -1) {
            retreiveTodoApi(username, id)
                .then(response => {
                    SetDescription(response.data.description)
                    SetTargetDate(response.data.targetDate)
                }
                )
                .catch(error => console.log(error))
        }
    }

    function onSubmit(values) {

        const todo = {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        }

        if (id == -1) {
            createTodoApi(username, todo)
                .then(response => {
                    navigate('/todos')
                }
                )
                .catch(error => console.log(error))
        } else {
            updateTodoApi(username, id, todo)
                .then(response => {
                    navigate('/todos')
                }
                )
                .catch(error => console.log(error))
        }

    }

    function validate(values) {

        let errors = {

        }

        if (values.description.length < 5) {
            errors.description = 'Enter atleast 5 characters'
        }

        if (values.targetDate == null || values.targetDate == ''|| !moment(values.targetDate).isValid) {
            errors.targetDate = 'Enter a Target Date'
        }

        console.log(values)
        return errors
    }

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>
                <Formik initialValues={{ description, targetDate }}
                    enableReinitialize={true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage
                                    name="description"
                                    component="div"
                                    className="alert alert-warning"
                                />

                                <ErrorMessage
                                    name="targetDate"
                                    component="div"
                                    className="alert alert-warning"
                                />

                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field type="text" className="form-control" name="description" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target Date</label>
                                    <Field type="date" className="form-control" name="targetDate" />
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}