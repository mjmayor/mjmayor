package org.mjmayor.validations.dni;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.mjmayor.validations.dni.constants.DNI;
import org.mjmayor.validations.dni.impl.CheckDNILetterImpl;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CheckDNILetterImpl.class)
public @interface CheckDNILetter {

	String message() default DNI.DEFAULT_MESSAGE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
