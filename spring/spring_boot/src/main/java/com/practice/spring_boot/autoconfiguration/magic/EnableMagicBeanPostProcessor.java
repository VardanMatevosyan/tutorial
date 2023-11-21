package com.practice.spring_boot.autoconfiguration.magic;

import static java.util.Objects.nonNull;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EnableMagicBeanPostProcessor implements BeanPostProcessor {

  private static final Map<String, Class<?>> magicClasses = new ConcurrentHashMap<>();

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    Class<?> magicClass = bean.getClass();
    if (isMagicPresent(magicClass)) {
      magicClasses.put(beanName, magicClass);
      System.out.println("This is magic before you believe");
    }
    return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (magicClasses.containsKey(beanName)) {
      Class<?> magicClass = magicClasses.get(beanName);
      if (nonNull(magicClass)) {
        System.out.println("This is magic after you believe");
      }
    }
    return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
  }

  private static boolean isMagicPresent(Class<?> aClass) {
    return Arrays.stream(aClass.getDeclaredMethods())
        .anyMatch(method -> method.isAnnotationPresent(Magic.class));
  }
}
