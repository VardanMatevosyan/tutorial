package com.practice.collections.linkedList;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class SimpleLinkedListTest {

  @Test
  public void test_reverseLinkedList_success() {
    List<String> linkedList = new SimpleLinkedList<>();
    linkedList.add("A1");
    linkedList.add("A2");
    linkedList.add("A3");
    linkedList.add("A4");
    linkedList.add("A5");
    print(linkedList);

    linkedList.reverse();

    assertThat(linkedList.get(0), equalTo("A5"));
    assertThat(linkedList.get(3), equalTo("A2"));
    assertThat(linkedList.get(4), equalTo("A1"));

    print(linkedList);
  }

  private static void print(List<String> linkedList) {
    for (int i = 0; i < linkedList.size(); i++) {
      System.out.print(linkedList.get(i) + " ");
    }
    System.out.println();
  }

}