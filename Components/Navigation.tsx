import { Navbar, Container, Nav } from "react-bootstrap"

const Navigation:React.FC = () => {
    return(<>

<Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="/">Home</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/todo">Todos</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>)
}
export default Navigation