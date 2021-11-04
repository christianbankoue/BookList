import { Col, Container, Row } from "react-bootstrap";
import Footer from "./component/Footer";
import NavigationBar from "./component/NavigationBar";

function App() {
  return (
    <>
      <NavigationBar />
      <Container>
        <Row>
          <Col>1 of 1</Col>
        </Row>
      </Container>
      <Footer/>
    </>
  );
}

export default App;
