import React from "react";
import "./dashboard.css";

function DoctorDashboard() {
  return (
    <div>

      <h2>Doctor Dashboard</h2>
      <p>Welcome Doctor 👨‍⚕️</p>

      {/* 🔹 Quick Stats Cards */}
      <div className="stats-container">
        <div className="stat-card">
          <h3>👥 Total Patients</h3>
          <p>124</p>
        </div>

        <div className="stat-card">
          <h3>📅 Today’s Appointments</h3>
          <p>6</p>
        </div>

        <div className="stat-card">
          <h3>📝 Pending Approvals</h3>
          <p>3</p>
        </div>

        <div className="stat-card">
          <h3>📂 Records Uploaded</h3>
          <p>45</p>
        </div>
      </div>

      {/* 🔹 Upcoming Appointments */}
      <div className="dashboard-section">
        <h3>Upcoming Appointments</h3>
        <ul>
          <li>10:00 AM - Ravi Kumar</li>
          <li>11:30 AM - Sneha Reddy</li>
          <li>2:00 PM - Arjun Mehta</li>
        </ul>
      </div>

      {/* 🔹 Recent Activity */}
      <div className="dashboard-section">
        <h3>Recent Activity</h3>
        <ul>
          <li>✔ Approved medical record for Priya Sharma</li>
          <li>✔ Uploaded lab report for Rajeev Menon</li>
          <li>✔ Updated prescription for Swathi Rao</li>
        </ul>
      </div>

    </div>
  );
}

export default DoctorDashboard;