import React, { useState } from "react";
import { Link } from "react-router-dom";
import Medical3DScene from "./Medical3DScene";
import ImpactStats from "./ImpactStats";
import DepartmentSection from "./DepartmentSection";
import SymptomNavigator from "./SymptomNavigator";
import DoctorsReview from "./DoctorsReview";
import TiltCard3D from "./TiltCard3D";
import "./Middle.css";

function Middle() {
  const [ecgBpm, setEcgBpm] = useState(74);

  return (
    <div className="middle-wrapper">
      {/* ================= HERO SECTION WITH 3D CANVAS ================= */}
      <section className="hero-3d-section position-relative">
        {/* Ambient background glow orbs */}
        <div className="ambient-glow glow-cyan"></div>
        <div className="ambient-glow glow-emerald"></div>

        <div className="container py-5">
          <div className="row align-items-center g-5 min-vh-75">
            {/* Left Column: Hero Content & CTAs */}
            <div className="col-lg-6 hero-content-col">
              <div className="hero-badge mb-3">
                <span className="beacon-ring"></span>
                <span className="hero-badge-text">
                  <i className="bi bi-shield-check me-1 text-info"></i>
                  ISO-27001 & HIPAA CERTIFIED DIGITAL HEALTH PLATFORM
                </span>
              </div>

              <h1 className="hero-headline fw-bolder mb-3">
                Intelligent Healthcare, <br />
                Reimagined with <br />
                <span className="gradient-text-3d">3D Precision & Care</span>
              </h1>

              <p className="hero-description text-light opacity-90 fs-5 mb-4">
                Connect with world-class specialists in seconds, consult via secure
                telehealth, track electronic treatment records, and explore anatomical
                insights through our interactive 3D medical visualizer.
              </p>

              {/* Action Buttons */}
              <div className="d-flex flex-wrap gap-3 mb-4">
                <Link to="/login" className="btn btn-lg hero-cta-btn">
                  <i className="bi bi-calendar2-check-fill me-2"></i>
                  Book Doctor Consultation
                </Link>
                <a href="#departments" className="btn btn-lg hero-outline-btn">
                  <i className="bi bi-compass me-2"></i>
                  Explore Specialties
                </a>
              </div>

              {/* Live Vitals & Trust Highlights */}
              <div className="row g-3 pt-2">
                <div className="col-sm-6">
                  <div className="live-vitals-card p-3 d-flex align-items-center gap-3">
                    <div className="vitals-heartbeat-box">
                      <i className="bi bi-heart-pulse-fill text-danger fs-4 pulse-icon"></i>
                    </div>
                    <div>
                      <div className="small text-muted fw-semibold">LIVE VITALS SYNC</div>
                      <div className="fw-bold text-white">
                        {ecgBpm} BPM <span className="badge bg-success bg-opacity-25 text-success ms-1">Normal</span>
                      </div>
                    </div>
                  </div>
                </div>

                <div className="col-sm-6">
                  <div className="live-vitals-card p-3 d-flex align-items-center gap-3">
                    <div className="vitals-doctor-box">
                      <i className="bi bi-person-check-fill text-info fs-4"></i>
                    </div>
                    <div>
                      <div className="small text-muted fw-semibold">ON-CALL DOCTORS</div>
                      <div className="fw-bold text-white">
                        42 Available <span className="badge bg-info bg-opacity-25 text-info ms-1">Active Now</span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            {/* Right Column: Interactive 3D Medical Scene & Tilt Overlays */}
            <div className="col-lg-6 position-relative hero-3d-col">
              <Medical3DScene />

              {/* Floating 3D Micro-Cards around the Canvas */}
              <div className="floating-card floating-card-top-right d-none d-md-block">
                <div className="micro-badge">
                  <i className="bi bi-activity text-danger me-2"></i>
                  <div>
                    <div className="text-white fw-bold small">Real-Time Telehealth</div>
                    <div className="text-muted text-xs">Zero-Buffer Encrypted Video</div>
                  </div>
                </div>
              </div>

              <div className="floating-card floating-card-bottom-left d-none d-md-block">
                <div className="micro-badge">
                  <i className="bi bi-prescription2 text-success me-2"></i>
                  <div>
                    <div className="text-white fw-bold small">Smart E-Prescriptions</div>
                    <div className="text-muted text-xs">Instant Pharmacy Fulfillment</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* ================= IMPACT & NUMERICAL MILESTONES ================= */}
      <ImpactStats />

      {/* ================= CLINICAL SPECIALTIES IN 3D PERSPECTIVE ================= */}
      <DepartmentSection />

      {/* ================= INTERACTIVE SYMPTOM NAVIGATOR ================= */}
      <SymptomNavigator />

      {/* ================= WHY CHOOSE OUR PLATFORM (INTERACTIVE CARDS) ================= */}
      <section className="why-us-section py-5">
        <div className="container">
          <div className="text-center mb-5">
            <div className="section-pill mb-2">
              <span className="pill-dot"></span>
              THE E-HEALTHCARE ADVANTAGE
            </div>
            <h2 className="section-title text-white">
              Why Millions Trust Our <span className="gradient-text-cyan">Healthcare Ecosystem</span>
            </h2>
            <p className="section-subtitle">
              Engineered from the ground up for medical accuracy, speed, patient privacy, and effortless doctor scheduling.
            </p>
          </div>

          <div className="row g-4">
            {[
              {
                icon: "bi-camera-video-fill",
                color: "#06b6d4",
                title: "Instant Video Consultations",
                desc: "Consult certified physicians without traveling. HD audio/video consultations with interactive screen-sharing of medical reports.",
              },
              {
                icon: "bi-file-earmark-medical-fill",
                color: "#10b981",
                title: "Unified Digital Health Vault",
                desc: "Access your blood test reports, historical treatments, prescription history, and doctor feedbacks from any device 24/7.",
              },
              {
                icon: "bi-shield-lock-fill",
                color: "#8b5cf6",
                title: "Bank-Grade Encryption",
                desc: "All health diagnostics, personal data, and payment details are safeguarded with AES-256 encryption and multi-factor validation.",
              },
              {
                icon: "bi-credit-card-2-front-fill",
                color: "#f59e0b",
                title: "Seamless Online Payments",
                desc: "Integrated Razorpay payment gateway for transparent, hassle-free doctor fees, lab diagnostic billings, and digital receipts.",
              },
            ].map((adv, idx) => (
              <div className="col-lg-3 col-md-6" key={idx}>
                <TiltCard3D className="adv-card-3d h-100" maxTilt={14}>
                  <div className="p-4 d-flex flex-column h-100">
                    <div
                      className="adv-icon-box mb-3"
                      style={{
                        backgroundColor: `${adv.color}15`,
                        color: adv.color,
                        boxShadow: `0 0 20px ${adv.color}25`,
                      }}
                    >
                      <i className={`bi ${adv.icon} fs-4`}></i>
                    </div>
                    <h4 className="text-white fw-bold fs-5 mb-2">{adv.title}</h4>
                    <p className="text-muted small mb-0 flex-grow-1">{adv.desc}</p>
                  </div>
                </TiltCard3D>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* ================= VERIFIED DOCTORS & REVIEWS ================= */}
      <DoctorsReview />

      {/* ================= EMERGENCY BANNER CTA ================= */}
      <section className="emergency-banner-section py-5">
        <div className="container">
          <div className="emergency-banner-card p-4 p-md-5 d-flex flex-column flex-lg-row align-items-center justify-content-between gap-4">
            <div className="d-flex align-items-center gap-4">
              <div className="emergency-icon-ring">
                <i className="bi bi-telephone-inbound-fill fs-2 text-danger"></i>
              </div>
              <div>
                <span className="badge bg-danger text-uppercase px-3 py-1 mb-2">
                  Emergency Response 24/7
                </span>
                <h3 className="text-white fw-bold mb-1">
                  Experiencing an Acute Medical Emergency?
                </h3>
                <p className="text-light opacity-80 mb-0">
                  Direct priority dispatch to ICU, trauma centers, and mobile emergency ambulance.
                </p>
              </div>
            </div>
            <div className="d-flex flex-wrap gap-3">
              <a href="tel:8308308308" className="btn btn-danger btn-lg px-4 emergency-call-btn">
                <i className="bi bi-telephone-fill me-2"></i>
                Call 830-830-8308
              </a>
              <Link to="/register" className="btn btn-outline-light btn-lg px-4">
                Register as Patient
              </Link>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Middle;
