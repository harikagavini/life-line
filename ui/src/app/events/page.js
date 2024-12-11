"use client";

import Navbar from "@/app/components/NavBar";
import isLoggedIn from "@/app/utils/isLoggedIn";
import Cookies from "js-cookie";
import { redirect } from 'next/navigation';
import EventList from "../components/EventList";

const EventsViewPage = () => {
  const options = []
  options.push({ href: '/feed', label: 'Feed' })
  if(Cookies.get('type') === 'BLOOD_BANK') {
    options.push({ href: '/events/create', label: 'Create Event' })
  } 
  options.push({ href: '/signout', label: 'SignOut' });
  if(!isLoggedIn(Cookies.get('token'))) {
    redirect('/login');
  }
  return (
    <div className="landing-section">
      <Navbar options={options}/>
      <EventList />
    </div>
  );
};

export default EventsViewPage;
