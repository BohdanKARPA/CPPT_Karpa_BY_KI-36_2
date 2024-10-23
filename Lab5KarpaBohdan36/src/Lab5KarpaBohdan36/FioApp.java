package Lab5KarpaBohdan36;

import java.io.IOException;
import java.util.Scanner;

public class FioApp {

    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator(); // Створюємо об'єкт калькулятора виразів
        Scanner scanner = new Scanner(System.in); // Створюємо об'єкт для зчитування даних від користувача

        try (scanner) {
            // Отримуємо вхідне значення x від користувача
            double x = calculator.getInput(scanner);

            // Обчислюємо вираз на основі введеного x
            calculator.calculateExpression(x);

            // Виводимо результат обчислення на екран
            System.out.println("Результат для x = " + x + ": " + calculator.getResult());

            // Записуємо результати обчислень у текстовий та бінарний файли
            calculator.writeResTxt("textRes.txt");
            calculator.writeResBin("BinRes.bin");

            // Читаємо результати з файлів і виводимо на екран
            calculator.readResBin("BinRes.bin");
            System.out.println("Результат з двійкового файлу: " + calculator.getResult());
            calculator.readResTxt("textRes.txt");
            System.out.println("Результат з текстового файлу: " + calculator.getResult());

        } catch (ArithmeticException e) {
            // Обробка виключення, що виникає при діленні на нуль
            System.out.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            // Обробка виключення, що виникає при помилках вводу/виводу
            System.out.println("Помилка вводу/виводу: " + e.getMessage());
        }
    }
}
