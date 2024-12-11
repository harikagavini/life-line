"use client";

import Navbar from "../components/NavBar";
import Registration from "../components/Registration";
import isLoggedIn from "../utils/isLoggedIn";
import Cookies from "js-cookie";

const RegisterPage = () => {
  const options = [
    { href: '/', label: 'Home' },
    { href: '/login', label: 'Login' },
    { href: '/register', label: 'Registration' },
  ];
  console.log(`Token: ${Cookies.get('token')}`);
  if(isLoggedIn(Cookies.get('token'))) {
    redirect('/feed');
  }
  return (
    <div className="landing-section">
      <Navbar options={options}/>
      <div className="container mx-auto p-4 pt-6">
        <Registration />
      </div>
    </div>
  );
};

export default RegisterPage;
