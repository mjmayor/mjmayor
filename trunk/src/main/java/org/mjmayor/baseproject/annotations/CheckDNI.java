package org.mjmayor.baseproject.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.mjmayor.baseproject.annotations.impl.CheckDNIImpl;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CheckDNIImpl.class)
public @interface CheckDNI {

    String message() default "Error en la validacion del DNI";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
