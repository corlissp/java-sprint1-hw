public class Converter {
    double getLength(int steps) {
        double metersByStep = 0.75;
        double kilometers = (steps * metersByStep) / 1000;
        return kilometers;
    }
    double getCalories(int steps) {
        double caloriesByStep = 50;
        double kilocalories = (steps * caloriesByStep) / 1000;
        return kilocalories;
    }
}
