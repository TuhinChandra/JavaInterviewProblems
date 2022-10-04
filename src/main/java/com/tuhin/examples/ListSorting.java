package com.tuhin.examples;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListSorting {

    public static void main(final String[] args) {
        final Employee e1 = new Employee("A", LocalDate.now().minusDays(1));
        final Employee e2 = new Employee("B", LocalDate.now().minusDays(2));
        final Employee e3 = new Employee("C", LocalDate.now().minusDays(3));
        final Employee e4 = new Employee("D", LocalDate.now().minusDays(4));
        final List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e4);
        list.add(e3);
        list.add(e2);
        System.out.println(list);
        list.sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        System.out.println(list);
    }
}


