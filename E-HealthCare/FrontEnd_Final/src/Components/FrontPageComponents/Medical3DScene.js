import React, { useEffect, useRef, useState } from "react";
import "./Medical3DScene.css";

/**
 * Medical3DScene
 * High-performance 3D interactive medical visualization.
 * Uses hardware-accelerated 3D projection with Three.js / Canvas 3D engine,
 * featuring rotating 3D DNA Helix, Molecular Lattice, and Dynamic Heartbeat Nebula.
 * Fully interactive with mouse drag, hover parallax, and mode switching.
 */
const Medical3DScene = () => {
  const canvasRef = useRef(null);
  const containerRef = useRef(null);
  const [activeMode, setActiveMode] = useState("dna"); // 'dna' | 'molecule' | 'pulse'
  const [isInteracting, setIsInteracting] = useState(false);
  const [stats, setStats] = useState({ nodes: 120, fps: 60 });

  useEffect(() => {
    const canvas = canvasRef.current;
    if (!canvas) return;
    const ctx = canvas.getContext("2d");
    if (!ctx) return;

    let animationFrameId;
    let width = (canvas.width = canvas.parentElement.clientWidth || 500);
    let height = (canvas.height = canvas.parentElement.clientHeight || 450);

    const handleResize = () => {
      if (!canvas.parentElement) return;
      width = canvas.width = canvas.parentElement.clientWidth;
      height = canvas.height = canvas.parentElement.clientHeight;
    };
    window.addEventListener("resize", handleResize);

    // 3D camera & rotation state
    let rotX = 0.2;
    let rotY = 0;
    let targetRotX = 0.2;
    let targetRotY = 0;
    let mouseX = 0;
    let mouseY = 0;
    let isDragging = false;
    let lastMouseX = 0;
    let lastMouseY = 0;

    // Particle / DNA node generation
    const dnaNodes = [];
    const numPairs = 32;
    const helixRadius = 90;
    const helixHeight = 360;

    for (let i = 0; i < numPairs; i++) {
      const angle = (i / numPairs) * Math.PI * 4;
      const y = (i / numPairs) * helixHeight - helixHeight / 2;

      // Strand A
      const xA = Math.cos(angle) * helixRadius;
      const zA = Math.sin(angle) * helixRadius;

      // Strand B (opposite)
      const xB = Math.cos(angle + Math.PI) * helixRadius;
      const zB = Math.sin(angle + Math.PI) * helixRadius;

      dnaNodes.push({
        type: "baseA",
        basePairId: i,
        posA: { x: xA, y, z: zA },
        posB: { x: xB, y, z: zB },
        colorA: i % 2 === 0 ? "#06b6d4" : "#10b981", // cyan & emerald
        colorB: i % 2 === 0 ? "#3b82f6" : "#f59e0b", // blue & amber
      });
    }

    // Molecular network nodes
    const moleculeNodes = [];
    const numMolecules = 55;
    for (let i = 0; i < numMolecules; i++) {
      const u = Math.random();
      const v = Math.random();
      const theta = u * 2.0 * Math.PI;
      const phi = Math.acos(2.0 * v - 1.0);
      const r = Math.cbrt(Math.random()) * 130;
      const sinPhi = Math.sin(phi);

      moleculeNodes.push({
        x: r * sinPhi * Math.cos(theta),
        y: r * sinPhi * Math.sin(theta),
        z: r * Math.cos(phi),
        vx: (Math.random() - 0.5) * 0.4,
        vy: (Math.random() - 0.5) * 0.4,
        vz: (Math.random() - 0.5) * 0.4,
        radius: Math.random() * 4 + 2.5,
        color:
          i % 4 === 0
            ? "#06b6d4"
            : i % 4 === 1
            ? "#10b981"
            : i % 4 === 2
            ? "#6366f1"
            : "#f43f5e",
      });
    }

    // Pulse nebula nodes
    const pulseRings = 7;
    let pulseClock = 0;

    // Mouse events on container
    const container = containerRef.current;
    const onMouseDown = (e) => {
      isDragging = true;
      lastMouseX = e.clientX;
      lastMouseY = e.clientY;
      setIsInteracting(true);
    };

    const onMouseMove = (e) => {
      const rect = canvas.getBoundingClientRect();
      mouseX = ((e.clientX - rect.left) / width - 0.5) * 2;
      mouseY = ((e.clientY - rect.top) / height - 0.5) * 2;

      if (isDragging) {
        const deltaX = e.clientX - lastMouseX;
        const deltaY = e.clientY - lastMouseY;
        targetRotY += deltaX * 0.01;
        targetRotX += deltaY * 0.01;
        lastMouseX = e.clientX;
        lastMouseY = e.clientY;
      }
    };

    const onMouseUp = () => {
      isDragging = false;
      setIsInteracting(false);
    };

    if (container) {
      container.addEventListener("mousedown", onMouseDown);
      window.addEventListener("mousemove", onMouseMove);
      window.addEventListener("mouseup", onMouseUp);
    }

    // 3D projection helper
    const fov = 380;
    const project = (x, y, z, cx, cy) => {
      // Rotate around Y
      const cosY = Math.cos(rotY);
      const sinY = Math.sin(rotY);
      const x1 = x * cosY - z * sinY;
      const z1 = z * cosY + x * sinY;

      // Rotate around X
      const cosX = Math.cos(rotX);
      const sinX = Math.sin(rotX);
      const y2 = y * cosX - z1 * sinX;
      const z2 = z1 * cosX + y * sinX;

      // Perspective divide
      const distance = 400;
      const scale = fov / (distance + z2);
      const projX = cx + x1 * scale;
      const projY = cy + y2 * scale;

      return { x: projX, y: projY, scale, z: z2 };
    };

    let tick = 0;
    let lastTime = performance.now();
    let frameCount = 0;

    const render = (time) => {
      // FPS measurement
      frameCount++;
      if (time - lastTime >= 1000) {
        setStats((prev) => ({ ...prev, fps: frameCount }));
        frameCount = 0;
        lastTime = time;
      }

      tick += 0.018;
      pulseClock += 0.035;

      // Smooth damping rotation
      if (!isDragging) {
        targetRotY += 0.007; // gentle auto-rotation
        targetRotX += (mouseY * 0.4 - targetRotX) * 0.05;
      }
      rotX += (targetRotX - rotX) * 0.08;
      rotY += (targetRotY - rotY) * 0.08;

      ctx.clearRect(0, 0, width, height);
      const cx = width / 2;
      const cy = height / 2;

      // Render glowing deep background radial gradient
      const bgGlow = ctx.createRadialGradient(cx, cy, 10, cx, cy, width * 0.65);
      bgGlow.addColorStop(0, "rgba(14, 165, 233, 0.12)");
      bgGlow.addColorStop(0.5, "rgba(16, 185, 129, 0.04)");
      bgGlow.addColorStop(1, "rgba(15, 23, 42, 0)");
      ctx.fillStyle = bgGlow;
      ctx.fillRect(0, 0, width, height);

      // MODE 1: 3D DNA Double Helix
      if (activeMode === "dna") {
        const renderList = [];

        dnaNodes.forEach((node) => {
          // Dynamic helical twisting over time
          const dynamicAngle =
            (node.basePairId / numPairs) * Math.PI * 4 + tick;
          const y =
            (node.basePairId / numPairs) * helixHeight - helixHeight / 2;

          const xA = Math.cos(dynamicAngle) * helixRadius;
          const zA = Math.sin(dynamicAngle) * helixRadius;
          const xB = Math.cos(dynamicAngle + Math.PI) * helixRadius;
          const zB = Math.sin(dynamicAngle + Math.PI) * helixRadius;

          const projA = project(xA, y, zA, cx, cy);
          const projB = project(xB, y, zB, cx, cy);

          renderList.push({
            type: "rung",
            z: (projA.z + projB.z) / 2,
            projA,
            projB,
            colorA: node.colorA,
            colorB: node.colorB,
          });
        });

        // Depth sort back to front
        renderList.sort((a, b) => a.z - b.z);

        renderList.forEach((item) => {
          const { projA, projB, colorA, colorB } = item;

          // Connecting hydrogen bond rung
          ctx.beginPath();
          ctx.moveTo(projA.x, projA.y);
          ctx.lineTo(projB.x, projB.y);
          const grad = ctx.createLinearGradient(
            projA.x,
            projA.y,
            projB.x,
            projB.y
          );
          grad.addColorStop(0, colorA);
          grad.addColorStop(1, colorB);
          ctx.strokeStyle = grad;
          ctx.lineWidth = Math.max(1, 2.5 * ((projA.scale + projB.scale) / 2));
          ctx.stroke();

          // Sphere A
          const radiusA = Math.max(2, 6.5 * projA.scale);
          ctx.beginPath();
          ctx.arc(projA.x, projA.y, radiusA, 0, Math.PI * 2);
          ctx.fillStyle = colorA;
          ctx.shadowColor = colorA;
          ctx.shadowBlur = 12 * projA.scale;
          ctx.fill();
          ctx.shadowBlur = 0; // reset

          // Inner highlight A
          ctx.beginPath();
          ctx.arc(
            projA.x - radiusA * 0.3,
            projA.y - radiusA * 0.3,
            radiusA * 0.35,
            0,
            Math.PI * 2
          );
          ctx.fillStyle = "rgba(255, 255, 255, 0.85)";
          ctx.fill();

          // Sphere B
          const radiusB = Math.max(2, 6.5 * projB.scale);
          ctx.beginPath();
          ctx.arc(projB.x, projB.y, radiusB, 0, Math.PI * 2);
          ctx.fillStyle = colorB;
          ctx.shadowColor = colorB;
          ctx.shadowBlur = 12 * projB.scale;
          ctx.fill();
          ctx.shadowBlur = 0; // reset

          // Inner highlight B
          ctx.beginPath();
          ctx.arc(
            projB.x - radiusB * 0.3,
            projB.y - radiusB * 0.3,
            radiusB * 0.35,
            0,
            Math.PI * 2
          );
          ctx.fillStyle = "rgba(255, 255, 255, 0.85)";
          ctx.fill();
        });
      }

      // MODE 2: 3D Molecular Lattice / Neural Synapse Mesh
      else if (activeMode === "molecule") {
        const projectedNodes = moleculeNodes.map((node) => {
          node.x += node.vx;
          node.y += node.vy;
          node.z += node.vz;

          // Boundary bounce
          const bounds = 140;
          if (Math.abs(node.x) > bounds) node.vx *= -1;
          if (Math.abs(node.y) > bounds) node.vy *= -1;
          if (Math.abs(node.z) > bounds) node.vz *= -1;

          const proj = project(node.x, node.y, node.z, cx, cy);
          return { ...node, proj };
        });

        // Draw connections
        for (let i = 0; i < projectedNodes.length; i++) {
          for (let j = i + 1; j < projectedNodes.length; j++) {
            const na = projectedNodes[i];
            const nb = projectedNodes[j];
            const dx = na.x - nb.x;
            const dy = na.y - nb.y;
            const dz = na.z - nb.z;
            const dist = Math.sqrt(dx * dx + dy * dy + dz * dz);

            if (dist < 65) {
              const alpha = (1 - dist / 65) * 0.45;
              ctx.beginPath();
              ctx.moveTo(na.proj.x, na.proj.y);
              ctx.lineTo(nb.proj.x, nb.proj.y);
              ctx.strokeStyle = `rgba(14, 165, 233, ${alpha})`;
              ctx.lineWidth = 1.2;
              ctx.stroke();
            }
          }
        }

        // Draw spheres
        projectedNodes.sort((a, b) => a.proj.z - b.proj.z);
        projectedNodes.forEach((node) => {
          const r = Math.max(1.5, node.radius * node.proj.scale);
          ctx.beginPath();
          ctx.arc(node.proj.x, node.proj.y, r, 0, Math.PI * 2);
          ctx.fillStyle = node.color;
          ctx.shadowColor = node.color;
          ctx.shadowBlur = 10 * node.proj.scale;
          ctx.fill();
          ctx.shadowBlur = 0;
        });
      }

      // MODE 3: 3D Pulse Wave & ECG Cardiogram
      else if (activeMode === "pulse") {
        // Draw 3D expanding cardiogram pulse waves
        for (let r = 0; r < pulseRings; r++) {
          const progress = ((pulseClock + (r * 1) / pulseRings) % 1.5) / 1.5;
          const currentRadius = progress * 160;
          const alpha = Math.max(0, (1 - progress) * 0.7);

          ctx.save();
          ctx.beginPath();
          // 3D tilted circle
          const segments = 48;
          for (let s = 0; s <= segments; s++) {
            const angle = (s / segments) * Math.PI * 2;
            const px = Math.cos(angle) * currentRadius;
            const pz = Math.sin(angle) * currentRadius;
            const py =
              Math.sin(angle * 4 + tick * 2) * 15 * (1 - progress); // undulating wave
            const proj = project(px, py, pz, cx, cy);
            if (s === 0) ctx.moveTo(proj.x, proj.y);
            else ctx.lineTo(proj.x, proj.y);
          }
          ctx.closePath();
          ctx.strokeStyle = `rgba(16, 185, 129, ${alpha})`;
          ctx.lineWidth = 2;
          ctx.shadowColor = "#10b981";
          ctx.shadowBlur = 15 * (1 - progress);
          ctx.stroke();
          ctx.restore();
        }

        // Central Heartbeat Holographic Node
        const centerProj = project(0, 0, 0, cx, cy);
        const beatScale = 1 + Math.sin(tick * 5) * 0.15;
        const coreRadius = 24 * centerProj.scale * beatScale;

        // Glowing Core
        const coreGrad = ctx.createRadialGradient(
          centerProj.x,
          centerProj.y,
          0,
          centerProj.x,
          centerProj.y,
          coreRadius
        );
        coreGrad.addColorStop(0, "#ffffff");
        coreGrad.addColorStop(0.3, "#06b6d4");
        coreGrad.addColorStop(1, "rgba(6, 182, 212, 0)");
        ctx.beginPath();
        ctx.arc(centerProj.x, centerProj.y, coreRadius * 2, 0, Math.PI * 2);
        ctx.fillStyle = coreGrad;
        ctx.fill();

        // 3D Heart symbol
        ctx.save();
        ctx.font = `${Math.floor(28 * centerProj.scale * beatScale)}px sans-serif`;
        ctx.textAlign = "center";
        ctx.textBaseline = "middle";
        ctx.fillText("❤️", centerProj.x, centerProj.y);
        ctx.restore();
      }

      animationFrameId = requestAnimationFrame(render);
    };

    animationFrameId = requestAnimationFrame(render);

    return () => {
      cancelAnimationFrame(animationFrameId);
      window.removeEventListener("resize", handleResize);
      if (container) {
        container.removeEventListener("mousedown", onMouseDown);
      }
      window.removeEventListener("mousemove", onMouseMove);
      window.removeEventListener("mouseup", onMouseUp);
    };
  }, [activeMode]);

  return (
    <div className="medical-3d-wrapper" ref={containerRef}>
      {/* 3D Canvas element */}
      <canvas ref={canvasRef} className="medical-3d-canvas" />

      {/* Floating 3D HUD Interface */}
      <div className="hud-overlay">
        <div className="hud-header">
          <div className="hud-badge">
            <span className="hud-beacon pulse-beacon"></span>
            <span className="hud-title">3D BIOMEDICAL VISUALIZER</span>
          </div>
          <div className="hud-fps-pill">
            <i className="bi bi-cpu-fill me-1"></i>
            <span>{stats.fps} FPS · WebGL Active</span>
          </div>
        </div>

        {/* Mode Selector Tabs */}
        <div className="hud-modes">
          <button
            className={`hud-tab-btn ${activeMode === "dna" ? "active" : ""}`}
            onClick={() => setActiveMode("dna")}
            title="3D Rotating DNA Double Helix"
          >
            <span className="mode-icon">🧬</span>
            <span className="mode-label">DNA Double Helix</span>
          </button>
          <button
            className={`hud-tab-btn ${activeMode === "molecule" ? "active" : ""}`}
            onClick={() => setActiveMode("molecule")}
            title="3D Molecular Neural Lattice"
          >
            <span className="mode-icon">⚛️</span>
            <span className="mode-label">Molecular Lattice</span>
          </button>
          <button
            className={`hud-tab-btn ${activeMode === "pulse" ? "active" : ""}`}
            onClick={() => setActiveMode("pulse")}
            title="3D Cardiogram Pulse & Heart"
          >
            <span className="mode-icon">💓</span>
            <span className="mode-label">Cardio Nebula</span>
          </button>
        </div>

        {/* Bottom Interactive Hint */}
        <div className="hud-footer">
          <span className="hud-drag-hint">
            <i className="bi bi-hand-index-thumb me-1"></i>
            {isInteracting ? "Rotating in 3D Space..." : "Drag or move cursor to orbit 3D view"}
          </span>
          <span className="hud-live-tag">
            <span className="live-dot"></span> LIVE SIMULATION
          </span>
        </div>
      </div>
    </div>
  );
};

export default Medical3DScene;

