"use client";

import React from "react";
import { useState } from "react";
import Modal from "./Modal";

const EventCard = ({ event, onEdit, onDelete, isEditable }) => {
  const { name, eventDate, street, city, state, zip, branchId, eventId } = event;
  const [isModalOpen, setModalOpen] = useState(false);

  const handleEditClick = () => {
    setModalOpen(true);
  };

  const handleCloseModal = () => {
    setModalOpen(false);
  };
  
  const handleSubmit = async (updatedEvent) => {
    const success = await onEdit(updatedEvent);
    if (success) {
      handleCloseModal();
    }
  };

  return (
    <div className="card">
      <div className="card-content">
        <h3 className="card-title">{name}</h3>
        <p className="card-date">
          Date: {new Date(eventDate).toLocaleDateString()}
        </p>
        <p className="card-address">
          {street}, {city}, {state}, {zip}
        </p>
        <div className="card-actions">
          {isEditable && (
            <button className="btn-edit" onClick={() => onEdit(event)}>
              Edit
            </button>
          )}
          {isEditable && (
            <button className="btn-delete" onClick={() => onDelete(eventId)}>
              Delete
            </button>
          )}
        </div>
      </div>
      <Modal isOpen={isModalOpen} onClose={handleCloseModal}>
        <form
          onSubmit={(e) => {
            e.preventDefault();
            const updatedEvent = {
              ...event,
              name: e.target.name.value,
              eventDate: e.target.eventDate.value,
              street: e.target.street.value,
              city: e.target.city.value,
              state: e.target.state.value,
              zip: e.target.zip.value,
            };
            handleSubmit(updatedEvent);
          }}
        >
          <h3>Edit Event</h3>
          <div>
            <label>Name:</label>
            <input type="text" name="name" defaultValue={event.name} required />
          </div>
          <div>
            <label>Date:</label>
            <input type="date" name="eventDate" defaultValue={event.eventDate} required />
          </div>
          <div>
            <label>Street:</label>
            <input type="text" name="street" defaultValue={event.street} required />
          </div>
          <div>
            <label>City:</label>
            <input type="text" name="city" defaultValue={event.city} required />
          </div>
          <div>
            <label>State:</label>
            <input type="text" name="state" defaultValue={event.state} required />
          </div>
          <div>
            <label>Zip:</label>
            <input type="text" name="zip" defaultValue={event.zip} required />
          </div>
          <button type="submit" className="btn-edit">
            Save
          </button>
        </form>
      </Modal>
    </div>
  );
};

export default EventCard;
