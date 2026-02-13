import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Register.css";

function Register() {
  const [form, setForm] = useState({
    firstName: "",
    lastName: "",
    email: "",
    contact: "",
    password: "",
    otp: ""
  });

  const [generatedOtp, setGeneratedOtp] = useState("");
  const [otpSent, setOtpSent] = useState(false);
  const [otpVerified, setOtpVerified] = useState(false);

  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  // ✅ Send OTP (No 10-digit validation)
  const handleSendOtp = () => {
    const otp = Math.floor(100000 + Math.random() * 900000); // 6 digit OTP
    setGeneratedOtp(otp.toString());
    setOtpSent(true);

    alert("Demo OTP: " + otp);
  };

  // ✅ Verify OTP (Only 6 digits allowed)
  const handleVerifyOtp = () => {
    if (form.otp.length !== 6) {
      alert("OTP must be 6 digits");
      return;
    }

    if (form.otp === generatedOtp) {
      setOtpVerified(true);
      alert("OTP Verified ✅");
    } else {
      alert("Invalid OTP ❌");
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!otpVerified) {
      alert("Please verify OTP first");
      return;
    }

    alert("Registered Successfully!");
    navigate("/login");
  };

  return (
    <div className="register-wrapper">
      <div className="register-card">
        <h2>Create Account</h2>
        <p className="subtitle">Join MedVault today</p>

        <form onSubmit={handleSubmit}>

          <div className="name-row">
            <input
              type="text"
              name="firstName"
              placeholder="First Name"
              onChange={handleChange}
              required
            />
            <input
              type="text"
              name="lastName"
              placeholder="Last Name"
              onChange={handleChange}
              required
            />
          </div>

          <input
            type="email"
            name="email"
            placeholder="Email Address"
            onChange={handleChange}
            required
          />

          <input
            type="tel"
            name="contact"
            placeholder="Contact Number"
            onChange={handleChange}
            required
          />

          <button type="button" onClick={handleSendOtp}>
            Send OTP
          </button>

          {otpSent && (
            <>
              <input
                type="text"
                name="otp"
                placeholder="Enter 6 Digit OTP"
                pattern="[0-9]{6}"
                title="Enter 6 digit OTP"
                onChange={handleChange}
                required
              />

              <button type="button" onClick={handleVerifyOtp}>
                Verify OTP
              </button>
            </>
          )}

          <input
            type="password"
            name="password"
            placeholder="Create Password"
            onChange={handleChange}
            required
          />

          <button type="submit">
            Register
          </button>

        </form>

        <p className="login-link">
          Already have an account?{" "}
          <span onClick={() => navigate("/login")}>
            Sign In
          </span>
        </p>
      </div>
    </div>
  );
}

export default Register;