import RegisterForm from "@/app/components/RegisterForm";
import Navbar from "../components/NavBar";

const RegisterPage = () => {
  return (
    <div className="landing-section">
      <Navbar />
      <div className="container mx-auto p-4 pt-6">
        <RegisterForm />
      </div>
    </div>
  );
};

export default RegisterPage;
