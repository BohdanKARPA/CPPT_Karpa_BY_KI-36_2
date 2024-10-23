package Lab6KarpaBohdan36;

public class Building {
    private final String name;   // Назва будівлі
    private final double height;  // Висота будівлі
    private final double area;    // Площа будівлі
    private final int floors;     // Кількість поверхів
    private final String type;    // Тип будівлі (наприклад, "Житловий", "Офісний", "Комерційний")
    private final int yearBuilt;  // Рік побудови

    // Конструктор для створення об'єкта будівлі
    public Building(String name, double height, double area, int floors, String type, int yearBuilt) {
        this.name = name;
        this.height = height;
        this.area = area;
        this.floors = floors;
        this.type = type;
        this.yearBuilt = yearBuilt;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return area;
    }

    public int getFloors() {
        return floors;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    // Метод для зручного виведення об'єкта у вигляді рядка (українською мовою)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Будівля{")
                .append("назва='").append(name).append('\'')
                .append(", висота=").append(height).append(" м")
                .append(", площа=").append(area).append(" кв.м")
                .append(", поверхи=").append(floors)
                .append(", тип='").append(type).append('\'')
                .append(", рік побудови=").append(yearBuilt)
                .append('}');
        return sb.toString();
    }
}
