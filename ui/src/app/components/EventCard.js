"use client";

import React from "react";

const EventCard = ({ event, onEdit, onDelete, isEditable }) => {
  const { name, eventDate, street, city, state, zip, branchId, eventId } = event;

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
    </div>
  );
};

export default EventCard;
