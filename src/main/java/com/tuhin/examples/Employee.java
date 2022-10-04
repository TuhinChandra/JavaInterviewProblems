package com.tuhin.examples;

import java.time.LocalDate;

public class Employee {
    String name;
    LocalDate date;

    public Employee(final String name, final LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
