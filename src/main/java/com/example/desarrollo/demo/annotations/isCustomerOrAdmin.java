package com.example.desarrollo.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.access.annotation.Secured;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
public @interface isCustomerOrAdmin {
}
