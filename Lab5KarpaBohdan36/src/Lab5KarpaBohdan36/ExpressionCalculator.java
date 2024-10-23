package Lab5KarpaBohdan36;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpressionCalculator {

    private double result; // Змінна для збереження результату обчислення

    // Метод для обчислення виразу y = tg(x) / (3 * x)
    public void calculateExpression(double x) throws ArithmeticException {
        if (x == 0.0) {
            throw new ArithmeticException("Ділення на нуль неможливе (x не може дорівнювати 0)"); // Викидаємо виняток при діленні на нуль
        }
        result = Math.tan(x) / (3.0 * x); // Обчислюємо вираз
    }

    // Метод для отримання результату обчислення
    public double getResult() {
        return result;
    }

    // Метод для запису результату у текстовий файл
    public void writeResTxt(String fName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fName))) {
            writer.printf("Результат: %.18f%n", result); // Використовуємо точність до 18 знаків після коми
        }
    }

    // Метод для читання результату з текстового файлу
    public void readResTxt(String fName) throws IOException {
        try (Scanner scanner = new Scanner(new File(fName))) {
            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble(); // Читаємо значення результату з файлу
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + e.getMessage()); // Обробка винятку, якщо файл не знайдено
        }
    }

    // Метод для запису результату у бінарний файл
    public void writeResBin(String fName) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fName))) {
            dos.writeDouble(result); // Записуємо результат у бінарному форматі
        }
    }

    // Метод для читання результату з бінарного файлу
    public void readResBin(String fName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fName))) {
            result = dis.readDouble(); // Читаємо результат з бінарного файлу
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + e.getMessage()); // Обробка винятку, якщо файл не знайдено
        }
    }

    // Метод для отримання вхідного значення x від користувача
    public double getInput(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введіть значення x: ");
                double input = scanner.nextDouble(); // Зчитуємо введене користувачем значення
                if (input != 0.0) {
                    return input; // Повертаємо значення, якщо воно не дорівнює 0
                }
                System.out.println("Помилка: x не може дорівнювати 0. Спробуйте ще раз.");
            } catch (InputMismatchException e) {
                System.out.println("Помилка: введено некоректне значення. Введіть дійсне число.");
                scanner.next(); // Очищуємо неправильне введення
            }
        }
    }
}
