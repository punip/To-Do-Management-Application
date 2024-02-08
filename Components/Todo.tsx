import { FormEvent, useEffect, useState } from "react";
import { useHistory, useParams } from "react-router";
import { createTodo, getTodoById, updateTodo } from "../Services/TodoService";
import { Container, Row, Col, Form, Button } from "react-bootstrap";

type RouteParam = {
    id: string
}

const Todo: React.FC = () => {

    const navigator = useHistory();
    const { id } = useParams<RouteParam>();

    const [todoTitle, setTodoTitle] = useState<string>();
    const [todoDescription, setTodoDescription] = useState<string>();
    const [todoCompleted, setTodoCompleted] = useState<string>();

    const saveOrUpdate = (e: FormEvent) => {
        e.preventDefault();

        const todo = { todoTitle, todoDescription, todoCompleted }

        if (id) {
            updateTodo(Number(id), todo)
                .then(() => navigator.push("/todo"))
                .catch((error) => console.log(error)
                )
        }
        else {
            createTodo(todo)
                .then(() =>
                    navigator.push("/todo")
                )
                .catch((error) => console.log(error));
        }
    }

    const pageTitle = () => {
        const todoTitle = id? "Update Todo":"Add Todo";
        return(<h1>{todoTitle}</h1>)
    }

    useEffect(
        () => {
            if (id) {
                getTodoById(Number(id))
                    .then((response) => {
                        setTodoTitle(response.data.todoTitle);
                        setTodoDescription(response.data.todoDescription);
                        setTodoCompleted(response.data.todoCompleted);
                    })
            }
        }, [id])

    return (<>

        <Container>
        <div style={{textAlign:"center"}}>
            {
            pageTitle()
            }
        </div>
            <Row>
                <Col>
                    <Form>
                        <br/>
                        <Form.Label >Todo Title</Form.Label>
                        <Form.Control type="text" placeholder="Todo Title" value={todoTitle} onChange={(e) => setTodoTitle(e.target.value)} /><br/>
                        <Form.Label >Todo Description</Form.Label>
                        <Form.Control type="text" placeholder="Todo Description"
                            value={todoDescription} onChange={(e) => setTodoDescription(e.target.value)}  /><br/>
                        <Form.Label>Todo Completed</Form.Label>
                        <Form.Select value={todoCompleted} onChange={(e) => setTodoCompleted(e.target.value)} >
                        <option >Select choice</option>
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                      </Form.Select>
                    </Form>
                </Col>
            </Row><br/>
            <Button onClick={(e) => saveOrUpdate(e)} variant="success">submit</Button>
        </Container>
    </>)
}
export default Todo