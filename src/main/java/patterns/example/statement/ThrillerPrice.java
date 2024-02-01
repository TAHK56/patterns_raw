package patterns.example.statement;

public class ThrillerPrice extends Price {

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 5D;
    }
}
