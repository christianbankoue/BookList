import { Col, Container, Row } from "react-bootstrap";
import Footer from "./component/Footer";
import NavigationBar from "./component/NavigationBar";
import "./App.css";

function App() {
  return (
    <>
      <NavigationBar />
      <Container>
        <Row>
          <Col lg={12} className={"margin-top"}>
            
          </Col>
        </Row>
      </Container>
      <Footer/>
    </>
  );
}

export default App;
