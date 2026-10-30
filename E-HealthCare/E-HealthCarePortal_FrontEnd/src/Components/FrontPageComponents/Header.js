import React, { useState, useEffect } from "react";
import { Link, useLocation } from "react-router-dom";
import "./Header.css";

const Header = () => {
  const [isScrolled, setIsScrolled] = useState(false);
  const [navOpen, setNavOpen] = useState(false);
  const location = useLocation();

  useEffect(() => {
    const handleScroll = () => {
      if (window.scrollY > 20) {
        setIsScrolled(true);
      } else {
        setIsScrolled(false);
      }
    };
    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  return (
    <header className={`modern-header noprint ${isScrolled ? "scrolled" : ""}`}>
      <nav className="navbar navbar-expand-lg navbar-dark container py-2">
        {/* Brand Logo & Name */}
        <Link className="navbar-brand d-flex align-items-center gap-2" to="/">
          <div className="logo-3d-wrapper">
            <img
              src={require("../../Images/LOGO.png")}
              alt="E-HealthCare Logo"
              className="logo-img"
            />
            <span className="logo-glow-ring"></span>
          </div>
          <div className="d-flex flex-column">
            <span className="brand-title">
              E-Health<span className="brand-accent">Care</span>
            </span>
            <span className="brand-tagline">3D DIGITAL PORTAL</span>
          </div>
        </Link>

        {/* Mobile Hamburger Toggle */}
        <button
          className="navbar-toggler custom-toggler"
          type="button"
          onClick={() => setNavOpen(!navOpen)}
          aria-controls="mainNavbar"
          aria-expanded={navOpen}
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        {/* Navigation Links & Buttons */}
        <div className={`collapse navbar-collapse ${navOpen ? "show" : ""}`} id="mainNavbar">
          <ul className="navbar-nav mx-auto mb-2 mb-lg-0 gap-1 gap-lg-3">
            <li className="nav-item">
              <Link
                className={`nav-link nav-link-custom ${location.pathname === "/" ? "active" : ""}`}
                to="/"
                onClick={() => setNavOpen(false)}
              >
                <i className="bi bi-house-door me-1"></i> Home
              </Link>
            </li>
            <li className="nav-item">
              <a
                className="nav-link nav-link-custom"
                href="#departments"
                onClick={() => setNavOpen(false)}
              >
                <i className="bi bi-grid me-1"></i> Specialties
              </a>
            </li>
            <li className="nav-item">
              <a
                className="nav-link nav-link-custom"
                href="#reviews"
                onClick={() => setNavOpen(false)}
              >
                <i className="bi bi-person-badge me-1"></i> Doctors
              </a>
            </li>
            <li className="nav-item">
              <Link
                className={`nav-link nav-link-custom ${location.pathname === "/about" ? "active" : ""}`}
                to="/about"
                onClick={() => setNavOpen(false)}
              >
                <i className="bi bi-info-circle me-1"></i> About Us
              </Link>
            </li>
            <li className="nav-item">
              <a
                className="nav-link nav-link-custom"
                href="#contactus"
                onClick={() => setNavOpen(false)}
              >
                <i className="bi bi-telephone me-1"></i> Contact
              </a>
            </li>
          </ul>

          {/* Right: Emergency Pill & Auth Buttons */}
          <div className="d-flex flex-wrap align-items-center gap-2 mt-3 mt-lg-0">
            <a
              href="tel:8308308308"
              className="emergency-hotline-pill d-none d-xl-flex align-items-center gap-2"
              title="24/7 Medical Emergency Hotline"
            >
              <span className="emergency-beacon"></span>
              <span>830-830-8308</span>
            </a>

            <Link
              to="/login"
              className="btn btn-sm btn-nav-login"
              onClick={() => setNavOpen(false)}
            >
              <i className="bi bi-box-arrow-in-right me-1"></i> Login
            </Link>

            <Link
              to="/register"
              className="btn btn-sm btn-nav-register"
              onClick={() => setNavOpen(false)}
            >
              <i className="bi bi-person-plus-fill me-1"></i> Get Started
            </Link>
          </div>
        </div>
      </nav>
    </header>
  );
};

export default Header;
