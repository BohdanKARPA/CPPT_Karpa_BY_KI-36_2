import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LAB1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення розміру матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        int size = scanner.nextInt();
        scanner.nextLine();  // Очистити нову лінію після введення числа

        // Введення символу-заповнювача
        System.out.print("Введіть символ-заповнювач: ");
        String fillChar = scanner.nextLine();

        // Перевірка введення одного символу
        if (fillChar.length() != 1) {
            System.out.println("Помилка: ви маєте ввести один символ.");
            return;
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