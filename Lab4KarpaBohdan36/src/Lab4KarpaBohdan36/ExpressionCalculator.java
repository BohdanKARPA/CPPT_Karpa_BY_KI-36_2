package Lab4KarpaBohdan36;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpressionCalculator {

    // Метод для обчислення виразу y = tg(x) / (3 * x)
    public double calculateExpression(double x) throws ArithmeticException {
        if (x == 0) {
            throw new ArithmeticException("Ділення на нуль неможливе (x не може дорівнювати 0)");
        }
        return Math.tan(x) / (3 * x);
    }

    // Метод для запису результату у файл
    public void saveResultToFile(double result) {
        try (FileWriter writer = new FileWriter("result.txt")) {
            writer.write("Результат обчислення: " + result);
            System.out.println("Результат успішно записано у файл.");
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    // Метод для отримання вхідного значення від користувача
    public double getInput(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введіть значення x: ");
                double input = scanner.nextDouble();  // Повертаємо введене число
                if (input == 0) {
                    System.out.println("Помилка: x не може дорівнювати 0. Спробуйте ще раз.");
                } else {
                    return input;  // Повертаємо правильне введене число
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка: введено некоректне значення. Введіть дійсне число.");
                scanner.next();  // Очищуємо некоректний ввід
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {  // Сканер автоматично закривається
            ExpressionCalculator calculator = new ExpressionCalculator();

            while (true) {  // Цикл для повторного введення
                double x = calculator.getInput(scanner);  // Отримуємо введене значення від користувача

                try {
                    // Обчислюємо вираз
                    double result = calculator.calculateExpression(x);
                    System.out.println("Результат для x = " + x + ": " + result);

                    // Записуємо результат у файл
                    calculator.saveResultToFile(result);
                    break;  // Вихід з циклу, якщо все пройшло успішно
                } catch (ArithmeticException e) {
                    System.out.println("Помилка: " + e.getMessage());  // Обробляємо арифметичні помилки
                }
            }
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());  // Обробляємо інші можливі виключення
        }
    }
}
