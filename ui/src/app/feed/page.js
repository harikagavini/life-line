"use client";

import Head from 'next/head';
import Navbar from '@/app/components/NavBar';
import isLoggedIn from '@/app/utils/isLoggedIn';
import Cookies from 'js-cookie';
import { redirect } from 'next/navigation';

export default function Feed() {
  const options = []
  options.push({ href: '/feed', label: 'Feed' })
  if(Cookies.get('type') === 'HOSPITAL' || Cookies.get('type') === 'BLOOD_BANK') {
    options.push({ href: '/orders', label: 'View orders' })
  }
  options.push({ href: '/events', label: 'Events' },)
  options.push({ href: '/signout', label: 'SignOut' });

  if(!isLoggedIn(Cookies.get('token'))) {
    redirect('/login');
  }
  return (
    <div>
      <Head>
        <title>LifeLine</title>
      </Head>
      <Navbar options={options}/>
      <div className="container mx-auto p-6 space-y-8">
        <BloodStorage />
        <DonorLeaderBoard />
        <EventsTable />
      </div>
    </div>
  );
}
