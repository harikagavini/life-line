"use client";

import React, { useState, useEffect } from 'react';
import configuration from '@/app/config';
import Cookies from 'js-cookie';
import { redirect } from 'next/navigation';
import isLoggedIn from '@/app/utils/isLoggedIn';

const types = [
  { value: 'DONOR', label: 'Donor' },
  { value: 'BLOOD_BANK', label: 'Blood Bank' },
  { value: 'HOSPITAL', label: 'Hospital' },
];

const LoginForm = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const [submissionComplete, setSubmissionComplete] = useState(false);
  const [registrationType, setRegistrationType] = useState(types[0].value);

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await fetch(`${configuration.BACKEND_URL}/lifeline/login`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password, registrationType }),
      });
      const data = await response.json();
      if (data.success) {
        // Registration successful, redirect to login page
        setSubmissionComplete(true);
        Cookies.set('token', data.token);
        Cookies.set('type', registrationType);
        if(data.branchId) Cookies.set('branchId', data.branchId);
        if(data.hospitalId) Cookies.set('hospitalId', data.hospitalId);
      } else {
        setError(data.message);
      }
    } catch (error) {
      setError('Login failed');
    }
  };

  useEffect(() => {
    if (isLoggedIn(Cookies.get('token'))) {
      redirect('/feed');
    }
  }, [submissionComplete]);

  return (
    <div className="max-w-md mx-auto mt-10 p-6 bg-white rounded-lg shadow-md">
      <h2 className="text-2xl font-bold mb-4">Login</h2>
      <form onSubmit={handleSubmit}>
        <div className="flex flex-wrap -mx-3 mb-6">
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="email">
              Email
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="email"
              type="email"
              value={email}
              onChange={(event) => setEmail(event.target.value)}
              required
            />
          </div>
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="password">
              Password
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="password"
              type="password"
              value={password}
              onChange={(event) => setPassword(event.target.value)}
              required
            />
          </div>
        </div>
        <div className="flex flex-wrap -mx-3 mb-6">
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="registrationType">
              Type
            </label>
            <select
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="registrationType"
              value={registrationType}
              onChange={(event) => setRegistrationType(event.target.value)}
            >
              {types.map((type) => (
                <option key={type.value} value={type.value}>
                  {type.label}
                </option>
              ))}
            </select>
          </div>
        </div>
        {error && <p className="text-red-500">{error}</p>}
        <button
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
          type="submit"
        >
          Login
        </button>
      </form>
    </div>
  );
};

export default LoginForm;
