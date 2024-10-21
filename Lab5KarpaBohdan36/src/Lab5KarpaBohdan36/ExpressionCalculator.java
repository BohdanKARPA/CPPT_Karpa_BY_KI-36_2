package Lab5KarpaBohdan36;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpressionCalculator {

    private double result;

    // Обчислює вираз y = tg(x) / (3 * x)
    public void calculateExpression(double x) throws ArithmeticException {
        if (x == 0.0) {
            throw new ArithmeticException("Ділення на нуль неможливе (x не може дорівнювати 0)");
        }
        result = Math.tan(x) / (3.0 * x);
    }

    public double getResult() {
        return result;
    }

    public void writeResTxt(String fName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fName))) {
            writer.printf("Результат: %f%n", result);
        }
    }

    public void readResTxt(String fName) throws IOException {
        try (Scanner scanner = new Scanner(new File(fName))) {
            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + e.getMessage());
        }
    }

    public void writeResBin(String fName) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fName))) {
            dos.writeDouble(result);
        }
    }

    public void readResBin(String fName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fName))) {
            result = dis.readDouble();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + e.getMessage());
        }
    }

    // Отримує вхідне значення від користувача
    public double getInput(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введіть значення x: ");
                double input = scanner.nextDouble();
                if (input != 0.0) {
                    return input;
                }
                System.out.println("Помилка: x не може дорівнювати 0. Спробуйте ще раз.");
            } catch (InputMismatchException e) {
                System.out.println("Помилка: введено некоректне значення. Введіть дійсне число.");
                scanner.next();
            }
        }
    }
}
