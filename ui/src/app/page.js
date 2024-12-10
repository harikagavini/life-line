import Head from 'next/head';
import { redirect } from 'next/navigation';
import Navbar from '@/app/components/NavBar';
import LandingSection from '@/app/components/LandingSection';
import isLoggedIn from '@/app/utils/isLoggedIn';
import Cookies from 'js-cookie';

export default function Home() {
  const options = [
    { href: '/feed', label: 'Feed' },
    { href: '/login', label: 'Login' },
    { href: '/register', label: 'Registration' },
  ];
  if(isLoggedIn(Cookies.get('token'))) {
    redirect('/feed');
  }
  return (
    <div>
      <Head>
        <title>LifeLine</title>
      </Head>
      <Navbar options={options}/>
      <LandingSection />
    </div>
  );
}