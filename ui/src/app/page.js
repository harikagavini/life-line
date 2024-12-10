import Head from 'next/head';
import Navbar from '@/app/components/NavBar';
import LandingSection from '@/app/components/LandingSection';

export default function Home() {
  const options = [
    { href: '/', label: 'Home' },
    { href: '/login', label: 'Login' },
    { href: '/register', label: 'Registration' },
  ];
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