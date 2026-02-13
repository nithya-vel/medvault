import React, { useState } from "react";
import "./Profile.css";

function PatientProfile() {
  const [patient, setPatient] = useState({
    firstName: "Greeshma",
    lastName: "Reddy",
    email: "patient@email.com",
    phone: "9876543210",
    bloodGroup: "O+",
    age: "22",
    address: "Hyderabad"
  });

  const handleChange = (e) => {
    setPatient({ ...patient, [e.target.name]: e.target.value });
  };

  const handleSave = () => {
    alert("Profile Updated Successfully ✅");
  };

  return (
    <div className="profile-container">
      <h2>Patient Profile</h2>

      <div className="profile-form">
        <input name="firstName" value={patient.firstName} onChange={handleChange} placeholder="First Name" />
        <input name="lastName" value={patient.lastName} onChange={handleChange} placeholder="Last Name" />
        <input name="email" value={patient.email} onChange={handleChange} placeholder="Email" />
        <input name="phone" value={patient.phone} onChange={handleChange} placeholder="Phone" />
        <input name="bloodGroup" value={patient.bloodGroup} onChange={handleChange} placeholder="Blood Group" />
        <input name="age" value={patient.age} onChange={handleChange} placeholder="Age" />
        <input name="address" value={patient.address} onChange={handleChange} placeholder="Address" />

        <button onClick={handleSave}>Save Changes</button>
      </div>
    </div>
  );
}

export default PatientProfile;