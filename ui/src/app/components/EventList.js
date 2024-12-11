"use client";

import React, { useEffect, useState } from "react";
import EventCard from "./EventCard";
import configuration from "@/app/config";
import Cookies from "js-cookie";

const EventList = () => {
  const [events, setEvents] = useState([]);

  const fetchEvents = async () => {
    try {
      const response = await fetch(
        `${configuration.BACKEND_URL}/lifeline/events`,
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${Cookies.get('token')}`
          },
        }
      );
      const data = await response.json();
      setEvents(data);
    } catch (error) {
      console.error("Failed to fetch events", error);
    }
  };

  useEffect(() => {
    fetchEvents();
  }, []);

  const handleEdit = async (updatedEvent) => {
    try {
      const response = await fetch(`${configuration.BACKEND_URL}/lifeline/events/${updatedEvent.id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
          "Authorization": `Bearer ${Cookies.get('token')}`
        },
        body: JSON.stringify(updatedEvent),
      });

      if (response.ok) {
        // Update the state with the edited event
        setEvents((prevEvents) =>
          prevEvents.map((event) => (event.eventId === updatedEvent.eventId ? updatedEvent : event))
        );
        return true;
      } else {
        console.error("Failed to update event");
        return false;
      }
    } catch (error) {
      console.error("Error updating event:", error);
      return false;
    }
  };

  const handleDelete = async (id) => {
    try {
      const response = await fetch(
        `${configuration.BACKEND_URL}/lifeline/events/${id}`,
        {
          method: "DELETE",
          headers: {
            "Content-Type": "application/json",
          },
        }
      );

      if (response.ok) {
        // Remove the deleted event from the state
        setEvents(events.filter((event) => event.eventId !== id));
      } else {
        console.error("Failed to delete event");
      }
    } catch (error) {
      console.error("Error deleting event", error);
    }
  };

  return (
    <div className="event-list">
      {events.map((event, index) => (
        <EventCard
          key={index}
          event={event}
          isEditable={Cookies.get('type') === 'BLOOD_BANK'} // Set based on user role or permissions
          onEdit={handleEdit}
          onDelete={handleDelete}
        />
      ))}
    </div>
  );
};

export default EventList;
