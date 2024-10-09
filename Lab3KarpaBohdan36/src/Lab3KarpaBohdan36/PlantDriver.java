package Lab3KarpaBohdan36;

import java.io.*;
import java.util.Scanner;

public class PlantDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть кількість дерев:");
        int treeCount = scanner.nextInt();
        scanner.nextLine(); // Очищуємо лінію після вводу числа

        Tree[] trees = new Tree[treeCount];

        for (int i = 0; i < treeCount; i++) {
            System.out.println("\nСтворюється дерево " + (i + 1) + ":");
            trees[i] = createTree(scanner);
            System.out.println(trees[i].getDescription());
        }

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

            saveTreesToFile(trees, "trees.txt"); // Оновлення файлу після змін
        }

        scanner.close();
    }

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

    public static String selectTreeType(Scanner scanner) {
        int choice;
        do {
            System.out.println("1. Дуб\n2. Ялина\n3. Береза\n4. Клен");
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
                return "дуб";
            case 2:
                return "ялина";
            case 3:
                return "береза";
            case 4:
                return "клен";
            default:
                return "невідома";
        }
    }

    public static void saveTreesToFile(Tree[] trees, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Tree tree : trees) {
                writer.write("Тип дерева: " + tree.getTreeType() + "\n");
                writer.write("Корінь: " + tree.getRoot().toString() + "\n");
                writer.write("Стебло: " + tree.getStem().toString() + "\n");
                writer.write("Листя: " + tree.getLeaves().toString() + "\n");
                writer.write("Кількість плодів: " + tree.getFruitCount() + "\n\n");
            }
            System.out.println("Дані дерев успішно збережено у файл " + filename);
        } catch (IOException e) {
            System.err.println("Помилка при запису у файл: " + e.getMessage());
        }
    }
}
