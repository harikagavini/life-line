"use client";

import Link from "next/link";
import { useState } from "react";

const Navbar = ({ options }) => {
  const [toggle, setToggle] = useState(false);

  const handleToggle = () => {
    console.log("Toggle clicked");
    setToggle(!toggle);
  };

  return (
    <nav className="navbar">
      <div className="logo">
        <Link href="/">LifeLine</Link>
      </div>
      <div className="nav-links-dropdown">
        <button className="dropdown-toggle" onClick={handleToggle}>
          Menu
        </button>
        {toggle && (
          <ul className="dropdown-menu">
            {options.map((option, index) => (
              <li key={index}>
                <Link key={index} href={option.href}>
                  {option.label}
                </Link>
              </li>
            ))}
          </ul>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
