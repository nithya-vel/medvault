import React from "react";

function HospitalProfile({ hospital }) {
  return (
    <div className="doctor-profile">
      <h2>Hospital Profile</h2>
      <div className="profile-grid">
        <p><strong>Name:</strong> {hospital.name}</p>
        <p><strong>Location:</strong> {hospital.location}</p>
        <p><strong>Registration ID:</strong> {hospital.regId}</p>
        <p><strong>Departments:</strong> {hospital.departments}</p>
      </div>
    </div>
  );
}

export default HospitalProfile;