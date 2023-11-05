package com.practice.collections.linkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * MiddleElement help to find middle element from the linkedList.
 * @param <V> value type.
 */
public class MiddleElement<V> {
    public MiddleElement() {
    }

    /**
     *
     * First method.
     * How to find the middle element through one looping.
     * @param list list.
     * @return middle element.
     */
    public V getMiddleElement(LinkedList<V> list) {
        Iterator<V> iterator = list.iterator();
        int i = 0;
        V value = null;
        while (iterator.hasNext() && i <= (list.size() / 2)) {
            value = iterator.next();
            i++;
        }
        return value;
    }

    /**
     * Second method.
     * How to find the middle element through one looping.
     * @param list list.
     * @return middle element.
     */
    public V getMiddleElementBySlowAndFastPointers(LinkedList<V> list) {
        Iterator<V> slowInt = list.iterator();
        Iterator<V> fastInt = list.iterator();
        V slow = null;

        while (fastInt.hasNext()) {
            fastInt.next();
            if (fastInt.hasNext()) {
                fastInt.next();
            }
            if (slowInt.hasNext()) {
                slow = slowInt.next();
            }
        }

        return slow;
    }
}
