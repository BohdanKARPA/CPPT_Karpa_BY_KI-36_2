package Lab6KarpaBohdan36;

// Клас, що реалізує споруду
public class Building {
    private String name;      // Назва споруди
    private int height;       // Висота споруди (в метрах)

    // Конструктор
    public Building(String name, int height) {
        this.name = name;
        this.height = height;
    }

    // Метод для отримання назви
    public String getName() {
        return name;
    }

    // Метод для отримання висоти
    public int getHeight() {
        return height;
    }

    // Перевизначення методу toString для виведення інформації
    @Override
    public String toString() {
        return "Building{name='" + name + "', height=" + height + " meters}";
    }
}
