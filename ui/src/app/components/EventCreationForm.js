"use client";

import React, { useState, useEffect } from 'react';
import { redirect } from 'next/navigation';
import configuration from '@/app/config';
import Cookies from 'js-cookie';

const EventCreationForm = () => {
  const [branchId, setBranchId] = useState('');
  const [name, setName] = useState('');
  const [eventDate, setEventDate] = useState('');
  const [street, setStreet] = useState('');
  const [city, setCity] = useState('');
  const [state, setState] = useState('');
  const [zip, setZip] = useState('');
  const [error, setError] = useState(null);
  const [submissionComplete, setSubmissionComplete] = useState(false);

  const validateEventDate = (inputDate) => {
    const today = new Date();
    const enteredDate = new Date(inputDate);
  
    // Check if the entered date is valid
    if (isNaN(enteredDate)) {
      setError("Invalid date. Please enter a valid date.");
      return false;
    }
  
    // Check if the entered date is in the future
    if (enteredDate < today) {
      setError("Event date cannot be in the past.");
      return false;
    }

    // Clear the error if all validations pass
    setError("");
    return true;
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    if(!validateEventDate(eventDate)){
      return;
    }
    try {
      const response = await fetch(`${configuration.BACKEND_URL}/lifeline/events/create`, {
        method: 'POST',
        headers: { 
          'Content-Type': 'application/json' ,
          'Authorization': `Bearer ${Cookies.get('token')}`
        },
        body: JSON.stringify({
          name,
          branchId,
          eventDate,
          street,
          city,
          state,
          zip,
        }),
      });
      const data = await response.json();
      if (data.success) {
        // Registration successful, redirect to login page
        setSubmissionComplete(true);
      } else {
        setError(data.message);
      }
    } catch (error) {
      setError('Creation failed');
    }
  };
  
  useEffect(() => {
    if (submissionComplete) {
      redirect('/lifeline/events');
    }
  }, [submissionComplete]);

  return (
    <div className="max-w-md mx-auto mt-10 p-6 bg-white rounded-lg shadow-md">
      <h2 className="text-2xl font-bold mb-4">Event Creation</h2>
      <form onSubmit={handleSubmit}>
        <div className="flex flex-wrap -mx-3 mb-6">
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="first_name">
              Branch Id
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="branchId"
              type="text"
              value={branchId}
              onChange={(event) => setBranchId(event.target.value)}
              required
            />
          </div>
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="last_name">
              Name
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="name"
              type="text"
              value={name}
              onChange={(event) => setName(event.target.value)}
              required
            />
          </div>
        </div>
        <div className="flex flex-wrap -mx-3 mb-6">
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="dob">
              Event date
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="eventDate"
              type="date"
              value={eventDate}
              onChange={(event) => setEventDate(event.target.value)}
              required
            />
          </div>
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="street">
              Street
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="street"
              type="text"
              value={street}
              onChange={(event) => setStreet(event.target.value)}
            />
          </div>
        </div>
        <div className="flex flex-wrap -mx-3 mb-6">
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="city">
              City
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="city"
              type="text"
              value={city}
              onChange={(event) => setCity(event.target.value)}
            />
          </div>
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="state">
              State
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="state"
              type="text"
              value={state}
              onChange={(event) => setState(event.target.value)}
            />
          </div>
        </div>
        <div className="flex flex-wrap -mx-3 mb-6">
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="zip">
              Zip
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="zip"
              type="text"
              value={zip}
              onChange={(event) => setZip(event.target.value)}
            />
          </div>
        </div>
        {error && <p className="text-red-500">{error}</p>}
        <button
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
          type="submit"
        >
          Create
        </button>
      </form>
    </div>
  );
};

export default EventCreationForm;