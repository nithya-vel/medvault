// import React from "react";
// import "./Dashboard.css";

// function Dashboard() {
//   return (
//     <div className="dashboard">
//       <aside className="sidebar">
//         <h2>MedVault</h2>
//         <ul>
//           <li>My Reports</li>
//           <li>Appointments</li>
//           <li>Prescriptions</li>
//           <li>Profile</li>
//         </ul>
//       </aside>

//       <main className="dashboard-content">
//         <h1>Welcome Back 👋</h1>
//         <p>Your health overview at a glance.</p>
//       </main>
//     </div>
//   );
// }

// export default Dashboard;


import React from "react";
import { useNavigate, useLocation } from "react-router-dom";
import "./dashboard.css";

function DashboardLayout({ children, role }) {
  const navigate = useNavigate();
  const location = useLocation();

  const isActive = (path) => {
    return location.pathname === path ? "active" : "";
  };

  return (
    <div className="dashboard-container">

      {/* ===== Sidebar ===== */}
      <div className="sidebar">
        <h2 className="logo">MEDVAULT</h2>

        <ul>
          {role === "doctor" && (
            <>
              <li
                className={isActive("/doctor-dashboard")}
                onClick={() => navigate("/doctor-dashboard")}
              >
                Dashboard
              </li>

              <li
                className={isActive("/patient-records")}
                onClick={() => navigate("/patient-records")}
              >
                Patient Records
              </li>

              <li
                className={isActive("/approvals")}
                onClick={() => navigate("/approvals")}
              >
                Approvals
              </li>

              <li
                className={isActive("/doctor-profile")}
                onClick={() => navigate("/doctor-profile")}
              >
                Profile
              </li>
            </>
          )}

          {role === "patient" && (
            <>
              <li
                className={isActive("/patient-dashboard")}
                onClick={() => navigate("/patient-dashboard")}
              >
                Dashboard
              </li>

              <li
                className={isActive("/patient-records")}
                onClick={() => navigate("/patient-records")}
              >
                Medical Records
              </li>

              <li
                className={isActive("/appointments")}
                onClick={() => navigate("/appointments")}
              >
                Appointments
              </li>

              <li
                className={isActive("/approvals")}
                onClick={() => navigate("/approvals")}
              >
                Approvals
              </li>

              <li
                className={isActive("/patient-profile")}
                onClick={() => navigate("/patient-profile")}
              >
                Profile
              </li>
            </>
          )}
        </ul>
      </div>

      {/* ===== Main Content ===== */}
      <div className="main-content">
        <div className="topbar">
          <h3>Welcome Back 👋</h3>
          <button onClick={() => navigate("/login")}>Logout</button>
        </div>

        <div className="content-area">
          {children}
        </div>
      </div>

    </div>
  );
}

export default DashboardLayout;