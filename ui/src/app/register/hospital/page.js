import HospitalRegistrationForm from "@/app/components/HospitalRegistrationForm";
import Navbar from "@/app/components/NavBar";

const HospitalRegisterPage = () => {
  const options = [
    { href: '/', label: 'Home' },
    { href: '/login', label: 'Login' },
    { href: '/register', label: 'Registration' },
  ];
  return (
    <div className="landing-section">
      <Navbar options={options}/>
      <div className="container mx-auto p-4 pt-6">
        <HospitalRegistrationForm />
      </div>
    </div>
  );
};

export default HospitalRegisterPage;
