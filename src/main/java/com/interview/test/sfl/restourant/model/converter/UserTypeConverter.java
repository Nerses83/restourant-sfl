package com.interview.test.sfl.restourant.model.converter;

import com.interview.test.sfl.restourant.model.enums.UserType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserType profile) {
        return profile.getValue();
    }

    @Override
    public UserType convertToEntityAttribute(Integer value) {
        return UserType.valueOf(value);
    }
}

