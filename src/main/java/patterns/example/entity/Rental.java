package patterns.example.entity;

public record Rental(Movie movie, int daysRented) {

    public double calculateAmount(int daysRented) {
        return movie.calculateAmount(daysRented);
    }

    public int calculateRenterPoints(int daysRented) {
        return movie.calculateRenterPoints(daysRented);
    }
}
