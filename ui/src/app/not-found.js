import Navbar from "@/app/components/NavBar";

export default function CatchAllNotFound() {
  const options = [
    { href: '/home', label: 'Home' },
    { href: '/login', label: 'Login' },
    { href: '/register', label: 'Registration' },
  ];
  return (
    <div>
      <Navbar options={options}/>
      <h1 className="centered">404: Page Not Found</h1>
    </div>
  );
}
