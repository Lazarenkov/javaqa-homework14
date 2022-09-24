package ru.netology.javaqa;

import java.lang.reflect.Array;

public class Repository {

    Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        int i = 0;
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (Ticket item : tickets) {
            tmp[i] = item;
            i++;
        }
        tmp[tickets.length] = ticket;
        tickets = tmp;
    }

    public Ticket[] getItems() {
        return tickets;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundIdException("Элемент с id" + id + "не найден.");
        }
        Ticket[] result = new Ticket[0];
        int i = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                Ticket[] tmp = new Ticket[i + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[i] = ticket;
                result = tmp;
                i++;
            }
        }
        tickets = result;
    }

    private Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket findByDeparturesAndArrivals(String from, String to) {
        for (Ticket ticket : tickets) {
            if (ticket.getDeparture().equals(from) & ticket.getArrive().equals(to)) {
                return ticket;
            }
        }
        return null;
    }


}
