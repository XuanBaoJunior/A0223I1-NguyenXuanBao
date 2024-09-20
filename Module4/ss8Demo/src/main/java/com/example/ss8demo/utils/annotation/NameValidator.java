package com.example.ss8demo.utils.annotation;

import com.example.ss8demo.repositories.IClassroomRepository;
import com.example.ss8demo.utils.annotation.NameConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NameValidator implements ConstraintValidator<NameConstraint, String> {

    @Autowired
    private IClassroomRepository iClassroomRepository;
    @Override
    public void initialize(NameConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value.matches("[A-Za-z ]{4,}");
    }
}
