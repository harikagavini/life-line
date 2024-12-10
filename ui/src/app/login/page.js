import LoginForm from "@/app/components/Loginform";
import Navbar from "../components/NavBar";

const LoginPage = () => {
  const options = [
    { href: '/', label: 'Home' },
    { href: '/register', label: 'Registration' },
  ];
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
