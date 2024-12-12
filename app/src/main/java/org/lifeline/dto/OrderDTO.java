package org.lifeline.dto;

import org.lifeline.enums.BloodType;
import org.lifeline.enums.StatusType;

public class OrderDTO {
    private Long orderId;
    private Boolean status;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
