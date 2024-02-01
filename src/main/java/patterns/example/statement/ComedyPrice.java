package patterns.example.statement;

public class ComedyPrice extends Price {

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 4D;
    }
}
