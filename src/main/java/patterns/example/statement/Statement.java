package patterns.example.statement;

import patterns.example.entity.Customer;
import patterns.example.entity.Rental;

public abstract class Statement {

    public String value(Customer customer) {
        var rentals = customer.getRentals();
        StringBuilder result = new StringBuilder(header(customer));
        for (Rental rental : rentals) {
            result.append(eachRental(rental));
        }
        result.append(footer(customer));
        return result.toString();
    }

    abstract String header(Customer customer);

    abstract String eachRental(Rental rental);

    abstract String footer(Customer customer);
}
