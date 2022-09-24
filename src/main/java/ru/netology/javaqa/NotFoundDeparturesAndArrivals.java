package ru.netology.javaqa;

public class NotFoundDeparturesAndArrivals extends RuntimeException {

    public NotFoundDeparturesAndArrivals(String msg) {
        super(msg);
    }
}
