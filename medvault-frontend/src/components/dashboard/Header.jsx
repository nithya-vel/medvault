import React from "react";

function Header() {
  return (
    <div className="dashboard-header">
      <div>Welcome Back 👋</div>
      <div className="profile-section">
        <span>Patient Name</span>
        <button>Logout</button>
      </div>
    </div>
  );
}

export default Header;