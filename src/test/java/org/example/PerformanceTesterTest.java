package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerformanceTesterTest {

    PerformanceTester tester;
    List<Integer> arrayList;
    List<Integer> linkedList;

    @BeforeEach
    void setup() {
        tester = new PerformanceTester();
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        for (int i = 0; i < 2000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @Test
    void testAdd() {
        Assertions.assertTrue(tester.testAdd(arrayList, 2000) > tester.testAdd(linkedList, 2000));
    }

    @Test
    void testRemove() {
        Assertions.assertTrue(tester.testRemove(arrayList, 2000) < tester.testRemove(linkedList, 2000));
    }

    @Test
    void testGet() {
        Assertions.assertTrue(tester.testGet(arrayList, 2000) < tester.testGet(linkedList, 2000));
    }
}
