"use client";

import Navbar from "@/app/components/NavBar";
import OrderCreationForm from "@/app/components/OrderCreationForm";
import isLoggedIn from "@/app/utils/isLoggedIn";
import Cookies from "js-cookie";
import { redirect } from 'next/navigation';

const EventCreationPage = () => {
  const options = [
    { href: '/feed', label: 'Feed' },
    { href: '/events', label: 'Events' },
    { href: '/profile', label: 'Profile' },
    { href: '/signout', label: 'SignOut' },
  ];
  if(Cookies.get('type') === 'BLOOD_BANK' || Cookies.get('type') === 'HOSPITAL') {
    options.splice(1,0,{ href: '/orders', label: 'Orders' })
  }
  if(!isLoggedIn(Cookies.get('token'))) {
    redirect('/login');
  }
  return (
    <div className="landing-section">
      <Navbar options={options}/>
      <div className="container mx-auto p-4 pt-6">
        <OrderCreationForm />
      </div>
    </div>
  );
};

export default EventCreationPage;
