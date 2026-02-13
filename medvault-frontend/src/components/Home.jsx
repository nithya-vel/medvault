import React from "react";
import { useNavigate } from "react-router-dom";
import "./Home.css";

function Home() {
  const navigate = useNavigate();

  return (
    <div className="home">

      {/* HERO SECTION */}
      <section className="hero">
        <div className="hero-content">
          <h1>Welcome to MedVault</h1>
          <p>
            MedVault is a secure medical record management system designed
            for patients and doctors. Store, access, and manage health data
            with confidence.
          </p>

          <button
            className="cta-button"
            onClick={() => navigate("/login")}
          >
            Get Started
          </button>
        </div>
      </section>

      {/* WHY SECTION */}
      <section className="features">
        <h2>Why Choose MedVault?</h2>

        <div className="feature-grid">
          <div className="feature-card">
            <h3>🔒 Secure Storage</h3>
            <p>Encrypted and protected medical records.</p>
          </div>

          <div className="feature-card">
            <h3>⚡ Fast Access</h3>
            <p>Instant access to health data anytime.</p>
          </div>

          <div className="feature-card">
            <h3>👨‍⚕️ Doctor-Patient Connect</h3>
            <p>Seamless communication and record sharing.</p>
          </div>

          <div className="feature-card">
            <h3>📊 Role-Based Dashboard</h3>
            <p>Customized views for patients and doctors.</p>
          </div>
        </div>
      </section>

      {/* CONTACT SECTION */}
      <section className="contact">
        <h2>Contact Us</h2>
        <p>Email: support@medvault.com</p>
        <p>Phone: +91 9876543210</p>
      </section>

    </div>
  );
}

export default Home;