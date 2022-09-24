package ru.netology.javaqa;

import java.util.Arrays;

public class Manager {

    Repository repository = new Repository();

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        if (repository.findByDeparturesAndArrivals(from, to) == null) {
            throw new NotFoundDeparturesAndArrivals("Не найдено билетов");
        }
        Ticket[] result = new Ticket[0];
        int i = 0;
        for (Ticket ticket : repository.getItems()) {
            if (ticket.getDeparture().equals(from) & ticket.getArrive().equals(to)) {
                Ticket[] tmp = new Ticket[i + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[i] = ticket;
                result = tmp;
                i++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
