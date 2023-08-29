import EmployeCompnts from "./components/EmployeCompnts";
import ListEmployeComponenet from "./components/ListEmployeComponenet";
import FooterComponent from "./components/footer/FooterComponent";
import HeaderComponent from "./components/header/HeaderComponent";
import { BrowserRouter,Routes, Route } from "react-router-dom";

function App() {


  return (
    <>
      <BrowserRouter>
          <HeaderComponent/>

             <Routes>
                <Route path="/" element={<ListEmployeComponenet/>}></Route>
            </Routes>
            <Routes>
                <Route path="/edite-employe/:id" element={<EmployeCompnts/>}></Route>
            </Routes>
            <Routes>
                <Route path="/employes" element={<ListEmployeComponenet/>}></Route>
            </Routes>
            <Routes>
              <Route path="/add-employe" element={<EmployeCompnts/>}></Route> 
            </Routes>
          <FooterComponent/>
       </BrowserRouter>  
    </>
  )
}

export default App
