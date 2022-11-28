import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        StepTracker stepTracker = new StepTracker();
        int userInput = scanner.nextInt();
        while (userInput != 4) {
            if (userInput == 1) {
                stepTracker.addSteps();
            } else if (userInput == 2) {
                stepTracker.statsMonth();
            } else if (userInput == 3) {
                stepTracker.changeTarget();
            } else if (userInput == 4) {
                System.out.println("Выход из приложения...");
                break;
            } else {
                System.out.println("Неверная команда!");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена.");
    }

    public static void printMenu() {
        System.out.println("===================================================");
        System.out.println("\tМеню");
        System.out.println("1. Ввести количество шагов за определённый день.");
        System.out.println("2. Напечатать статистику за определённый месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("4. Выйти из приложения.");
        System.out.print("Ввод: ");
    }

}

