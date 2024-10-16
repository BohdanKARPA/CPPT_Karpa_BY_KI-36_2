package Lab4KarpaBohdan36;


import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpressionCalculator {
    public ExpressionCalculator() {
    }

    public double calculateExpression(double x) throws ArithmeticException {
        if (x == 0.0) {
            throw new ArithmeticException("Ділення на нуль неможливе (x не може дорівнювати 0)");
        } else {
            return Math.tan(x) / (3.0 * x);
        }
    }

    public void saveResultToFile(double result) {
        try {
            FileWriter writer = new FileWriter("result.txt");

            try {
                writer.write("Результат обчислення: " + result);
                System.out.println("Результат успішно записано у файл.");
            } catch (Throwable var7) {
                try {
                    writer.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            writer.close();
        } catch (IOException var8) {
            IOException e = var8;
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }

    }

    public double getInput(Scanner scanner) {
        while(true) {
            try {
                System.out.print("Введіть значення x: ");
                double input = scanner.nextDouble();
                if (input != 0.0) {
                    return input;
                }

                System.out.println("Помилка: x не може дорівнювати 0. Спробуйте ще раз.");
            } catch (InputMismatchException var4) {
                System.out.println("Помилка: введено некоректне значення. Введіть дійсне число.");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            try {
                ExpressionCalculator calculator = new ExpressionCalculator();

                while(true) {
                    double x = calculator.getInput(scanner);

                    try {
                        double result = calculator.calculateExpression(x);
                        System.out.println("Результат для x = " + x + ": " + result);
                        calculator.saveResultToFile(result);
                        break;
                    } catch (ArithmeticException var8) {
                        ArithmeticException e = var8;
                        System.out.println("Помилка: " + e.getMessage());
                    }
                }
            } catch (Throwable var9) {
                try {
                    scanner.close();
                } catch (Throwable var7) {
                    var9.addSuppressed(var7);
                }

                throw var9;
            }

            scanner.close();
        } catch (Exception var10) {
            Exception e = var10;
            System.out.println("Невідома помилка: " + e.getMessage());
        }

    }
}

