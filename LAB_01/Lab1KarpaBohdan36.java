import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1KarpaBohdan36 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення розміру матриці
        int size = getMatrixSize(scanner);

        // Введення символу-заповнювача
        String fillChar = getFillCharacter(scanner);

        // Створення зубчастого масиву
        char[][] jaggedArray = createJaggedArray(size, fillChar);

        // Виведення масиву на екран
        printJaggedArray(jaggedArray);

        // Запис масиву у файл
        saveJaggedArrayToFile(jaggedArray);
    }

    // Метод для введення розміру матриці
    private static int getMatrixSize(Scanner scanner) {
        int size = 0;
        boolean validInput = false;
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
                scanner.next(); // Очищення некоректного вводу
            }
        }
        scanner.nextLine();  // Очищення буфера після введення числа
        return size;
    }

    // Метод для введення символу-заповнювача
    private static String getFillCharacter(Scanner scanner) {
        String fillChar = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Введіть символ-заповнювач: ");
            fillChar = scanner.nextLine();
            if (fillChar.length() != 1) {
                System.out.println("Помилка: ви маєте ввести один символ.");
            } else {
                validInput = true;
            }
        }
        return fillChar;
    }

    // Метод для створення зубчастого масиву
    private static char[][] createJaggedArray(int size, String fillChar) {
        char[][] jaggedArray = new char[size][];
        for (int i = 0; i < size; i++) {
            jaggedArray[i] = new char[size - i];
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = fillChar.charAt(0);
            }
        }
        return jaggedArray;
    }

    // Метод для виведення масиву на екран
    private static void printJaggedArray(char[][] jaggedArray) {
        System.out.println("Сформований масив:");
        for (char[] row : jaggedArray) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    // Метод для запису масиву у файл
    private static void saveJaggedArrayToFile(char[][] jaggedArray) {
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
