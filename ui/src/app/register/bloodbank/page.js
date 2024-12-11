import BloodBankRegisterForm from "@/app/components/BloodBankRegisterForm";
import Navbar from "@/app/components/NavBar";

const BloodBankRegisterPage = () => {
  const options = [
    { href: '/', label: 'Home' },
    { href: '/login', label: 'Login' },
    { href: '/register', label: 'Registration' },
  ];
  return (
    <div className="landing-section">
      <Navbar options={options}/>
      <div className="container mx-auto p-4 pt-6">
        <BloodBankRegisterForm />
      </div>
    </div>
  );
};

export default BloodBankRegisterPage;
