package com.practice.spring_boot.autoconfiguration.magic;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagicConfig {

  @Bean
  public BeanPostProcessor enableMagicBbp() {
    return new EnableMagicBeanPostProcessor();
  }

}
