package org.lifeline.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BloodTypeConverter implements AttributeConverter<BloodType, String> {

    @Override
    public String convertToDatabaseColumn(BloodType bloodType) {
        return bloodType != null ? bloodType.getDisplayValue() : null;
    }

    @Override
    public BloodType convertToEntityAttribute(String dbValue) {
        if (dbValue == null) {
            return null;
        }

        for (BloodType type : BloodType.values()) {
            if (type.getDisplayValue().equals(dbValue)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknown blood type value: " + dbValue);
    }
}
