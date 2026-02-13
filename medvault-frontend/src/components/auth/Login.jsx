import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";

function Login() {
  const [form, setForm] = useState({
    email: "",
    password: "",
    role: "",
  });

  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setLoading(true);

    setTimeout(() => {
      setLoading(false);

      if (form.role === "patient") {
        navigate("/patient-dashboard");
      } else if (form.role === "doctor") {
        navigate("/doctor-dashboard");   // ✅ corrected here
      } else {
        alert("Please select role");
      }

    }, 1000);
  };

  return (
    <div className="login-wrapper">
      <div className="login-card">

        <div className="login-header">
          <h1>MedVault</h1>
          <p>Secure Medical Record Access</p>
        </div>

        <form onSubmit={handleSubmit} className="login-form">

          {/* Email */}
          <div className="form-group">
            <label>Email Address</label>
            <input
              type="email"
              name="email"
              placeholder="doctor@hospital.com"
              value={form.email}
              onChange={handleChange}
              required
            />
          </div>

          {/* Password */}
          <div className="form-group">
            <label>Password</label>
            <input
              type="password"
              name="password"
              placeholder="Enter your password"
              value={form.password}
              onChange={handleChange}
              required
            />
          </div>

          {/* Role Selection */}
          <div className="form-group">
            <label>Select Role</label>
            <select
              name="role"
              value={form.role}
              onChange={handleChange}
              required
              className="role-select"
            >
              <option value="">-- Select Role --</option>
              <option value="patient">Patient</option>
              <option value="doctor">Doctor</option>
            </select>
          </div>

          <span
            className="forgot"
            onClick={() => alert("Reset feature coming soon")}
          >
            Forgot Password?
          </span>

          <button type="submit" className="login-btn" disabled={loading}>
            {loading ? "Signing In..." : "Sign In"}
          </button>
        </form>

        <div className="login-footer">
          <p>
            Don’t have an account?{" "}
            <span onClick={() => navigate("/register")}>
              Create Account
            </span>
          </p>
        </div>

      </div>
    </div>
  );
}

export default Login;
