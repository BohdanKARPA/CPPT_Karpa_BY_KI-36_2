package Lab2KarpaBohdan36;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Plant {
    private Root root;
    private Stem stem;
    private Leaves leaves;

    // Конструктор за замовчуванням
    public Plant() {
        this.root = new Root("unknown");
        this.stem = new Stem(0.0);
        this.leaves = new Leaves("unknown");
        logActivity("Рослину створено з значеннями за замовчуванням.");
    }

    // Конструктор з параметрами
    public Plant(Root root, Stem stem, Leaves leaves) {
        this.root = root;
        this.stem = stem;
        this.leaves = leaves;
        logActivity("Рослину створено з вказаними значеннями: " + getDescription());
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
        logActivity("Тип кореня оновлено на: " + root.getRootType());
    }

    public Stem getStem() {
        return stem;
    }

    public void setStem(Stem stem) {
        this.stem = stem;
        logActivity("Стебло оновлено на висоту: " + stem.getHeight() + " см");
    }

    public Leaves getLeaves() {
        return leaves;
    }

    public void setLeaves(Leaves leaves) {
        this.leaves = leaves;
        logActivity("Листя оновлено на форму: " + leaves.getLeafShape());
    }

    /**
     * Метод для отримання опису рослини.
     *
     * @return Опис рослини у вигляді рядка.
     */
    public String getDescription() {
        return "Рослина:\n" + root + "\n" + stem + "\n" + leaves;
    }

    /**
     * Метод для ведення логу в файл.
     *
     * @param message Повідомлення для запису в лог.
     */
    private void logActivity(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter("activity_log.txt", true))) {
            out.println(message);
        } catch (IOException e) {
            System.out.println("Помилка запису в лог: " + e.getMessage());
        }
    }

    /**
     * Метод для коректного завершення роботи з файлом.
     */
    public void closeLog() {
        logActivity("Операції з рослиною завершено. Опис: " + getDescription());
    }

    /**
     * Метод для зміни типу кореня рослини.
     *
     * @param newRootType Новий тип кореня.
     */
    public void changeRootType(String newRootType) {
        this.root.setRootType(newRootType);
        logActivity("Тип кореня змінено на: " + newRootType);
    }

    /**
     * Метод для зміни висоти стебла рослини.
     *
     * @param newHeight Нова висота стебла в сантиметрах.
     */
    public void changeStemHeight(double newHeight) {
        if (newHeight < 0) {
            System.out.println("Висота стебла не може бути від'ємною. Спробуйте ще раз.");
            return;
        }
        this.stem.setHeight(newHeight);
        logActivity("Висота стебла змінена на: " + newHeight + " см");
    }

    /**
     * Метод для зміни форми листя рослини.
     *
     * @param newLeafShape Нова форма листя.
     */
    public void changeLeafShape(String newLeafShape) {
        this.leaves.setLeafShape(newLeafShape);
        logActivity("Форма листя змінена на: " + newLeafShape);
    }
}
