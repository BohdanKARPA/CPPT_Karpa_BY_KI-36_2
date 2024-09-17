import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1KarpaBohdan36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        boolean validInput = false;

        // Введення розміру матриці
        while (!validInput) {
            System.out.print("Введіть розмір квадратної матриці: ");
            try {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Помилка: розмір матриці має бути додатним числом.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка: введіть числове значення.");
                scanner.next(); // Очищення невірного вводу
            }
        }
        scanner.nextLine();  // Очистити нову лінію після введення числа

        // Ініціалізація змінної fillChar порожнім рядком
        String fillChar = "";

        // Введення символу-заповнювача з перевіркою
        validInput = false;
        while (!validInput) {
            System.out.print("Введіть символ-заповнювач: ");
            fillChar = scanner.nextLine();
            if (fillChar.length() != 1) {
                System.out.println("Помилка: ви маєте ввести один символ.");
            } else {
                validInput = true;
            }
        }

        // Створення зубчастого масиву
        char[][] jaggedArray = new char[size][];

        for (int i = 0; i < size; i++) {
            jaggedArray[i] = new char[size - i];
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = fillChar.charAt(0);
            }
        }

        // Виведення на екран
        System.out.println("Сформований масив:");
        for (char[] row : jaggedArray) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }

        // Запис у текстовий файл
        try (FileWriter writer = new FileWriter("jagged_array.txt")) {
            for (char[] row : jaggedArray) {
                for (char element : row) {
                    writer.write(element);
                }
                writer.write(System.lineSeparator());
            }
            System.out.println("Масив успішно записано у файл jagged_array.txt");
        } catch (IOException e) {
            System.out.println("Сталася помилка під час запису у файл.");
            e.printStackTrace();
        }
    }
}
