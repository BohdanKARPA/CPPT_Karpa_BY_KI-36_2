package Lab5KarpaBohdan36;

import java.io.IOException;
import java.util.Scanner;

public class FioApp {

    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            double x = calculator.getInput(scanner);
            calculator.calculateExpression(x);
            System.out.println("Результат для x = " + x + ": " + calculator.getResult());

            // Запис результатів у файли
            calculator.writeResTxt("textRes.txt");
            calculator.writeResBin("BinRes.bin");

            // Читання результатів з файлів і виведення на екран
            calculator.readResBin("BinRes.bin");
            System.out.println("Результат з двійкового файлу: " + calculator.getResult());
            calculator.readResTxt("textRes.txt");
            System.out.println("Результат з текстового файлу: " + calculator.getResult());

        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка вводу/виводу: " + e.getMessage());
        }
    }
}
