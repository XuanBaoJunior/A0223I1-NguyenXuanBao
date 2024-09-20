import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import ListSupplier from "./Components/ListSupplier";


function App() {
  return (
   <>
        <BrowserRouter>
          <Routes>
            <Route path="/supplier/list" element={<ListSupplier />}/>
          </Routes>
        </BrowserRouter>
   </>
  );
}

export default App;
