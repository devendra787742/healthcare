import React from "react";
import TiltCard3D from "./TiltCard3D";
import "./ImpactStats.css";

const statsData = [
  {
    icon: "bi-people-fill",
    number: "500,000+",
    label: "Patients Healed",
    subtext: "Across comprehensive inpatient & digital consultations",
    color: "#06b6d4", // cyan
  },
  {
    icon: "bi-award-fill",
    number: "150+",
    label: "Verified Doctors",
    subtext: "Board-certified surgeons, physicians & specialists",
    color: "#10b981", // emerald
  },
  {
    icon: "bi-heart-pulse-fill",
    number: "99.8%",
    label: "Patient Satisfaction",
    subtext: "Rated highest in care outcomes & post-op recovery",
    color: "#f43f5e", // rose
  },
  {
    icon: "bi-lightning-charge-fill",
    number: "24 / 7",
    label: "Instant Care Access",
    subtext: "Zero-wait emergency dispatch and digital triage",
    color: "#eab308", // amber
  },
];

const ImpactStats = () => {
  return (
    <section className="impact-stats-section py-5">
      <div className="container">
        <div className="row g-4">
          {statsData.map((item, index) => (
            <div className="col-lg-3 col-sm-6" key={index}>
              <TiltCard3D className="stat-card-3d h-100" maxTilt={15}>
                <div className="stat-card-inner p-4 text-center">
                  <div
                    className="stat-icon-wrapper mb-3 mx-auto"
                    style={{
                      backgroundColor: `${item.color}18`,
                      color: item.color,
                      boxShadow: `0 0 25px ${item.color}28`,
                    }}
                  >
                    <i className={`bi ${item.icon} fs-3`}></i>
                  </div>
                  <div
                    className="stat-number fw-bolder mb-1"
                    style={{ color: item.color }}
                  >
                    {item.number}
                  </div>
                  <div className="stat-label text-white fw-bold fs-5 mb-2">
                    {item.label}
                  </div>
                  <div className="stat-subtext text-muted small">
                    {item.subtext}
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

export default ImpactStats;

