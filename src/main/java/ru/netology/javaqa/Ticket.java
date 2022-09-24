package ru.netology.javaqa;

import org.jetbrains.annotations.NotNull;

public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected long price;
    protected String departure;
    protected String arrive;

    protected long flightTime;

    public Ticket(int id, long price, String departure, String arrive, long flightTime) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrive = arrive;
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(@NotNull Ticket o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price < o.price) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getId() {
        return id;
    }


    public String getArrive() {
        return arrive;
    }

    public String getDeparture() {
        return departure;
    }

}
