// import { BrowserRouter, Routes, Route } from "react-router-dom";
// import Home from "./components/Home";
// import Login from "./components/auth/Login";
// import Register from "./components/auth/Register";

// function App() {
//   return (
//     <BrowserRouter>
//       <Routes>
//         <Route path="/" element={<Home />} />
//         <Route path="/login" element={<Login />} />
//         <Route path="/register" element={<Register />} />
//       </Routes>
//     </BrowserRouter>
//   );
// }

// export default App;

import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./components/Home";
import Login from "./components/auth/Login";
import Register from "./components/auth/Register";

import DashboardLayout from "./components/dashboard/DashboardLayout";

import PatientDashboard from "./components/dashboard/PatientDashboard";
import DoctorDashboard from "./components/dashboard/DoctorDashboard";

import PatientProfile from "./components/dashboard/PatientProfile";
import DoctorProfile from "./components/dashboard/DoctorProfile";

/* 🔥 ADD THESE IMPORTS */
import PatientRecords from "./components/dashboard/PatientRecords";
import Appointments from "./components/dashboard/Appointments";
import Approvals from "./components/dashboard/Approvals";

function App() {
  return (
    <BrowserRouter>
      <Routes>

        {/* Public Pages */}
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />

        {/* ================= PATIENT ROUTES ================= */}

        <Route
          path="/patient-dashboard"
          element={
            <DashboardLayout role="patient">
              <PatientDashboard />
            </DashboardLayout>
          }
        />

        <Route
          path="/patient-records"
          element={
            <DashboardLayout role="patient">
              <PatientRecords />
            </DashboardLayout>
          }
        />

        <Route
          path="/appointments"
          element={
            <DashboardLayout role="patient">
              <Appointments />
            </DashboardLayout>
          }
        />

        <Route
          path="/approvals"
          element={
            <DashboardLayout role="patient">
              <Approvals />
            </DashboardLayout>
          }
        />

        <Route
          path="/patient-profile"
          element={
            <DashboardLayout role="patient">
              <PatientProfile />
            </DashboardLayout>
          }
        />

        {/* ================= DOCTOR ROUTES ================= */}

        <Route
          path="/doctor-dashboard"
          element={
            <DashboardLayout role="doctor">
              <DoctorDashboard />
            </DashboardLayout>
          }
        />

        <Route
          path="/doctor-profile"
          element={
            <DashboardLayout role="doctor">
              <DoctorProfile />
            </DashboardLayout>
          }
        />

        {/* 🔥 Doctor approvals route */}
        <Route
          path="/doctor-approvals"
          element={
            <DashboardLayout role="doctor">
              <Approvals />
            </DashboardLayout>
          }
        />

      </Routes>
    </BrowserRouter>
  );
}

export default App;