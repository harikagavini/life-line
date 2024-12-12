"use client";

import { useEffect, useState } from "react";
import configuration from "@/app/config";
import Cookies from "js-cookie";

export default function DonorLeaderBoard() {
  const [leaders, setLeaders] = useState([]);

  useEffect(() => {
    // Fetch leader board data
    fetch(`${configuration.BACKEND_URL}/lifeline/reward`)
      .then((res) => res.json())
      .then((data) => setLeaders(data));
  }, []);

  return (
    <div className="bg-white shadow-md rounded p-6">
      <h2 className="text-xl font-semibold mb-4">Blood Donor Leader Board</h2>
      <table className="table-auto w-full text-left">
        <thead>
          <tr className="bg-gray-100">
            <th className="p-2">Name</th>
            <th className="p-2">Lifetime Donations</th>
          </tr>
        </thead>
        <tbody>
          {leaders.map((leader, index) => (
            <tr key={index} className="border-b hover:bg-gray-50">
              <td className="p-2">{leader.name}</td>
              <td className="p-2">{leader.donations}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
