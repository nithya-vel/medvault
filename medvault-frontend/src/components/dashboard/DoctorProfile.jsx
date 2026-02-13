import React from "react";

function DoctorProfile() {

  // Temporary dummy data (so it won’t crash)
  const doctor = {
    name: "Dr. Smith",
    email: "doctor@gmail.com",
    specialization: "Cardiologist"
  };

  return (
    <div style={{ padding: "30px" }}>
      <h2>Doctor Profile</h2>

      <p><strong>Name:</strong> {doctor?.name}</p>
      <p><strong>Email:</strong> {doctor?.email}</p>
      <p><strong>Specialization:</strong> {doctor?.specialization}</p>
    </div>
  );
}

export default DoctorProfile;