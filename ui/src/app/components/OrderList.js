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
      setOrders(data);
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
        `${configuration.BACKEND_URL}/lifeline/orders/${orderId}/approve`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${Cookies.get("token")}`,
          },
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
        `${configuration.BACKEND_URL}/lifeline/orders/${orderId}/deny`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${Cookies.get("token")}`,
          },
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
      {orders.map((order, index) => (
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
