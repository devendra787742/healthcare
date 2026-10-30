import React, { useState } from "react";
import { Link } from "react-router-dom";
import TiltCard3D from "./TiltCard3D";
import "./DepartmentSection.css";

const departmentsData = [
  {
    id: "cardio",
    title: "Cardiology & Heart Care",
    icon: "bi-heart-pulse-fill",
    color: "#f43f5e", // rose
    bgGradient: "linear-gradient(135deg, rgba(244, 63, 94, 0.12), rgba(244, 63, 94, 0.02))",
    borderColor: "rgba(244, 63, 94, 0.35)",
    doctorsCount: 14,
    description: "Advanced cardiovascular diagnostics, 3D echocardiography, coronary interventions, and rhythm care.",
    features: ["Coronary Angiography", "3D Heart Mapping", "Pacemaker Clinic"],
    highlight: "99.4% Survival Rate",
  },
  {
    id: "neuro",
    title: "Neurology & Brain Sciences",
    icon: "bi-diagram-3-fill",
    color: "#8b5cf6", // purple
    bgGradient: "linear-gradient(135deg, rgba(139, 92, 246, 0.12), rgba(139, 92, 246, 0.02))",
    borderColor: "rgba(139, 92, 246, 0.35)",
    doctorsCount: 11,
    description: "Comprehensive neurology, brain aneurysm surgery, stroke emergency management, and epilepsy care.",
    features: ["Neuro-Navigation", "Stroke Care Unit", "EEG & Sleep Lab"],
    highlight: "24/7 Stroke Protocol",
  },
  {
    id: "ortho",
    title: "Orthopedics & Joint Care",
    icon: "bi-person-arms-up",
    color: "#06b6d4", // cyan
    bgGradient: "linear-gradient(135deg, rgba(6, 182, 212, 0.12), rgba(6, 182, 212, 0.02))",
    borderColor: "rgba(6, 182, 212, 0.35)",
    doctorsCount: 16,
    description: "Robotic joint replacement, spine stabilization, sports injury recovery, and arthroscopic reconstructions.",
    features: ["Robotic Knee & Hip", "Sports Medicine", "Spine Center"],
    highlight: "Rapid Mobility Program",
  },
  {
    id: "pediatrics",
    title: "Pediatrics & Child Wellness",
    icon: "bi-emoji-smile-fill",
    color: "#f59e0b", // amber
    bgGradient: "linear-gradient(135deg, rgba(245, 158, 11, 0.12), rgba(245, 158, 11, 0.02))",
    borderColor: "rgba(245, 158, 11, 0.35)",
    doctorsCount: 12,
    description: "Gentle newborn intensive care (NICU), pediatric cardiology, vaccinations, and growth development tracking.",
    features: ["Level III NICU", "Child Immunology", "Growth Tracking"],
    highlight: "Child-Friendly Ward",
  },
  {
    id: "oncology",
    title: "Oncology & Precision Diagnostics",
    icon: "bi-shield-shaded",
    color: "#10b981", // emerald
    bgGradient: "linear-gradient(135deg, rgba(16, 185, 129, 0.12), rgba(16, 185, 129, 0.02))",
    borderColor: "rgba(16, 185, 129, 0.35)",
    doctorsCount: 9,
    description: "Targeted immunotherapy, precision PET-CT scans, robotic tumor resection, and compassionate oncology counseling.",
    features: ["Precision Chemotherapy", "Genomic Tumor Panel", "Radiation Therapy"],
    highlight: "Genomic-Guided Care",
  },
  {
    id: "emergency",
    title: "Emergency & Critical Trauma",
    icon: "bi-hospital-fill",
    color: "#ef4444", // red
    bgGradient: "linear-gradient(135deg, rgba(239, 68, 68, 0.12), rgba(239, 68, 68, 0.02))",
    borderColor: "rgba(239, 68, 68, 0.35)",
    doctorsCount: 22,
    description: "Equipped for acute resuscitations, trauma triage, multi-organ ICU stabilization, and emergency airlifts.",
    features: ["Golden Hour Triage", "Smart ICU Beds", "Mobile Defibrillators"],
    highlight: "< 5 Min Triage Time",
  },
];

const DepartmentSection = () => {
  const [selectedDept, setSelectedDept] = useState(null);

  return (
    <section className="departments-section py-5" id="departments">
      <div className="container">
        <div className="section-header text-center mb-5">
          <div className="section-pill mb-2">
            <span className="pill-dot"></span>
            EXCELLENCE IN SPECIALIZED MEDICINE
          </div>
          <h2 className="section-title">
            Our Centers of <span className="gradient-text-cyan">Clinical Excellence</span>
          </h2>
          <p className="section-subtitle">
            Hover over any department to inspect clinical capabilities in 3D perspective, or book a direct consultation.
          </p>
        </div>

        <div className="row g-4">
          {departmentsData.map((dept) => (
            <div className="col-lg-4 col-md-6" key={dept.id}>
              <TiltCard3D
                className="dept-3d-card h-100"
                style={{
                  background: dept.bgGradient,
                  borderColor: dept.borderColor,
                }}
              >
                <div className="dept-card-inner p-4 d-flex flex-column h-100">
                  <div className="d-flex justify-content-between align-items-center mb-3">
                    <div
                      className="dept-icon-box"
                      style={{
                        backgroundColor: `${dept.color}1f`,
                        color: dept.color,
                        boxShadow: `0 0 20px ${dept.color}33`,
                      }}
                    >
                      <i className={`bi ${dept.icon} fs-3`}></i>
                    </div>
                    <span
                      className="dept-badge"
                      style={{
                        borderColor: dept.borderColor,
                        color: dept.color,
                        backgroundColor: `${dept.color}12`,
                      }}
                    >
                      {dept.highlight}
                    </span>
                  </div>

                  <h3 className="dept-card-title text-white fs-4 fw-bold mb-2">
                    {dept.title}
                  </h3>

                  <p className="dept-card-desc text-muted mb-3 flex-grow-1">
                    {dept.description}
                  </p>

                  <div className="dept-features-list mb-3">
                    {dept.features.map((feat, i) => (
                      <span key={i} className="dept-feature-pill">
                        <i className="bi bi-check2-circle me-1" style={{ color: dept.color }}></i>
                        {feat}
                      </span>
                    ))}
                  </div>

                  <div className="dept-card-footer pt-3 border-top border-secondary border-opacity-25 d-flex justify-content-between align-items-center">
                    <span className="text-secondary small">
                      <i className="bi bi-person-badge me-1"></i>
                      <strong className="text-white">{dept.doctorsCount}</strong> Specialists
                    </span>
                    <Link
                      to="/login"
                      className="btn btn-sm dept-action-btn"
                      style={{
                        borderColor: dept.color,
                        color: dept.color,
                      }}
                      onMouseEnter={(e) => {
                        e.currentTarget.style.backgroundColor = dept.color;
                        e.currentTarget.style.color = "#ffffff";
                      }}
                      onMouseLeave={(e) => {
                        e.currentTarget.style.backgroundColor = "transparent";
                        e.currentTarget.style.color = dept.color;
                      }}
                    >
                      Consult <i className="bi bi-arrow-right ms-1"></i>
                    </Link>
                  </div>
                </div>
              </TiltCard3D>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};

export default DepartmentSection;

