import Navbar from "../components/NavBar";
import Registration from "../components/Registration";

const RegisterPage = () => {
  const options = [
    { href: '/', label: 'Home' },
    { href: '/login', label: 'Login' },
    { href: '/register', label: 'Registration' },
  ];
  return (
    <div className="landing-section">
      <Navbar options={options}/>
      <div className="container mx-auto p-4 pt-6">
        <Registration />
      </div>
    </div>
  );
};

export default RegisterPage;
