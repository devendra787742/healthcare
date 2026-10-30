import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./SymptomNavigator.css";

const symptomsData = [
  {
    id: "chest",
    name: "Chest Pain / Palpitations",
    icon: "🫀",
    dept: "Cardiology",
    urgency: "Immediate Attention",
    urgencyClass: "urgency-high",
    doctor: "Dr. Katlynn (Cardiologist)",
    advice: "Do not delay if pain radiates to the arm or jaw. Consult our cardiologist or call our 24/7 hotline.",
    estTime: "Instant Triage",
  },
  {
    id: "migraine",
    name: "Chronic Headache / Vertigo",
    icon: "🧠",
    dept: "Neurology",
    urgency: "Specialist Review",
    urgencyClass: "urgency-med",
    doctor: "Dr. Michale (Neurologist)",
    advice: "Comprehensive EEG and neuro-vascular assessment recommended to rule out migraines or nerve compression.",
    estTime: "Today (15 min wait)",
  },
  {
    id: "joint",
    name: "Joint / Knee / Spine Pain",
    icon: "🦴",
    dept: "Orthopedics",
    urgency: "Elective Care",
    urgencyClass: "urgency-low",
    doctor: "Dr. Gwen (Orthopedic Surgeon)",
    advice: "Targeted digital X-ray and arthroscopy review for cartilage wear, ligament sprains, or disc alignment.",
    estTime: "Available Today",
  },
  {
    id: "child",
    name: "Child Fever / Infection",
    icon: "👶",
    dept: "Pediatrics",
    urgency: "Same-Day Priority",
    urgencyClass: "urgency-med",
    doctor: "Dr. Crystel (Pediatric Specialist)",
    advice: "Gentle pediatric assessment, vitals check, hydration monitoring, and age-appropriate medication plan.",
    estTime: "Within 30 Mins",
  },
  {
    id: "skin",
    name: "Skin Rash / Allergic Flare",
    icon: "✨",
    dept: "Dermatology & Allergy",
    urgency: "General Consult",
    urgencyClass: "urgency-low",
    doctor: "Dr. Norris (Dermatologist)",
    advice: "Clinical allergy mapping, topical therapy review, and dietary trigger diagnosis.",
    estTime: "Available Today",
  },
  {
    id: "general",
    name: "General Weakness / Diabetes",
    icon: "🩺",
    dept: "General Medicine",
    urgency: "Routine Screening",
    urgencyClass: "urgency-low",
    doctor: "Dr. Kristina (Physician)",
    advice: "Complete metabolic panel, fasting blood glucose analysis, and personalized wellness roadmap.",
    estTime: "Walk-In / Online",
  },
];

const SymptomNavigator = () => {
  const [selectedId, setSelectedId] = useState("chest");
  const activeSymptom = symptomsData.find((s) => s.id === selectedId) || symptomsData[0];

  return (
    <section className="symptom-navigator-section py-5">
      <div className="container">
        <div className="text-center mb-5">
          <div className="section-pill mb-2">
            <span className="pill-dot"></span>
            INTERACTIVE HEALTH COMPASS
          </div>
          <h2 className="section-title">
            Smart <span className="gradient-text-cyan">Symptom & Department</span> Triage
          </h2>
          <p className="section-subtitle">
            Select your symptom or health concern below to immediately discover the recommended specialist and care pathway.
          </p>
        </div>

        <div className="symptom-tool-card p-4 p-md-5">
          <div className="row g-4 align-items-center">
            {/* Left: Interactive Symptom Chips */}
            <div className="col-lg-6">
              <h4 className="text-white fw-bold mb-3 d-flex align-items-center gap-2">
                <i className="bi bi-ui-checks-grid text-info"></i>
                Select What You Are Experiencing:
              </h4>
              <div className="symptom-chips-grid">
                {symptomsData.map((symptom) => (
                  <button
                    key={symptom.id}
                    className={`symptom-chip ${selectedId === symptom.id ? "active" : ""}`}
                    onClick={() => setSelectedId(symptom.id)}
                  >
                    <span className="chip-icon">{symptom.icon}</span>
                    <span className="chip-name">{symptom.name}</span>
                    {selectedId === symptom.id && (
                      <span className="chip-active-check">
                        <i className="bi bi-check-circle-fill"></i>
                      </span>
                    )}
                  </button>
                ))}
              </div>
            </div>

            {/* Right: Dynamic Diagnostic Recommendation Card */}
            <div className="col-lg-6">
              <div className="triage-result-card p-4">
                <div className="d-flex justify-content-between align-items-start mb-3">
                  <div>
                    <span className="text-muted small text-uppercase fw-bold tracking-wider">
                      RECOMMENDED CLINICAL CENTER
                    </span>
                    <h3 className="text-white fw-bold mt-1 mb-0 d-flex align-items-center gap-2">
                      <span className="fs-2">{activeSymptom.icon}</span>
                      {activeSymptom.dept}
                    </h3>
                  </div>
                  <span className={`urgency-badge ${activeSymptom.urgencyClass}`}>
                    <span className="pulse-dot"></span>
                    {activeSymptom.urgency}
                  </span>
                </div>

                <div className="doctor-match-box p-3 mb-3">
                  <div className="d-flex align-items-center gap-3">
                    <div className="match-avatar">
                      <i className="bi bi-person-check-fill fs-4 text-cyan"></i>
                    </div>
                    <div>
                      <div className="text-white fw-bold">{activeSymptom.doctor}</div>
                      <div className="text-info small">
                        <i className="bi bi-clock-history me-1"></i>
                        Avg Response: {activeSymptom.estTime}
                      </div>
                    </div>
                  </div>
                </div>

                <p className="advice-text text-light opacity-90 small mb-4">
                  <i className="bi bi-info-circle-fill text-info me-2"></i>
                  {activeSymptom.advice}
                </p>

                <div className="d-flex flex-wrap gap-2">
                  <Link to="/login" className="btn btn-primary flex-grow-1 custom-glow-btn">
                    <i className="bi bi-calendar-check me-2"></i>
                    Book Appointment Now
                  </Link>
                  <a href="tel:8308308308" className="btn btn-outline-danger">
                    <i className="bi bi-telephone-fill me-1"></i>
                    Emergency Call
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default SymptomNavigator;

