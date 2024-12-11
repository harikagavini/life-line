import DonorRegisterForm from "@/app/components/DonorRegisterForm";
import Navbar from "@/app/components/NavBar";

const DonorRegisterPage = () => {
  const options = [
    { href: '/', label: 'Home' },
    { href: '/login', label: 'Login' },
    { href: '/register', label: 'Registration' },
  ];
  return (
    <div className="landing-section">
      <Navbar options={options}/>
      <div className="container mx-auto p-4 pt-6">
        <DonorRegisterForm />
      </div>
    </div>
  );
};

export default DonorRegisterPage;
