import React, { useState } from "react";
import Header from "./Header";
import Footer from "./Footer";
import TiltCard3D from "./TiltCard3D";
import "./About.css";

const About = () => {
  const [openFaq, setOpenFaq] = useState(0);

  const faqs = [
    {
      q: "How does the E-HealthCare 3D consultation work?",
      a: "Our portal connects patients with certified specialists via secure encrypted video calls. Doctors can utilize our interactive 3D anatomical viewer to explain diagnoses, surgical approaches, and recovery plans in full spatial clarity.",
    },
    {
      q: "How do I access my prescription and medical history?",
      a: "All treatment sessions, lab test orders, prescriptions, and doctor feedbacks are automatically saved in your encrypted Digital Health Vault under your Patient Portal. You can download PDF records at any time.",
    },
    {
      q: "Are all doctors on the platform certified?",
      a: "Yes. Every doctor undergoes rigorous credential verification, license audits with medical councils, and department head approval before they can consult on our portal.",
    },
    {
      q: "What payment methods are supported for doctor fees?",
      a: "We support instant online checkout via Razorpay, including credit/debit cards, UPI, net banking, and digital wallets, with immediate receipt generation.",
    },
  ];

  return (
    <div className="about-page-wrapper">
      <Header />

      {/* Hero Section */}
      <section className="about-hero-section py-5">
        <div className="container py-4">
          <div className="row align-items-center g-5">
            <div className="col-lg-7">
              <div className="section-pill mb-3">
                <span className="pill-dot"></span>
                PIONEERING CLINICAL INNOVATION
              </div>
              <h1 className="about-hero-title fw-bolder text-white mb-3">
                Revolutionizing Healthcare with <br />
                <span className="gradient-text-cyan">Compassion & 3D Technology</span>
              </h1>
              <p className="text-light opacity-90 fs-5 mb-4">
                Founded with a singular mission: to eliminate clinical barriers, empower patients
                with transparent health insights, and provide instant access to top medical specialists worldwide.
              </p>
              <div className="d-flex flex-wrap gap-4">
                <div>
                  <div className="fs-2 fw-bold text-cyan">500,000+</div>
                  <div className="text-muted small">Treated Patients</div>
                </div>
                <div className="vr bg-secondary opacity-50"></div>
                <div>
                  <div className="fs-2 fw-bold text-success">150+</div>
                  <div className="text-muted small">Specialist Doctors</div>
                </div>
                <div className="vr bg-secondary opacity-50"></div>
                <div>
                  <div className="fs-2 fw-bold text-warning">99.8%</div>
                  <div className="text-muted small">Recovery Rate</div>
                </div>
              </div>
            </div>

            <div className="col-lg-5">
              <TiltCard3D className="about-img-card" maxTilt={15}>
                <div className="p-3">
                  <img
                    src={require("../../Images/doc1.jpg")}
                    alt="Clinical Excellence"
                    className="img-fluid rounded-4 shadow-lg w-100"
                  />
                  <div className="about-floating-stat p-3 rounded-3 mt-3">
                    <div className="d-flex align-items-center gap-3">
                      <div className="stat-circle">
                        <i className="bi bi-shield-fill-check text-success fs-4"></i>
                      </div>
                      <div>
                        <div className="text-white fw-bold">Certified Center of Excellence</div>
                        <div className="text-muted small">Accredited by National Quality Board</div>
                      </div>
                    </div>
                  </div>
                </div>
              </TiltCard3D>
            </div>
          </div>
        </div>
      </section>

      {/* Core Values 3D Cards */}
      <section className="about-values-section py-5">
        <div className="container">
          <div className="text-center mb-5">
            <div className="section-pill mb-2">
              <span className="pill-dot"></span>
              OUR GUIDING PRINCIPLES
            </div>
            <h2 className="section-title text-white">
              The Pillars Behind Every <span className="gradient-text-cyan">Life We Touch</span>
            </h2>
          </div>

          <div className="row g-4">
            {[
              {
                icon: "bi-heart-fill",
                color: "#f43f5e",
                title: "Patient-First Care",
                desc: "Every clinical decision is anchored in empathy, comfort, and personalized care pathways designed for your family.",
              },
              {
                icon: "bi-cpu-fill",
                color: "#06b6d4",
                title: "3D Digital Innovation",
                desc: "Pioneering interactive 3D anatomy models and telehealth tele-diagnostics for higher accuracy and clarity.",
              },
              {
                icon: "bi-shield-check",
                color: "#10b981",
                title: "Clinical Rigor & Integrity",
                desc: "Adhering to international evidence-based medicine, strict sterilization protocols, and verified specialist credentials.",
              },
              {
                icon: "bi-people-fill",
                color: "#8b5cf6",
                title: "Universal Accessibility",
                desc: "Breaking geographical boundaries through 24/7 digital triage, mobile consultations, and rapid emergency dispatch.",
              },
            ].map((val, idx) => (
              <div className="col-lg-3 col-sm-6" key={idx}>
                <TiltCard3D className="value-3d-card h-100" maxTilt={15}>
                  <div className="p-4 d-flex flex-column h-100">
                    <div
                      className="value-icon-box mb-3"
                      style={{
                        backgroundColor: `${val.color}15`,
                        color: val.color,
                        boxShadow: `0 0 20px ${val.color}25`,
                      }}
                    >
                      <i className={`bi ${val.icon} fs-4`}></i>
                    </div>
                    <h4 className="text-white fw-bold fs-5 mb-2">{val.title}</h4>
                    <p className="text-muted small mb-0">{val.desc}</p>
                  </div>
                </TiltCard3D>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* Interactive FAQ Section */}
      <section className="about-faq-section py-5">
        <div className="container">
          <div className="text-center mb-5">
            <div className="section-pill mb-2">
              <span className="pill-dot"></span>
              PATIENT KNOWLEDGE BASE
            </div>
            <h2 className="section-title text-white">
              Frequently Asked <span className="gradient-text-cyan">Questions</span>
            </h2>
          </div>

          <div className="row justify-content-center">
            <div className="col-lg-8">
              <div className="faq-accordion-wrapper d-flex flex-column gap-3">
                {faqs.map((faq, index) => (
                  <div
                    key={index}
                    className={`faq-card p-4 ${openFaq === index ? "active" : ""}`}
                    onClick={() => setOpenFaq(openFaq === index ? -1 : index)}
                  >
                    <div className="d-flex justify-content-between align-items-center cursor-pointer">
                      <h5 className="faq-question text-white fw-bold mb-0">
                        {faq.q}
                      </h5>
                      <span className="faq-toggle-icon ms-3">
                        <i className={`bi ${openFaq === index ? "bi-dash-circle-fill text-info" : "bi-plus-circle text-muted"}`}></i>
                      </span>
                    </div>
                    {openFaq === index && (
                      <p className="faq-answer text-light opacity-80 mt-3 mb-0 pt-3 border-top border-secondary border-opacity-25 small">
                        {faq.a}
                      </p>
                    )}
                  </div>
                ))}
              </div>
            </div>
          </div>
        </div>
      </section>

      <Footer />
    </div>
  );
};

export default About;
