package patterns.example.statement;

import patterns.example.entity.Customer;
import patterns.example.entity.Rental;

public class HtmlStatement extends Statement {
    @Override
    String header(Customer customer) {
        String begin = """
                <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="utf-8">
                    <title>rental</title>
                </head>
                <body>
                    <header>
                """;
        return begin + "<h1>Rental Record for " + customer.getName() + "</h1></header>\n";
    }

    @Override
    String eachRental(Rental rental) {
        return rental.movie().getTitle() + ": " + rental.calculateAmount(rental.daysRented()) + "<br>\n";
    }

    @Override
    String footer(Customer customer) {
        return "<footer><p>Amount owed is " + customer.getTotalAmount() + "</p>\n" +
               "<p>You earned " + customer.getTotalFrequentRenterPoints() +
               " frequent renter points</p></footer></body></html>";
    }
}
