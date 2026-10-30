import React from "react";
import "./About.css";
import Footer from "./Footer";
import Header from "./Header";

const About = () => {
  return (
    <div>
      <Header />
      <section className="about" id="about">
        {" "}
        <div className="text-center mt-3 fs-1">
          <h1 style={{ fontSize: "5rem" }}>About Us</h1>{" "}
        </div>
        <div className="row">
          <div className="image">
            <img src={require("../../Images/about-img.png")} />
          </div>

          <div className="content">
            <h3>we take care of your healthy life</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iure
              ducimus, quod ex cupiditate ullam in assumenda maiores et culpa
              odit tempora ipsam qui, quisquam quis facere iste fuga, minus
              nesciunt.
            </p>
            <p>
              Lorem ipsum dolor, sit amet consectetur adipisicing elit. Natus
              vero ipsam laborum porro voluptates voluptatibus a nihil
              temporibus deserunt vel?
            </p>
            <a href="#" className="btn">
              {" "}
              learn more <span className="fas fa-chevron-right"></span>{" "}
            </a>
          </div>
        </div>
      </section>
      <Footer />
    </div>
  );
};

export default About;
