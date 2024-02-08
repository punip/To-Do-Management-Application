import axios from "axios";

const BASE_URL  = "http://localhost:9191/api/todos";

export const createTodo = (todo:any) => axios.post(BASE_URL,todo);

export const getAllTodos = () => axios.get(BASE_URL);

export const updateTodo = (id:number,todo:any) => axios.put(BASE_URL + '/' +id,todo);

export const getTodoById = (id:number) => axios.get(BASE_URL + '/'+id);

export const deleteTodo = (id:number) => axios.delete(BASE_URL + '/'+id);

export const completeTodo = (id:number) => axios.patch(BASE_URL + '/' + id + '/complete');

export const inCompleteTodo = (id:number) => axios.patch(BASE_URL + '/' + id + '/incomplete');