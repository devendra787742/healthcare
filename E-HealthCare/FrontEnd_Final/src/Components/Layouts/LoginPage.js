import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { FormGroup, Input, Label } from "reactstrap";
import authService from "../../Services/auth.service";
import Footer from "../FrontPageComponents/Footer";
import Header from "../FrontPageComponents/Header";
import TiltCard3D from "../FrontPageComponents/TiltCard3D";
import "./LoginPage.css";

const LoginPage = () => {
  const [user, setUser] = useState({ email: "", password: "" });
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const validateUser = async (e) => {
    e.preventDefault();
    setLoading(true);
    try {
      let path = await authService.login(user);
      navigate(path);
    } catch (err) {
      console.error("Login failed", err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="login-page-root">
      <Header />

      <div className="login-hero-container d-flex align-items-center justify-content-center py-5">
        <div className="login-ambient-glow"></div>

        <div className="container">
          <div className="row justify-content-center align-items-center g-5">
            {/* Left Visual Banner */}
            <div className="col-lg-5 d-none d-lg-block text-white">
              <div className="section-pill mb-3">
                <span className="pill-dot"></span>
                SECURE HEALTH VAULT
              </div>
              <h2 className="display-5 fw-bold mb-3">
                Welcome Back to <br />
                <span className="gradient-text-cyan">E-HealthCare</span>
              </h2>
              <p className="text-light opacity-80 fs-5 mb-4">
                Access your personalized patient portal, consultation schedules, electronic prescriptions, and diagnostic lab reports with 256-bit bank-grade encryption.
              </p>
              <div className="d-flex flex-column gap-3">
                <div className="d-flex align-items-center gap-3">
                  <div className="login-feature-icon">
                    <i className="bi bi-shield-lock-fill text-info"></i>
                  </div>
                  <div>
                    <div className="fw-bold">End-to-End Encrypted</div>
                    <div className="text-muted small">HIPAA & ISO-27001 Certified Protection</div>
                  </div>
                </div>
                <div className="d-flex align-items-center gap-3">
                  <div className="login-feature-icon">
                    <i className="bi bi-person-badge-fill text-success"></i>
                  </div>
                  <div>
                    <div className="fw-bold">Role-Based Access</div>
                    <div className="text-muted small">Dedicated dashboards for Patients, Doctors & Admins</div>
                  </div>
                </div>
              </div>
            </div>

            {/* Right: Glassmorphic 3D Login Card */}
            <div className="col-lg-5 col-md-8">
              <TiltCard3D className="login-3d-card" maxTilt={10}>
                <div className="p-4 p-md-5">
                  <div className="text-center mb-4">
                    <div className="login-logo-circle mb-3 mx-auto">
                      <img
                        src={require("../../Images/LOGO.png")}
                        alt="Logo"
                        className="login-brand-img"
                      />
                    </div>
                    <h3 className="text-white fw-bold mb-1">Sign In to Account</h3>
                    <p className="text-muted small">Enter your credentials to access your dashboard</p>
                  </div>

                  <form onSubmit={validateUser}>
                    <FormGroup className="mb-3">
                      <Label for="loginEmail" className="text-light small fw-semibold">
                        Email Address
                      </Label>
                      <div className="input-with-icon">
                        <i className="bi bi-envelope text-muted"></i>
                        <Input
                          id="loginEmail"
                          className="custom-login-input"
                          name="email"
                          placeholder="e.g. user@hospital.com"
                          type="email"
                          value={user.email}
                          onChange={(e) => setUser({ ...user, email: e.target.value })}
                          required
                        />
                      </div>
                    </FormGroup>

                    <FormGroup className="mb-4">
                      <Label for="loginPassword" className="text-light small fw-semibold">
                        Password
                      </Label>
                      <div className="input-with-icon">
                        <i className="bi bi-key text-muted"></i>
                        <Input
                          id="loginPassword"
                          className="custom-login-input"
                          name="password"
                          placeholder="••••••••"
                          type="password"
                          value={user.password}
                          onChange={(e) => setUser({ ...user, password: e.target.value })}
                          required
                        />
                      </div>
                    </FormGroup>

                    <button
                      type="submit"
                      disabled={loading}
                      className="btn w-100 login-submit-btn py-3 fw-bold mb-3"
                    >
                      {loading ? (
                        <span>
                          <span className="spinner-border spinner-border-sm me-2"></span>
                          Verifying Credentials...
                        </span>
                      ) : (
                        <span>
                          <i className="bi bi-box-arrow-in-right me-2"></i>
                          Sign In
                        </span>
                      )}
                    </button>

                    <div className="text-center mt-3 pt-3 border-top border-secondary border-opacity-25">
                      <span className="text-muted small">Don't have an account yet? </span>
                      <Link to="/register" className="text-info fw-semibold small text-decoration-none">
                        Register as Patient
                      </Link>
                    </div>
                  </form>
                </div>
              </TiltCard3D>
            </div>
          </div>
        </div>
      </div>

      <Footer />
    </div>
  );
};

export default LoginPage;
