package com.practice.spring_boot.magic;

import com.practice.spring_boot.autoconfiguration.magic.Magic;
import org.springframework.stereotype.Service;

@Service
public class MagicTestClass {

  @Magic
  public void doMagic() {
    System.out.println("Regular day");
  }

}
