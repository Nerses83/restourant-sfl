package com.interview.test.sfl.restourant.model.converter;

import com.interview.test.sfl.restourant.model.enums.OrderStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderStatus profile) {
        return profile.getValue();
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer value) {
        return OrderStatus.valueOf(value);
    }
}

