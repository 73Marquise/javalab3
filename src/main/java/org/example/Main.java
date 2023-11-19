package org.example;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        PerformanceTester tester = new PerformanceTester();

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 2000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("Метод\t\t\t\t\tКоличество вызовов\t\tВремя выполнения (нс)");
        System.out.println("add (ArrayList)\t\t\t2000\t\t\t\t\t" + tester.testAdd(arrayList, 2000));
        System.out.println("add (LinkedList)\t\t2000\t\t\t\t\t" + tester.testAdd(linkedList, 2000));
        System.out.println("remove (ArrayList)\t\t2000\t\t\t\t\t" + tester.testRemove(arrayList, 2000));
        System.out.println("remove (LinkedList)\t\t2000\t\t\t\t\t" + tester.testRemove(linkedList, 2000));
        System.out.println("get (ArrayList)\t\t\t2000\t\t\t\t\t" + tester.testGet(arrayList, 2000));
        System.out.println("get (LinkedList)\t\t2000\t\t\t\t\t" + tester.testGet(linkedList, 2000));
    }
}