"use client";

import BloodBankRegisterForm from "@/app/components/BloodBankRegisterForm";
import Navbar from "@/app/components/NavBar";
import isLoggedIn from "@/app/utils/isLoggedIn";
import Cookies from "js-cookie";

const BloodBankRegisterPage = () => {
  const options = [
    { href: '/', label: 'Home' },
    { href: '/login', label: 'Login' },
    { href: '/register', label: 'Registration' },
  ];
  if(isLoggedIn(Cookies.get('token'))) {
    redirect('/feed');
  }
  return (
    <div className="landing-section">
      <Navbar options={options}/>
      <div className="container mx-auto p-4 pt-6">
        <BloodBankRegisterForm />
      </div>
    </div>
  );
};

export default BloodBankRegisterPage;
