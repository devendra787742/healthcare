import React, { useState } from "react";
import { Link } from "react-router-dom";
import Marquee from "react-fast-marquee";
import TiltCard3D from "./TiltCard3D";
import "./DoctorReviews.css";

const doctorsData = [
  {
    id: 1,
    name: "Dr. Katlynn",
    title: "Senior Cardiologist",
    dept: "Cardiology",
    experience: "14+ Years Exp",
    rating: "4.9",
    reviewsCount: 380,
    quote: "“At 39, I never dreamed I would have a heart operation to save my life. Thank you from the bottom of my heart for repairing mine.”",
    patient: "Andres M., Heart Valve Patient",
    image: require("../../Images/doctors-2.jpg"),
    badge: "Top Cardiac Specialist",
    isOnline: true,
  },
  {
    id: 2,
    name: "Dr. Michale",
    title: "Lead Neurosurgeon",
    dept: "Neurology",
    experience: "18+ Years Exp",
    rating: "5.0",
    reviewsCount: 420,
    quote: "“Thank you for all your dedication and skill over the past eight years. You gave me hope for a brighter, pain-free future.”",
    patient: "Anthony K., Spine Surgery",
    image: require("../../Images/doctors-3.jpg"),
    badge: "Fellow of Neuro-Oncology",
    isOnline: true,
  },
  {
    id: 3,
    name: "Dr. Kristina",
    title: "Chief of Internal Medicine",
    dept: "General Medicine",
    experience: "12+ Years Exp",
    rating: "4.9",
    reviewsCount: 295,
    quote: "“Thanking you for your warm bedside manner. You made my complex treatment pleasant, and I am so grateful for your dedication.”",
    patient: "Christopher P., Chronic Care",
    image: require("../../Images/doctors-4.jpg"),
    badge: "Master of Clinical Medicine",
    isOnline: false,
  },
  {
    id: 4,
    name: "Dr. Jadon",
    title: "Senior Pediatric Surgeon",
    dept: "Pediatrics",
    experience: "16+ Years Exp",
    rating: "4.8",
    reviewsCount: 310,
    quote: "“You are the most caring doctors our family has ever known. You are true superheroes in our household. Thank you so much!”",
    patient: "Ned & Sarah W., Parents",
    image: require("../../Images/doctors-5.jfif"),
    badge: "Excellence in Child Care",
    isOnline: true,
  },
  {
    id: 5,
    name: "Dr. Gwen",
    title: "Joint Replacement Specialist",
    dept: "Orthopedics",
    experience: "15+ Years Exp",
    rating: "4.9",
    reviewsCount: 260,
    quote: "“After severe arthritis, Dr. Gwen performed minimally invasive knee replacement. I was back walking within 48 hours!”",
    patient: "Elena R., Mobility Recovery",
    image: require("../../Images/doctors-1.jpg"),
    badge: "Robotic Surgery Lead",
    isOnline: true,
  },
];

const DoctorsReview = () => {
  const [selectedDept, setSelectedDept] = useState("all");
  const [viewMode, setViewMode] = useState("marquee"); // 'marquee' | 'grid'

  const filteredDoctors =
    selectedDept === "all"
      ? doctorsData
      : doctorsData.filter((doc) => doc.dept.toLowerCase() === selectedDept.toLowerCase());

  const renderCard = (doctor) => (
    <div key={doctor.id} className="doctor-card-container px-3 py-2">
      <TiltCard3D className="doctor-3d-card h-100" maxTilt={12}>
        <div className="doc-card-inner p-4 d-flex flex-column h-100">
          {/* Top header: Image + Online status + Badge */}
          <div className="d-flex align-items-center gap-3 mb-3">
            <div className="doc-img-wrapper position-relative">
              <img src={doctor.image} alt={doctor.name} className="doc-avatar-img" />
              {doctor.isOnline && (
                <span className="online-indicator" title="Available for Instant Telehealth"></span>
              )}
            </div>
            <div>
              <h4 className="doc-name text-white fw-bold mb-0">{doctor.name}</h4>
              <div className="doc-title text-info small fw-semibold">{doctor.title}</div>
              <span className="doc-dept-badge mt-1 d-inline-block">{doctor.dept}</span>
            </div>
          </div>

          {/* Rating & Experience */}
          <div className="d-flex justify-content-between align-items-center py-2 px-3 doc-metrics-bar mb-3">
            <div className="d-flex align-items-center text-warning small">
              <i className="bi bi-star-fill me-1"></i>
              <strong className="text-white">{doctor.rating}</strong>
              <span className="text-muted ms-1">({doctor.reviewsCount})</span>
            </div>
            <div className="text-light opacity-75 small">
              <i className="bi bi-clock-history me-1 text-cyan"></i>
              {doctor.experience}
            </div>
          </div>

          {/* Quote & Patient info */}
          <div className="doc-quote-box mb-3 flex-grow-1">
            <p className="doc-quote-text text-light small mb-2">{doctor.quote}</p>
            <div className="patient-author small text-info">
              <i className="bi bi-chat-quote-fill me-1"></i>
              {doctor.patient}
            </div>
          </div>

          {/* Action button */}
          <div className="pt-2 border-top border-secondary border-opacity-25 mt-auto">
            <Link to="/login" className="btn btn-sm w-100 doc-consult-btn">
              <i className="bi bi-calendar2-check me-2"></i>
              Book with {doctor.name}
            </Link>
          </div>
        </div>
      </TiltCard3D>
    </div>
  );

  return (
    <section className="doctors-review-section py-5" id="reviews">
      <div className="container">
        {/* Header */}
        <div className="d-flex flex-column flex-md-row justify-content-between align-items-md-end mb-4">
          <div>
            <div className="section-pill mb-2">
              <span className="pill-dot"></span>
              TRUSTED SPECIALISTS & REAL TESTIMONIALS
            </div>
            <h2 className="section-title text-white">
              Meet Our Renowned <span className="gradient-text-cyan">Medical Specialists</span>
            </h2>
            <p className="section-subtitle mb-0">
              Verified clinical experts with 3D consultation capabilities and hundreds of patient success stories.
            </p>
          </div>

          {/* Controls: Department filter & View switcher */}
          <div className="d-flex flex-wrap align-items-center gap-2 mt-3 mt-md-0">
            <div className="btn-group view-toggle-group">
              <button
                className={`btn btn-sm ${viewMode === "marquee" ? "btn-info" : "btn-outline-secondary"}`}
                onClick={() => setViewMode("marquee")}
                title="Continuous 3D Carousel Flow"
              >
                <i className="bi bi-play-circle me-1"></i> 3D Flow
              </button>
              <button
                className={`btn btn-sm ${viewMode === "grid" ? "btn-info" : "btn-outline-secondary"}`}
                onClick={() => setViewMode("grid")}
                title="Full Grid Matrix"
              >
                <i className="bi bi-grid-fill me-1"></i> Grid
              </button>
            </div>
          </div>
        </div>

        {/* Filter Pills */}
        <div className="d-flex flex-wrap gap-2 mb-4">
          {[
            { id: "all", label: "All Specialists" },
            { id: "cardiology", label: "Cardiology" },
            { id: "neurology", label: "Neurology" },
            { id: "pediatrics", label: "Pediatrics" },
            { id: "orthopedics", label: "Orthopedics" },
            { id: "general medicine", label: "Internal Medicine" },
          ].map((item) => (
            <button
              key={item.id}
              className={`doc-filter-pill ${selectedDept === item.id ? "active" : ""}`}
              onClick={() => setSelectedDept(item.id)}
            >
              {item.label}
            </button>
          ))}
        </div>

        {/* Main Content: Marquee or Grid */}
        {viewMode === "marquee" ? (
          <div className="marquee-wrapper py-2">
            <Marquee speed={35} pauseOnHover={true} gradient={false}>
              {filteredDoctors.map(renderCard)}
            </Marquee>
          </div>
        ) : (
          <div className="row g-4">
            {filteredDoctors.map((doc) => (
              <div className="col-lg-4 col-md-6" key={doc.id}>
                {renderCard(doc)}
              </div>
            ))}
          </div>
        )}
      </div>
    </section>
  );
};

export default DoctorsReview;
