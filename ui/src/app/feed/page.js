"use client";

import Head from 'next/head';
import Navbar from '@/app/components/NavBar';
import isLoggedIn from '@/app/utils/isLoggedIn';
import Cookies from 'js-cookie';
import { redirect } from 'next/navigation';

export default function Feed() {
  const options = [
    { href: '/', label: 'Home' },
    { href: '/profile', label: 'Profile' },
    { href: '/signout', label: 'SignOut' },
  ];

  if(!isLoggedIn(Cookies.get('token'))) {
    redirect('/login');
  }
  return (
    <div>
      <Head>
        <title>LifeLine</title>
      </Head>
      <Navbar options={options}/>
    </div>
  );
}