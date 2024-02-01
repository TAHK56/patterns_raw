package patterns.example.statement;

public class DramaPrice extends Price {

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 4D;
    }
}
