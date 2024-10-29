package Lab6KarpaBohdan36;

import java.util.concurrent.atomic.AtomicReference;

public class Building {
    private final String name;   // Назва будівлі
    private final double height;  // Висота будівлі
    private final double area;    // Площа будівлі
    private final int floors;     // Кількість поверхів
    private final String type;    // Тип будівлі (наприклад, "Житловий", "Офісний", "Комерційний")
    private final int yearBuilt;  // Рік побудови

    // Конструктор для створення об'єкта будівлі
    public Building(String name, double height, double area, int floors, String type, int yearBuilt) {
        this.name = name;          // Ініціалізуємо назву будівлі
        this.height = height;      // Ініціалізуємо висоту будівлі
        this.area = area;          // Ініціалізуємо площу будівлі
        this.floors = floors;      // Ініціалізуємо кількість поверхів
        this.type = type;          // Ініціалізуємо тип будівлі
        this.yearBuilt = yearBuilt; // Ініціалізуємо рік побудови
    }

    // Метод для отримання висоти будівлі
    public double getHeight() { return height; }

    // Метод для отримання площі будівлі
    public double getArea() {
        return area;
    }

    // Метод для отримання кількості поверхів
    public int getFloors() {
        return floors;
    }

    // Метод для отримання року побудови
    public int getYearBuilt() {
        return yearBuilt;
    }

    // Метод для зручного виведення об'єкта у вигляді рядка (українською мовою)
    @Override
    public String toString() {
        // Використовуємо AtomicReference для потокобезпечного створення рядка
        AtomicReference<StringBuilder> sb = new AtomicReference<>(new StringBuilder());

        // Формуємо опис будівлі у вигляді рядка
        sb.get().append("Будівля{")
                .append("назва='").append(name).append('\'')
                .append(", висота=").append(height).append(" м")
                .append(", площа=").append(area).append(" кв.м")
                .append(", поверхи=").append(floors)
                .append(", тип='").append(type).append('\'')
                .append(", рік побудови=").append(yearBuilt)
                .append('}');

        // Повертаємо отриманий рядок
        return sb.toString();
    }
}
