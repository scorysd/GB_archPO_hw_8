package ru.geekbrains.lesson8.models;

import java.util.Date;

public class Reservation {


    public int getId() {
        return id;
    }

    private static int counter = 1000;
    private final int id;

    private Table table;

    private Date date;
    private String name;

    {
        id = ++counter;
    }

    public Reservation(Table table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
    }
}
