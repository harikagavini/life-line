"use client";

import { useEffect, useState } from "react";
import configuration from "@/app/config";
import Cookies from "js-cookie";

export default function DonorLeaderBoard() {
  const [leaders, setLeaders] = useState([]);

  useEffect(() => {
    const fetchLeaders = async () => {
      try {
        const response = await fetch(
          `${configuration.BACKEND_URL}/lifeline/reward`,
          {
            method: "GET",
            headers: {
              "Content-Type": "application/json",
              "Authorization": `Bearer ${Cookies.get('token')}`,
            },
          }
        );
        const data = await response.json();
        setLeaders(data);
      } catch (error) {
        console.error("Failed to fetch storage data", error);
      }
    };

    fetchLeaders();
  }, []);

  return (
    <div className="bg-white shadow-md rounded p-6">
      <h2 className="text-xl font-semibold mb-4">Blood Donor Leader Board</h2>
      <table className="table-auto w-full text-left">
        <thead>
          <tr className="bg-gray-100">
            <th className="p-2">Donor Id</th>
            <th className="p-2">Lifetime Donations</th>
          </tr>
        </thead>
        <tbody>
          {leaders.map((leader, index) => (
            <tr key={index} className="border-b hover:bg-gray-50">
              <td className="p-2">{leader.donorId}</td>
              <td className="p-2">{leader.totalPoints}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
