import React from "react";
import { useNavigate } from "react-router-dom";

function Sidebar({ role }) {
  const navigate = useNavigate();

  return (
    <div className="sidebar">
      <h2>MEDVAULT</h2>

      <ul>
        {/* Dashboard */}
        <li
          onClick={() =>
            navigate(role === "doctor"
              ? "/doctor-dashboard"
              : "/patient-dashboard")
          }
        >
          Dashboard
        </li>

        {/* Common */}
        <li>Medical Records</li>
        <li>Appointments</li>

        {/* Profile */}
        <li
          onClick={() =>
            navigate(role === "doctor"
              ? "/doctor-profile"
              : "/patient-profile")
          }
        >
          Profile
        </li>
      </ul>
    </div>
  );
}

export default Sidebar;