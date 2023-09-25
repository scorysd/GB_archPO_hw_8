package ru.geekbrains.lesson8.models;

import ru.geekbrains.lesson8.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import static java.lang.Thread.sleep;

public class TableModel implements Model {


    private Collection<Table> tables;
    private Collection<Reservation> reservations;

    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables(){

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table: tables) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика. Повторите попытку позже.");
    }

    /**
     * TODO: Доработать самостоятельнов рамках домашней работы
     * @param oldReservation
     * @param reservationDate
     * @param tableNo
     * @param name
     * @return
     */
    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name)   {
        for (Table table : tables) {
            reservations = table.getReservations();
            for (Reservation res : reservations) {
                if (res.getId() == oldReservation) {
                    System.out.println("Бронь найдена... Удаляю...");
//                    reservations.remove(res);
                    reservationTable(reservationDate, tableNo, name);
                }
            }
        }
//        throw new RuntimeException("Ошибка. Бронирование с указанным номером отсутствует!");
        return reservationTable(reservationDate, tableNo, name);
    }

}
