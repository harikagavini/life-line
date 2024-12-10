import Link from "next/link";

const Navbar = ({ options }) => {
  return (
    <nav className="navbar">
      <div className="logo">LifeLine</div>
      <ul className="nav-links">
        {options.map((option, index) => (
          <li key={index}><Link key={index} href={option.href}>{option.label}</Link></li>
        ))}
      </ul>
      <div className="menu-toggle">
        <span></span>
        <span></span>
        <span></span>
      </div>
    </nav>
  );
};

export default Navbar;
