package Lab3KarpaBohdan36;

import java.io.*;
import java.util.Scanner;

public class PlantDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запитуємо у користувача кількість дерев з перевіркою
        int treeCount = inputValidTreeCount(scanner);

        Tree[] trees = new Tree[treeCount];

        // Створюємо дерева на основі вводу користувача
        for (int i = 0; i < treeCount; i++) {
            System.out.println("\nСтворюється дерево " + (i + 1) + ":");
            trees[i] = createTree(scanner);
            System.out.println(trees[i].getDescription());
        }

        // Зберігаємо інформацію про дерева у файл
        saveTreesToFile(trees, "trees.txt");

        // Основне меню для роботи з деревами
        boolean exit = false;
        while (!exit) {
            System.out.println("\nОберіть дерево для редагування (1-" + treeCount + ") або 0 для виходу:");
            int treeIndex = scanner.nextInt();
            if (treeIndex == 0) {
                exit = true;
                continue;
            }
            if (treeIndex < 1 || treeIndex > treeCount) {
                System.out.println("Невірний номер дерева. Спробуйте ще раз.");
                continue;
            }

            Tree selectedTree = trees[treeIndex - 1];

            // Підменю для редагування обраного дерева
            boolean editMenu = true;
            while (editMenu) {
                System.out.println("\nОберіть дію:\n" +
                        "1. Змінити тип кореня\n" +
                        "2. Змінити висоту стебла\n" +
                        "3. Змінити форму листя\n" +
                        "4. Змінити тип дерева\n" +
                        "5. Показати опис дерева\n" +
                        "6. Виростити дерево\n" +
                        "7. Вийти до основного меню");

                int action = scanner.nextInt();
                scanner.nextLine(); // Очищуємо лінію після вводу числа

                switch (action) {
                    case 1:
                        System.out.println("Оберіть новий тип кореня:");
                        String newRootType = selectRootType(scanner);
                        selectedTree.getRoot().setRootType(newRootType);
                        break;
                    case 2:
                        System.out.println("Введіть нову висоту стебла (в см):");
                        double newStemHeight = inputValidHeight(scanner);
                        selectedTree.getStem().setHeight(newStemHeight);
                        break;
                    case 3:
                        System.out.println("Оберіть нову форму листя:");
                        String newLeafShape = selectLeafShape(scanner);
                        selectedTree.getLeaves().setLeafShape(newLeafShape);
                        break;
                    case 4:
                        System.out.println("Оберіть новий тип дерева:");
                        String newTreeType = selectTreeType(scanner);
                        selectedTree.setTreeType(newTreeType);
                        break;
                    case 5:
                        System.out.println(selectedTree.getDescription());
                        break;
                    case 6:
                        System.out.println("Введіть кількість сантиметрів, на яку дерево виросте:");
                        double growAmount = inputValidHeight(scanner);
                        selectedTree.grow(growAmount);
                        break;
                    case 7:
                        editMenu = false;
                        break;
                    default:
                        System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
            }

            // Оновлюємо файл після змін
            saveTreesToFile(trees, "trees.txt");
        }

        scanner.close(); // Закриваємо сканер після завершення роботи
    }

    /**
     * Метод для перевірки кількості дерев, яка повинна бути більше 0.
     * @param scanner Сканер для отримання вводу від користувача.
     * @return Кількість дерев.
     */
    public static int inputValidTreeCount(Scanner scanner) {
        int treeCount;
        do {
            System.out.println("Введіть кількість дерев (більше 0):");
            while (!scanner.hasNextInt()) {
                System.out.println("Невірний ввід. Введіть ціле число:");
                scanner.next();
            }
            treeCount = scanner.nextInt();
            if (treeCount <= 0) {
                System.out.println("Кількість дерев повинна бути більше 0. Спробуйте ще раз.");
            }
        } while (treeCount <= 0);
        return treeCount;
    }

    /**
     * Метод для створення нового дерева на основі вводу користувача.
     * @param scanner Сканер для отримання вводу від користувача.
     * @return Нове дерево.
     */
    private static Tree createTree(Scanner scanner) {
        System.out.println("Виберіть тип кореня:");
        String rootType = selectRootType(scanner);

        System.out.println("Введіть висоту стебла (в сантиметрах):");
        double stemHeight = inputValidHeight(scanner);

        System.out.println("Виберіть форму листя:");
        String leafShape = selectLeafShape(scanner);

        System.out.println("Оберіть тип дерева:");
        String treeType = selectTreeType(scanner);

        Root root = new Root(rootType);
        Stem stem = new Stem(stemHeight);
        Leaves leaves = new Leaves(leafShape);

        return new Tree(root, stem, leaves, treeType);
    }

    /**
     * Метод для вводу дійсного числа, яке представляє висоту.
     * @param scanner Сканер для отримання вводу від користувача.
     * @return Введена висота, яка є невід'ємним числом.
     */
    public static double inputValidHeight(Scanner scanner) {
        double height;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Невірний ввід. Введіть число:");
                scanner.next();
            }
            height = scanner.nextDouble();
            if (height < 0) {
                System.out.println("Висота не може бути від'ємною. Введіть коректне значення.");
            }
        } while (height < 0);
        scanner.nextLine(); // Очищуємо лінію після вводу
        return height;
    }

    /**
     * Метод для вибору типу кореня з можливих варіантів.
     * @param scanner Сканер для отримання вводу від користувача.
     * @return Вибраний тип кореня.
     */
    public static String selectRootType(Scanner scanner) {
        int choice;
        do {
            System.out.println("1. Мочкуватий\n2. Стрижневий");
            while (!scanner.hasNextInt()) {
                System.out.println("Невірний ввід. Введіть число 1 або 2:");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice != 1 && choice != 2) {
                System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice != 1 && choice != 2);

        return (choice == 1) ? "мочкуватий" : "стрижневий";
    }

    /**
     * Метод для вибору форми листя з можливих варіантів.
     * @param scanner Сканер для отримання вводу від користувача.
     * @return Вибрана форма листя.
     */
    public static String selectLeafShape(Scanner scanner) {
        int choice;
        do {
            System.out.println("1. Ланцетоподібна\n2. Яйцеподібна\n3. Кругла");
            while (!scanner.hasNextInt()) {
                System.out.println("Невірний ввід. Введіть число 1, 2 або 3:");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
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
                return "невідома";
        }
    }

    /**
     * Метод для вибору типу дерева з можливих варіантів.
     * @param scanner Сканер для отримання вводу від користувача.
     * @return Вибраний тип дерева.
     */
    public static String selectTreeType(Scanner scanner) {
        int choice;
        do {
            System.out.println("1. Яблуня\n2. Груша\n3. Слива\n4. Абрикос");
            while (!scanner.hasNextInt()) {
                System.out.println("Невірний ввід. Введіть число 1, 2, 3 або 4:");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 1 || choice > 4) {
                System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1:
                return "Яблуня";
            case 2:
                return "Груша";
            case 3:
                return "Слива";
            case 4:
                return "Абрикоса";
            default:
                return "невідома";
        }
    }

    /**
     * Метод для збереження інформації про всі дерева у текстовий файл.
     * @param trees Масив дерев для збереження.
     * @param fileName Ім'я файлу для збереження.
     */
    public static void saveTreesToFile(Tree[] trees, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Tree tree : trees) {
                writer.write(tree.getDescription());
                writer.newLine(); // Додаємо новий рядок після кожного дерева
            }
        } catch (IOException e) {
            System.out.println("Сталася помилка при записі у файл: " + e.getMessage());
        }
    }
}
