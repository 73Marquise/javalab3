package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerformanceTester {

    /**
     * testing the add method. Executes this method the specified number of times
     * @param list test list
     * @param iterations number of iterations
     * @return method execution time. returns 0 if the list is empty
     */
    public long testAdd(List<Integer> list, int iterations) {
        if (list.isEmpty()) {
            return 0;
        }
        List<Integer> copy = getCopy(list);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            copy.add(i);
        }
        return System.nanoTime() - startTime;
    }

    /**
     * testing the remove method. Executes this method the specified number of times
     * @param list test list
     * @param iterations number of iterations
     * @return method execution time. returns 0 if the list is empty
     */
    public long testRemove(List<Integer> list, int iterations) {
        if (list.isEmpty()) {
            return 0;
        }
        List<Integer> copy = getCopy(list);
        setSize(copy, iterations);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            copy.remove(copy.size() / 2);
        }
        return System.nanoTime() - startTime;
    }

    /**
     * testing the get method. Executes this method the specified number of times
     * @param list test list
     * @param iterations number of iterations
     * @return method execution time. returns 0 if the list is empty
     */
    public long testGet(List<Integer> list, int iterations) {
        if (list.isEmpty()) {
            return 0;
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.get(list.size() / 2);
        }
        return System.nanoTime() - startTime;
    }

    /**
     * filling the list if the size is insufficient
     * @param list test list
     * @param size right size
     */
    private void setSize(List<Integer> list, int size) {
        for (int i = list.size(); i < size; i++) {
            list.add(i);
        }
    }

    /**
     * obtaining a copy of the list depending on its implementation.
     * We need a copy so the original list doesn't change
     * @param list test list
     * @return copy of test list
     */
    private List<Integer> getCopy(List<Integer> list) {
        List<Integer> copy = null;
        if (list.getClass().equals(ArrayList.class)) {
            copy = new ArrayList<>(list);
        } else if (list.getClass().equals(LinkedList.class)) {
            copy = new LinkedList<>(list);
        }
        return copy;
    }
}
