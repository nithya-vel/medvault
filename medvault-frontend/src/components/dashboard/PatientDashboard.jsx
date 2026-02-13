import React from "react";

function PatientDashboard() {
  return (
    <div className="content-area">
      <h2>Patient Dashboard</h2>
      <p>Welcome Patient 👤</p>

      {/* ===== Stats Cards ===== */}
      <div className="stats-container">
        <div className="stat-card">
          <h3>Upcoming Appointments</h3>
          <p>3</p>
        </div>

        <div className="stat-card">
          <h3>Medical Records</h3>
          <p>12</p>
        </div>

        <div className="stat-card">
          <h3>Pending Approvals</h3>
          <p>2</p>
        </div>

        <div className="stat-card">
          <h3>Feedback Given</h3>
          <p>5</p>
        </div>
      </div>

      {/* ===== Recent Activity ===== */}
      <div className="dashboard-section">
        <h3>Recent Activity</h3>
        <ul>
          <li>Appointment with Dr. Rao – Feb 10</li>
          <li>Blood Test Report uploaded</li>
          <li>Appointment request sent to Dr. Sharma</li>
        </ul>
      </div>
    </div>
  );
}

export default PatientDashboard;