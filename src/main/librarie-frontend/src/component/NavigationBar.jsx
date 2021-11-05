import { Navbar, Nav, Container } from "react-bootstrap";

const NavigationBar = () => {
    
    return(
        <>
            <Navbar bg="dark" variant="dark" fixed="top">
                <Container>
                    <Navbar.Brand href="#home"><img src="https://upload.wikimedia.org/wikipedia/commons/b/ba/Book_icon_1.png" width="25" height="25" alt="brand"/>
                    {" "} Librarie
                    </Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="#home">Add Book</Nav.Link>
                        <Nav.Link href="#features">Book List</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
        </>
    )
}

export default NavigationBar;