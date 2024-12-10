import Image from "next/image";

const LandingSection = () => {
  return (
    <div className="landing-section">
      <Image
        src="/lifeline.jpg"
        alt="Your Image Alt Text"
        width={400}
        height={400}
      />
    </div>
  );
};
  
export default LandingSection;