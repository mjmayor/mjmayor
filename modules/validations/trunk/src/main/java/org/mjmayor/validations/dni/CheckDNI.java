package org.mjmayor.validations.dni;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.mjmayor.validations.constants.AnnotationConstants;
import org.mjmayor.validations.dni.impl.CheckDNIImpl;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CheckDNIImpl.class)
public @interface CheckDNI {

	String message() default AnnotationConstants.DNI.DEFAULT_MESSAGE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
