import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./Footer.css";

const Footer = () => {
  const [emailInput, setEmailInput] = useState("");
  const [subscribed, setSubscribed] = useState(false);

  const handleSubscribe = (e) => {
    e.preventDefault();
    if (emailInput.trim()) {
      setSubscribed(true);
      setEmailInput("");
      setTimeout(() => setSubscribed(false), 4000);
    }
  };

  const scrollToTop = (e) => {
    e.preventDefault();
    window.scrollTo({ top: 0, behavior: "smooth" });
  };

  return (
    <footer className="modern-footer noprint" id="contactus">
      {/* Top Footer Grid */}
      <div className="container py-5">
        <div className="row g-4">
          {/* Column 1: Brand & Certification */}
          <div className="col-lg-4 col-md-6">
            <div className="d-flex align-items-center gap-2 mb-3">
              <div className="footer-logo-wrapper">
                <img
                  src={require("../../Images/LOGO.png")}
                  alt="E-HealthCare"
                  className="footer-logo-img"
                />
              </div>
              <div>
                <h4 className="text-white fw-bold mb-0">E-HealthCare</h4>
                <span className="footer-tagline">3D DIGITAL CLINICAL PORTAL</span>
              </div>
            </div>

            <p className="text-muted small pe-lg-4 mb-4">
              Transforming patient experience through interactive 3D anatomy visualization,
              real-time doctor teleconsultation, integrated lab analytics, and secure electronic health records.
            </p>

            {/* Certifications & Badges */}
            <div className="d-flex flex-wrap gap-2 mb-4">
              <span className="cert-pill">
                <i className="bi bi-shield-check text-success me-1"></i> HIPAA Compliant
              </span>
              <span className="cert-pill">
                <i className="bi bi-lock-fill text-info me-1"></i> 256-Bit SSL
              </span>
              <span className="cert-pill">
                <i className="bi bi-award-fill text-warning me-1"></i> ISO 27001
              </span>
            </div>

            {/* Social Links */}
            <div className="d-flex gap-2">
              {[
                { icon: "bi-twitter-x", url: "#" },
                { icon: "bi-linkedin", url: "#" },
                { icon: "bi-facebook", url: "#" },
                { icon: "bi-youtube", url: "#" },
              ].map((s, idx) => (
                <a key={idx} href={s.url} className="social-icon-box">
                  <i className={`bi ${s.icon}`}></i>
                </a>
              ))}
            </div>
          </div>

          {/* Column 2: Specialties */}
          <div className="col-lg-2 col-md-6">
            <h5 className="footer-heading">Specialties</h5>
            <ul className="footer-links-list">
              <li><a href="#departments">Cardiology Center</a></li>
              <li><a href="#departments">Neurology & Brain</a></li>
              <li><a href="#departments">Orthopedics & Spine</a></li>
              <li><a href="#departments">Pediatric Health</a></li>
              <li><a href="#departments">Oncology Clinic</a></li>
              <li><a href="#departments">Emergency & Trauma</a></li>
            </ul>
          </div>

          {/* Column 3: Patient Portal */}
          <div className="col-lg-2 col-md-6">
            <h5 className="footer-heading">Portal Access</h5>
            <ul className="footer-links-list">
              <li><Link to="/login">Patient Sign In</Link></li>
              <li><Link to="/register">Create Patient Account</Link></li>
              <li><Link to="/login">Doctor Portal</Link></li>
              <li><Link to="/login">Admin Management</Link></li>
              <li><Link to="/about">About Our Vision</Link></li>
              <li><a href="#reviews">Doctor Reviews</a></li>
            </ul>
          </div>

          {/* Column 4: 24/7 Contacts & Newsletter */}
          <div className="col-lg-4 col-md-6">
            <h5 className="footer-heading">24/7 Emergency & Dispatch</h5>
            <div className="contact-info-box p-3 mb-3">
              <div className="d-flex align-items-center gap-3 mb-2">
                <i className="bi bi-telephone-fill text-danger fs-5"></i>
                <div>
                  <div className="text-white fw-bold">+91 830-830-8308</div>
                  <div className="text-muted small">Ambulance & Trauma Hotline</div>
                </div>
              </div>
              <div className="d-flex align-items-center gap-3">
                <i className="bi bi-envelope-at-fill text-info fs-5"></i>
                <div>
                  <a href="mailto:care@ehealthcareportal.com" className="text-white text-decoration-none small">
                    care@ehealthcareportal.com
                  </a>
                  <div className="text-muted small">Clinical Inquiries & Reports</div>
                </div>
              </div>
            </div>

            {/* Newsletter */}
            <form onSubmit={handleSubscribe} className="newsletter-form">
              <div className="input-group">
                <input
                  type="email"
                  className="form-control newsletter-input"
                  placeholder="Your Email for Health Updates"
                  value={emailInput}
                  onChange={(e) => setEmailInput(e.target.value)}
                  required
                />
                <button className="btn btn-newsletter" type="submit">
                  <i className="bi bi-send-fill"></i>
                </button>
              </div>
              {subscribed && (
                <div className="newsletter-success mt-2 small text-success">
                  <i className="bi bi-check-circle-fill me-1"></i>
                  Subscribed to wellness bulletins!
                </div>
              )}
            </form>
          </div>
        </div>
      </div>

      {/* Bottom Bar */}
      <div className="footer-bottom-bar py-3 border-top border-secondary border-opacity-25">
        <div className="container d-flex flex-column flex-md-row justify-content-between align-items-center gap-2">
          <div className="text-muted small">
            &copy; {new Date().getFullYear()} E-HealthCare Systems Inc. All clinical rights reserved.
          </div>
          <div className="d-flex align-items-center gap-3">
            <a href="#" className="footer-sublink">Privacy Policy</a>
            <span className="text-muted">·</span>
            <a href="#" className="footer-sublink">Terms of Service</a>
            <span className="text-muted">·</span>
            <button onClick={scrollToTop} className="btn-back-top ms-2" title="Scroll to Top">
              <i className="bi bi-arrow-up"></i>
            </button>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
