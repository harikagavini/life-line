"use client";

import { useState, useEffect } from "react";
import configuration from "@/app/config";

export default function BloodStorage() {
  const [storage, setStorage] = useState([]);
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {
    // Fetch storage data
    fetch(`${configuration.BACKEND_URL}/lifeline/storage`)
      .then((res) => res.json())
      .then((data) => setStorage(data));
  }, []);

  const sortTable = (key) => {
    const sortedData = [...storage].sort((a, b) => {
      if (sortOrder === "asc") {
        return a[key] > b[key] ? 1 : -1;
      } else {
        return a[key] < b[key] ? 1 : -1;
      }
    });
    setSortOrder(sortOrder === "asc" ? "desc" : "asc");
    setStorage(sortedData);
  };

  return (
    <div className="bg-white shadow-md rounded p-6">
      <h2 className="text-xl font-semibold mb-4">Blood Storage</h2>
      <table className="table-auto w-full text-left">
        <thead>
          <tr className="bg-gray-100">
            <th
              className="cursor-pointer p-2"
              onClick={() => sortTable("branch")}
            >
              Branch
            </th>
            <th
              className="cursor-pointer p-2"
              onClick={() => sortTable("bloodType")}
            >
              Blood Type
            </th>
            <th
              className="cursor-pointer p-2"
              onClick={() => sortTable("quantity")}
            >
              Quantity
            </th>
          </tr>
        </thead>
        <tbody>
          {storage.map((row, index) => (
            <tr key={index} className="border-b hover:bg-gray-50">
              <td className="p-2">{row.branch}</td>
              <td className="p-2">{row.bloodType}</td>
              <td className="p-2">{row.quantity}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
