package patterns.example.statement;

public abstract class Price {

    public abstract double calculateAmount(int daysRented);

    public int calculateRenterPoints(int daysRented) {
        return 1;
    }
}
