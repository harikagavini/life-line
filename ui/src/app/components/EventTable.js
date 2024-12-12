"use client";

import React, { useState, useEffect } from 'react';
import { redirect } from 'next/navigation';
import configuration from '@/app/config';
import dateStringOffSetCorrection from '../utils/dateOffSetCorrection';

export default function EventsTable() {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    // Fetch events data
    fetch(`${configuration.BACKEND_URL}/lifeline/events`)
      .then((res) => res.json())
      .then((data) => setEvents(data));
  }, []);

  return (
    <div className="bg-white shadow-md rounded p-6">
      <h2 className="text-xl font-semibold mb-4">Events</h2>
      <table className="table-auto w-full text-left">
        <thead>
          <tr className="bg-gray-100">
            <th className="p-2">Event Name</th>
            <th className="p-2">Date</th>
            <th className="p-2">City</th>
          </tr>
        </thead>
        <tbody>
          {events.map((event, index) => (
            <tr
              key={index}
              className="border-b hover:bg-gray-50"
              onClick={() => redirect("/events")}
            >
              <td className="p-2">{event.name}</td>
              <td className="p-2">{dateStringOffSetCorrection(event.eventDate).toISOString().slice(0, 10)}</td>
              <td className="p-2">{event.city}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
