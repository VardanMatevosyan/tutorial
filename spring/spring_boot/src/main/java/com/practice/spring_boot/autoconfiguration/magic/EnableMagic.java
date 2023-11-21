package com.practice.spring_boot.autoconfiguration.magic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MagicConfig.class)
public @interface EnableMagic {

}
