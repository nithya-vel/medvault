import React, { useState } from "react";
import "./Profile.css";

function DoctorProfile() {
  const [doctor, setDoctor] = useState({
    name: "Dr. Kumar",
    specialization: "Cardiologist",
    experience: "10",
    hospital: "Apollo Hospital",
    email: "doctor@email.com",
    phone: "9123456780"
  });

  const handleChange = (e) => {
    setDoctor({ ...doctor, [e.target.name]: e.target.value });
  };

  const handleSave = () => {
    alert("Doctor Profile Updated Successfully ✅");
  };

  return (
    <div className="profile-container">
      <h2>Doctor Profile</h2>

      <div className="profile-form">
        <input name="name" value={doctor.name} onChange={handleChange} placeholder="Doctor Name" />
        <input name="specialization" value={doctor.specialization} onChange={handleChange} placeholder="Specialization" />
        <input name="experience" value={doctor.experience} onChange={handleChange} placeholder="Years of Experience" />
        <input name="hospital" value={doctor.hospital} onChange={handleChange} placeholder="Hospital Name" />
        <input name="email" value={doctor.email} onChange={handleChange} placeholder="Email" />
        <input name="phone" value={doctor.phone} onChange={handleChange} placeholder="Phone" />

        <button onClick={handleSave}>Save Changes</button>
      </div>
    </div>
  );
}

export default DoctorProfile;