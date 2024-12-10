import Head from 'next/head';
import Navbar from '@/app/components/NavBar';
import LandingSection from '@/app/components/LandingSection';

export default function Home() {
  return (
    <div>
      <Head>
        <title>LifeLine</title>
      </Head>
      <Navbar />
      <LandingSection />
    </div>
  );
}