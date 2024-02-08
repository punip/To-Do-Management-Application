import { Route, Switch } from "react-router";
import ListTodo from "./Components/ListTodo";
import Navigation from "./Components/Navigation";
import Todo from "./Components/Todo";
import Footer from "./Components/Footer";

const Home = () => {
  return(<>
  <h1 style={{textAlign:"center"}}>Todo Management Application</h1>
  </>)
}

function App() {
  return (<>
    <Navigation/>
    <Switch>
    <Route exact path="/"><Home/></Route>
      <Route exact path="/todo"><ListTodo/></Route>
      <Route exact path="/edit-todo/:id"><Todo/></Route>
      <Route exact path="/add-todo"><Todo/></Route>
    </Switch>
    <Footer/>
  </>
  );
}

export default App;
