"use client";

import LoginForm from "@/app/components/Loginform";
import Navbar from "../components/NavBar";
import { redirect } from 'next/navigation';
import isLoggedIn from "@/app/utils/isLoggedIn";
import Cookies from 'js-cookie';

const LoginPage = () => {
  const options = [
    { href: '/', label: 'Home' },
    { href: '/register', label: 'Registration' },
  ];
  if(isLoggedIn(Cookies.get('token'))) {
    redirect('/feed');
  }
  return (
    <div className="landing-section">
      <Navbar options={options}/>
      <div className="container mx-auto p-4 pt-6">
        <LoginForm />
      </div>
    </div>
  );
};

export default LoginPage;
