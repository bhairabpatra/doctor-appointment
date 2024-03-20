import React from "react";
import "./App.css";
import '@fortawesome/fontawesome-free/css/all.css';
import Header from "./common/Header";
import Footer from "./common/Footer";
import Topbanner from "./components/Topbanner/Topbanner";
import Specialist from "./components/Specialist/Specialist";
import Health from "./components/Health/Health";

function App() {
  return (
    
    <div className="App">
      <Header/>
      <Topbanner/>
      <Specialist/>
      <Health/>
      <Footer/>
    
    </div>
  );
}

export default App;
