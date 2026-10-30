import React from "react";
import Header from "./Header";
import Middle from "./Middle";
import Footer from "./Footer";
import "./Home.css";

const Home1 = () => {
  return (
    <div className="home-root">
      <Header />
      <main>
        <Middle />
      </main>
      <Footer />
    </div>
  );
};

export default Home1;
