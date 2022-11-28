import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    int[][] stepsTable = new int[12][30];
    int target = 10000;

    void changeTarget() {
        System.out.print("Введите новую цель: ");
        int newTarget = scanner.nextInt();
        if (newTarget < 0) {
            System.out.println("Неверная команда!");
            return;
        }
        target = newTarget;
    }

    void addSteps() {
        printMonth();
        int monthInput = scanner.nextInt();
        if (monthInput < 1 || monthInput > 12) {
            System.out.println("Неверная команда!");
            return;
        }
        System.out.println("Введите число месяца от 1 до 30");
        System.out.print("День: ");
        int dayInput = scanner.nextInt();
        if (dayInput < 1 || dayInput > 30) {
            System.out.println("Неверная команда!");
            return;
        }
        System.out.print("Введите кол-во шагов: ");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Неверная команда!");
            return;
        }
        stepsTable[monthInput - 1][dayInput - 1] = steps;
    }

    void statsMonth() {
        printMonth();
        Converter converter = new Converter();
        int monthInput = scanner.nextInt();
        if (monthInput < 1 || monthInput > 12) {
            System.out.println("Неверная команда!");
            return;
        }
        for (int j = 0; j < 30; j++) {
            System.out.println("День " + (j + 1) + ": " + stepsTable[monthInput - 1][j]);
        }
        System.out.println("Всего за месяц: " + stepsSum(monthInput));
        System.out.println("Максимально за месяц: " + stepsMax(monthInput));
        System.out.println(("Среднее за день: " + stepsSum(monthInput) / 30));
        System.out.println("Пройденная дистанция: " + converter.getLength(stepsSum(monthInput)) + " км");
        System.out.println("Сожжжено " + converter.getCalories(stepsSum(monthInput)) + " килокалорий");
        System.out.println("Лучшая серия: " + maxLongSeries(monthInput));
    }

    int maxLongSeries(int mouth) {
        int series = 0;
        int maxLong = series;
        for (int j = 0; j < 30; j++) {
            if (stepsTable[mouth - 1][j] >= target) {
                if (series == 0 || stepsTable[mouth - 1][j - 1] >= target)
                    series++;
            } else {
                series = 0;
            }
            if (maxLong < series)
                maxLong = series;
        }
        return maxLong;
    }

    int stepsSum(int month) {
        int sum = 0;
        for (int j = 0; j < 30; j++)
            sum = sum + stepsTable[month - 1][j];
        return sum;
    }

    int stepsMax(int month) {
        int max = stepsTable[month - 1][0];
        for (int j = 0; j < 30; j++) {
            if (stepsTable[month - 1][j] > max)
                max = stepsTable[month - 1][j];
        }
        return max;
    }

    void printMonth() {
        System.out.println("\tВыберите месяц.");
        System.out.println("1. Январь.");
        System.out.println("2. Февраль.");
        System.out.println("3. Март.");
        System.out.println("4. Апрель.");
        System.out.println("5. Май.");
        System.out.println("6. Июнь.");
        System.out.println("7. Июль.");
        System.out.println("8. Август.");
        System.out.println("9. Сентябрь.");
        System.out.println("10. Октябрь.");
        System.out.println("11. Ноябрь.");
        System.out.println("12. Декабрь.");
        System.out.print("Месяц: ");
    }
}
