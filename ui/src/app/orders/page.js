"use client";

import Navbar from "@/app/components/NavBar";
import isLoggedIn from "@/app/utils/isLoggedIn";
import Cookies from "js-cookie";
import { redirect } from 'next/navigation';
import OrderList from "../components/OrderList";

const OrdersViewPage = () => {
  const options = []
  options.push({ href: '/feed', label: 'Feed' })
  if(Cookies.get('type') === 'HOSPITAL') {
    options.push({ href: '/orders/create', label: 'Create order' })
  }
  options.push({ href: '/events', label: 'Events' });
  options.push({ href: '/signout', label: 'SignOut' });
  if(!isLoggedIn(Cookies.get('token'))) {
    redirect('/login');
  }
  return (
    <div className="landing-section">
      <Navbar options={options}/>
      <OrderList />
    </div>
  );
};

export default OrdersViewPage;
