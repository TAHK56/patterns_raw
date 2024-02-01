package patterns.example.entity;


import patterns.example.statement.Statement;
import patterns.example.statement.TextStatement;

import java.util.List;


public class Customer implements BaseEntity {
    private final String name;
    private final List<Rental> rentals;

    private Statement statement = new TextStatement();

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }


    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public String statement() {
       return statement.value(this);
    }

    public double getTotalAmount() {
        return rentals.stream()
                .mapToDouble(rental -> rental.calculateAmount(rental.daysRented()))
                .sum();
    }

    public int getTotalFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(rental -> rental.calculateRenterPoints(rental.daysRented()))
                .sum();
    }

    @Override
    public String toString() {
        return "Customer{" +
               "name='" + name + '\'' +
               ", rentals=" + rentals +
               '}';
    }
}