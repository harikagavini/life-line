import Link from "next/link";

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="logo">LifeLine</div>
      <ul className="nav-links">
        <li><Link href="/">Home</Link></li>
        <li><Link href="/login">Login</Link></li>
        <li><Link href="/register">Registration</Link></li>
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
