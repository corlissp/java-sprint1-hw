public class Converter {
    double getLength(int steps) {
        double kilometers = (steps * 0.75) / 1000;
        return kilometers;
    }
    double getCalories(int steps) {
        double kilocalories = (steps * 50) / 1000;
        return kilocalories;
    }
}
