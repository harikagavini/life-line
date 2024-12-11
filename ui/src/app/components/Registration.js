"use client";

import Link from 'next/link';

const Registration = () => {
  return (
    <div className="flex justify-center items-center h-screen">
      <div className="flex flex-col space-y-4">
        <Link className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" href="/register/donor">
        Donor Registration
        </Link>
        <Link className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" href="/register/bloodbank">
            Blood Bank Registration
        </Link>
        <Link className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" href="/register/hospital">
            Hospital Registration
        </Link>
      </div>
    </div>
  );
};

export default Registration;