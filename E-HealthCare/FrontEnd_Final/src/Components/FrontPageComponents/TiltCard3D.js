import React, { useRef, useState } from "react";

/**
 * TiltCard3D
 * Reusable wrapper that adds an interactive 3D perspective tilt and dynamic lighting glare.
 */
const TiltCard3D = ({ children, className = "", style = {}, maxTilt = 12 }) => {
  const cardRef = useRef(null);
  const [tiltStyle, setTiltStyle] = useState({
    transform: "perspective(1000px) rotateX(0deg) rotateY(0deg) scale3d(1, 1, 1)",
    glareX: 50,
    glareY: 50,
    glareOpacity: 0,
    transition: "transform 0.4s cubic-bezier(0.03, 0.98, 0.52, 0.99), box-shadow 0.4s ease",
  });

  const handleMouseMove = (e) => {
    if (!cardRef.current) return;
    const rect = cardRef.current.getBoundingClientRect();
    const x = e.clientX - rect.left;
    const y = e.clientY - rect.top;

    const centerX = rect.width / 2;
    const centerY = rect.height / 2;

    const rotateX = ((y - centerY) / centerY) * -maxTilt;
    const rotateY = ((x - centerX) / centerX) * maxTilt;

    const glareX = (x / rect.width) * 100;
    const glareY = (y / rect.height) * 100;

    setTiltStyle({
      transform: `perspective(1000px) rotateX(${rotateX.toFixed(2)}deg) rotateY(${rotateY.toFixed(2)}deg) scale3d(1.025, 1.025, 1.025)`,
      glareX,
      glareY,
      glareOpacity: 0.18,
      transition: "none", // instant tracking during mousemove
    });
  };

  const handleMouseLeave = () => {
    setTiltStyle({
      transform: "perspective(1000px) rotateX(0deg) rotateY(0deg) scale3d(1, 1, 1)",
      glareX: 50,
      glareY: 50,
      glareOpacity: 0,
      transition: "transform 0.5s cubic-bezier(0.03, 0.98, 0.52, 0.99), box-shadow 0.5s ease",
    });
  };

  return (
    <div
      ref={cardRef}
      className={`tilt-card-container ${className}`}
      onMouseMove={handleMouseMove}
      onMouseLeave={handleMouseLeave}
      style={{
        ...style,
        transform: tiltStyle.transform,
        transition: tiltStyle.transition,
        transformStyle: "preserve-3d",
        position: "relative",
      }}
    >
      {/* 3D dynamic lighting glare */}
      <div
        className="tilt-glare"
        style={{
          position: "absolute",
          inset: 0,
          pointerEvents: "none",
          borderRadius: "inherit",
          background: `radial-gradient(circle at ${tiltStyle.glareX}% ${tiltStyle.glareY}%, rgba(255, 255, 255, ${tiltStyle.glareOpacity}), transparent 70%)`,
          transition: "opacity 0.3s ease",
          zIndex: 10,
        }}
      />
      {children}
    </div>
  );
};

export default TiltCard3D;

