import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { Link, useHistory } from "react-router-dom";
import { completeTodo, deleteTodo, getAllTodos, inCompleteTodo } from "../Services/TodoService";

type Todo = {
    id: number;
    todoTitle: string,
    todoDescription: string,
    todoCompleted: boolean,
}

const ListTodo: React.FC = () => {

    const navigator = useHistory();
    
    const [todos, setTodos] = useState<Todo[]>([]);

    const updateTodo = (id:number) => {
        navigator.push(`/edit-todo/${id}`)
    }

    const ListTodos = () => {
        getAllTodos()
        .then((response) => {
            setTodos(response.data);
            console.log(response.data);
        })
        .catch((error) => console.log(error))
    }

    const removeTodo = (id:number) => {
        deleteTodo(id)
        .then(() => ListTodos())
        .catch((error) => console.log(error))
    }

    const complete = (id:number) => {
        completeTodo(id)
        .then(() => ListTodos())
        .catch((error) => console.log(error))
    }

    const inComplete = (id:number) => {
        inCompleteTodo(id)
        .then(() => ListTodos())
        .catch((error) =>  console.log(error))
    }

    useEffect(() => ListTodos(),[])

    return (<>
        <h1 style={{textAlign:"center"}}>List of Todos</h1>
        <Link to='/add-todo' className='btn btn-primary mb-2'>Add Todo</Link>
        <Table striped bordered hover >
            <thead >
                <tr >
                    <th>Todo ID</th>
                    <th>Todo Title</th>
                    <th>Todo Description</th>
                    <th>Todo Completed</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    todos.map(todo =>
                        <tr key={todo.id}>
                            <td>{todo.id}</td>
                            <td>{todo.todoTitle}</td>
                            <td>{todo.todoDescription}</td>
                            <td>{todo.todoCompleted?"Yes":"No"}</td>
                            <td>
                                <Button onClick={() => updateTodo(todo.id)} variant="info">Update</Button>{' '}
                                <Button onClick={() => removeTodo(todo.id)} variant="danger">Delete</Button>{' '}
                                <Button onClick={() => complete(todo.id)} variant="success">Complete</Button>{' '}
                                <Button onClick={() => inComplete(todo.id)} variant="danger">In Complete</Button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </Table>
        
    </>)
}
export default ListTodo;