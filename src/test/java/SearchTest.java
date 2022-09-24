import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Manager;
import ru.netology.javaqa.NotFoundDeparturesAndArrivals;
import ru.netology.javaqa.Repository;
import ru.netology.javaqa.Ticket;

public class SearchTest {

    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    Ticket ticket1 = new Ticket(1, 10000, "LHR", "PRX", 120);
    Ticket ticket2 = new Ticket(22, 25000, "PRX", "JFK", 600);
    Ticket ticket3 = new Ticket(56, 5000, "ISL", "MLN", 200);
    Ticket ticket4 = new Ticket(59, 21000, "JFK", "MLN", 700);
    Ticket ticket5 = new Ticket(156, 10000, "LHR", "PRX", 120);
    Ticket ticket6 = new Ticket(358, 30000, "JFK", "MLN", 700);
    Ticket ticket7 = new Ticket(875, 18000, "JFK", "MLN", 700);
    Ticket ticket8 = new Ticket(47, 6000, "ISL", "MLN", 200);

    @Test
    public void shouldReturnOneResultFromManyItems() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("LHR", "PRX");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnManyResultsFromManyItemsWhenPriceEqual() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Ticket[] expected = {ticket1, ticket5};
        Ticket[] actual = manager.findAll("LHR", "PRX");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnManyResultsFromManyItemsSortedByPrice() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] expected = {ticket7, ticket4, ticket6};
        Ticket[] actual = manager.findAll("JFK", "MLN");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnOneResultFromOneItem() {
        manager.add(ticket1);
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("LHR", "PRX");
    }

    @Test
    public void shouldReturnExceptionFromNoItems() {
        Assertions.assertThrows(NotFoundDeparturesAndArrivals.class, () -> {
            manager.findAll("LHR", "PRX");
        });
    }

    @Test
    public void shouldReturnExceptionFromOneItemIfNoSuchDepartures() {
        manager.add(ticket1);
        Assertions.assertThrows(NotFoundDeparturesAndArrivals.class, () -> {
            manager.findAll("PRX", "PRX");
        });
    }

    @Test
    public void shouldReturnExceptionFromOneItemIfNoSuchArrivals() {
        manager.add(ticket3);
        Assertions.assertThrows(NotFoundDeparturesAndArrivals.class, () -> {
            manager.findAll("ISL", "PRX");
        });
    }

    @Test
    public void shouldReturnExceptionFromOneItemIfNoSuchDeparturesAndArrivals() {
        manager.add(ticket5);
        Assertions.assertThrows(NotFoundDeparturesAndArrivals.class, () -> {
            manager.findAll("JFK", "ISL");
        });
    }

    @Test
    public void shouldReturnExceptionFromManyItemsIfNoSuchDepartures() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Assertions.assertThrows(NotFoundDeparturesAndArrivals.class, () -> {
            manager.findAll("MLN", "PRX");
        });
    }

    @Test
    public void shouldReturnExceptionFromManyItemsIfNoSuchArrivals() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Assertions.assertThrows(NotFoundDeparturesAndArrivals.class, () -> {
            manager.findAll("JFK", "ISL");
        });
    }

    @Test
    public void shouldReturnExceptionFromManyItemsIfNoSuchDeparturesAndArrivals() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Assertions.assertThrows(NotFoundDeparturesAndArrivals.class, () -> {
            manager.findAll("SYD", "BER");
        });
    }


}
