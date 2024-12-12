"use client";

import React, { useEffect, useState } from "react";
import OrderCard from "./OrderCard";
import configuration from "@/app/config";
import Cookies from "js-cookie";

const OrderList = () => {
  const [orders, setOrders] = useState([]);

  const fetchOrders = async () => {
    try {
      const response = await fetch(
        `${configuration.BACKEND_URL}/lifeline/orders`,
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${Cookies.get("token")}`,
          },
        }
      );
      const data = await response.json();
      const newData = data.filter((entry) => entry.hospitalId == Cookies.get('hospitalId') || entry.branchId == Cookies.get('branchId'))
      setOrders(newData);
    } catch (error) {
      console.error("Failed to fetch orders", error);
    }
  };

  useEffect(() => {
    fetchOrders();
  }, []);

  const handleApprove = async (orderId) => {
    try {
      const response = await fetch(
        `${configuration.BACKEND_URL}/lifeline/orders`,
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${Cookies.get("token")}`,
          },
          body: JSON.stringify({
            orderId,
            status: true
          })
        }
      );
      if (response.ok) {
        setOrders((prevOrders) =>
          prevOrders.map((order) =>
            order.orderId === orderId ? { ...order, status: "APPROVED" } : order
          )
        );
      } else {
        console.error("Failed to approve order");
      }
    } catch (error) {
      console.error("Error approving order", error);
    }
  };

  const handleDeny = async (orderId) => {
    try {
      const response = await fetch(
        `${configuration.BACKEND_URL}/lifeline/orders`,
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${Cookies.get("token")}`,
          },
          body: JSON.stringify({
            orderId,
            status: false,
          })
        }
      );
      if (response.ok) {
        setOrders((prevOrders) =>
          prevOrders.map((order) =>
            order.orderId === orderId ? { ...order, status: "DENIED" } : order
          )
        );
      } else {
        console.error("Failed to deny order");
      }
    } catch (error) {
      console.error("Error denying order", error);
    }
  };

  return (
    <div className="order-list">
      {orders && orders.map((order, index) => (
        <OrderCard
          key={index}
          order={order}
          isActionable={
            Cookies.get("type") === "BLOOD_BANK" &&
            Cookies.get("branchId") === order.branchId
          }
          onApprove={handleApprove}
          onDeny={handleDeny}
        />
      ))}
    </div>
  );
};

export default OrderList;
