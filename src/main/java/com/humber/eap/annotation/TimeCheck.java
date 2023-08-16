package com.humber.eap.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Custom annotation

//where we want to implement the annotation
@Target(ElementType.METHOD)
//how long the annotation should be retained
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeCheck {

}
