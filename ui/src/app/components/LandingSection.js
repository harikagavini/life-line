import Image from "next/image";

const LandingSection = () => {
  return (
    <div className="hero-container">
      <Image
        src="/lifeline.jpg"
        alt="Image"
        layout="fill"
        objectFit="cover"
      />
      <div className="hero-overlay">
        Save life, one drop at a time
      </div>
    </div>
  );
};
  
export default LandingSection;