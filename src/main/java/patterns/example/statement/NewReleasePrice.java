package patterns.example.statement;

public class NewReleasePrice extends Price {
    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 3D;
    }

    @Override
    public int calculateRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
