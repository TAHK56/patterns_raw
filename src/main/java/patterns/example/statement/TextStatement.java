package patterns.example.statement;

import patterns.example.entity.Customer;
import patterns.example.entity.Rental;

public class TextStatement extends Statement {
    @Override
    String header(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    @Override
    String eachRental(Rental rental) {
        return "\t" + rental.movie().getTitle() + "\t" + rental.calculateAmount(rental.daysRented()) + "\n";
    }

    @Override
    String footer(Customer customer) {
        return "Amount owed is " + customer.getTotalAmount() + "\n" +
               "You earned " + customer.getTotalFrequentRenterPoints() + " frequent renter points";
    }
}
