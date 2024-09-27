package Lab2KarpaBohdan36;

import java.io.*;
import java.util.Scanner;

public class PlantDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення кількості рослин від користувача
        System.out.println("Введіть кількість рослин:");
        int plantCount = scanner.nextInt();
        scanner.nextLine(); // очищуємо лінію після вводу числа

        // Створюємо рослини на основі кількості, введеної користувачем
        Plant[] plants = new Plant[plantCount];

        for (int i = 0; i < plantCount; i++) {
            System.out.println("\nСтворюється рослина " + (i + 1) + ":");
            plants[i] = createPlant(scanner);
            System.out.println(plants[i].getDescription());
        }

        // Основне меню для роботи з рослиною
        boolean exit = false;
        while (!exit) {
            System.out.println("\nОберіть рослину для редагування (1-" + plantCount + ") або 0 для виходу:");
            int plantIndex = scanner.nextInt();
            if (plantIndex == 0) {
                exit = true;
                continue;
            }
            if (plantIndex < 1 || plantIndex > plantCount) {
                System.out.println("Невірний номер рослини. Спробуйте ще раз.");
                continue;
            }

            Plant selectedPlant = plants[plantIndex - 1];

            // Підменю для редагування обраної рослини
            boolean editMenu = true;
            while (editMenu) {
                System.out.println("\nОберіть дію:\n" +
                        "1. Змінити тип кореня\n" +
                        "2. Змінити висоту стебла\n" +
                        "3. Змінити форму листя\n" +
                        "4. Показати опис рослини\n" +
                        "5. Вийти до основного меню");

                int action = scanner.nextInt();
                scanner.nextLine(); // очищуємо лінію після вводу числа

                switch (action) {
                    case 1:
                        System.out.println("Оберіть новий тип кореня:");
                        String newRootType = selectRootType(scanner); // Викликаємо метод для вибору
                        selectedPlant.changeRootType(newRootType);
                        break;
                    case 2:
                        System.out.println("Введіть нову висоту стебла (в см):");
                        double newStemHeight = scanner.nextDouble();
                        selectedPlant.changeStemHeight(newStemHeight);
                        break;
                    case 3:
                        System.out.println("Оберіть нову форму листя:");
                        String newLeafShape = selectLeafShape(scanner); // Викликаємо метод для вибору
                        selectedPlant.changeLeafShape(newLeafShape);
                        break;
                    case 4:
                        System.out.println(selectedPlant.getDescription());
                        break;
                    case 5:
                        editMenu = false; // Вихід до основного меню
                        break;
                    default:
                        System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
            }
        }

        // Завершуємо роботу з файлом логів для останньої рослини
        if (plantCount > 0) {
            plants[plantCount - 1].closeLog();
        }

        // Закриваємо сканер
        scanner.close();
    }

    /**
     * Метод для створення рослини за введеними користувачем даними.
     *
     * @param scanner Об'єкт Scanner для читання введення користувача.
     * @return Об'єкт класу Plant з введеними характеристиками.
     */
    private static Plant createPlant(Scanner scanner) {
        // Вибір характеристик для кожної рослини
        System.out.println("Виберіть тип кореня:");
        String rootType = selectRootType(scanner);

        System.out.println("Введіть висоту стебла (в сантиметрах):");
        double stemHeight = scanner.nextDouble();
        scanner.nextLine(); // очищуємо лінію після вводу числа

        System.out.println("Виберіть форму листя:");
        String leafShape = selectLeafShape(scanner);

        Root root = new Root(rootType);
        Stem stem = new Stem(stemHeight);
        Leaves leaves = new Leaves(leafShape);

        return new Plant(root, stem, leaves);
    }

    /**
     * Метод для вибору типу кореня з меню.
     *
     * @param scanner Об'єкт Scanner для читання введення користувача.
     * @return Вибраний тип кореня.
     */
    public static String selectRootType(Scanner scanner) {
        int choice;
        do {
            System.out.println("1. Мочкуватий\n2. Стрижневий");
            while (!scanner.hasNextInt()) {
                System.out.println("Невірний ввід. Введіть число 1 або 2:");
                scanner.next(); // очищуємо неправильний ввід
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // очищуємо лінію після вводу числа
            if (choice != 1 && choice != 2) {
                System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice != 1 && choice != 2);

        return (choice == 1) ? "мочкуватий" : "стрижневий";
    }

    /**
     * Метод для вибору форми листя з меню.
     *
     * @param scanner Об'єкт Scanner для читання введення користувача.
     * @return Вибрана форма листя.
     */
    public static String selectLeafShape(Scanner scanner) {
        int choice;
        do {
            System.out.println("1. Ланцетоподібна\n2. Яйцеподібна\n3. Кругла");
            while (!scanner.hasNextInt()) {
                System.out.println("Невірний ввід. Введіть число 1, 2 або 3:");
                scanner.next(); // очищуємо неправильний ввід
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // очищуємо лінію після вводу числа
            if (choice < 1 || choice > 3) {
                System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1:
                return "ланцетоподібна";
            case 2:
                return "яйцеподібна";
            case 3:
                return "кругла";
            default:
                return "невідома"; // Не повинен досягатися
        }
    }
}
